package Services;

import com.example.movie_rate.models.Roles;
import com.example.movie_rate.models.User;
import com.example.movie_rate.repositories.RolesRepository;
import com.example.movie_rate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
}
