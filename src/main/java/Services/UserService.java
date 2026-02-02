package Services;

import com.example.movie_rate.models.Roles;
import com.example.movie_rate.models.User;
import com.example.movie_rate.repositories.RolesRepository;
import com.example.movie_rate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public User register (String username, String mail, String password) {

        if(userRepository.existsByEmail(mail)) {
            throw new RuntimeException("Email invalide. Déjà utilisé par un utilisateur.");
        }

        User user = new User();
        user.setUsername(username);
        user.setMail(mail);

        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);

        Roles userRole = rolesRepository.findByName("ROLE_USER")
                        .orElseThrow(() -> new RuntimeException("Role USER non trouvé"));

        user.setRoles(userRole);

        return userRepository.save(user);
    }

    public User login(String mail, String password) {
        User user = userRepository.findByEmail(mail).orElseThrow(() -> new RuntimeException("Email incorrect"));

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException(("Mot de passe incorrect"));
        }

        return jwtService.generateToken(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User updateUser (Integer id, String username, String mail) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));

        if(!user.getMail().equals(mail) && userRepository.existsByEmail(mail)) {
            throw new RuntimeException("Mail déjà utilisé");
        }

        user.setUsername(username);
        user.setMail(mail);

        return userRepository.save(user);
    }

    public void changePassword(Integer id, String oldPassword, String newPassword) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));

        if(!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("L'ancien mot de passe est incorrect");
        }

        user.setPassword((passwordEncoder.encode(newPassword)));
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {

        if(!userRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur inconnu");
        }

        userRepository.deleteById(id);
    }
}
