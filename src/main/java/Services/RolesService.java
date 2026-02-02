package Services;

import com.example.movie_rate.models.Roles;
import com.example.movie_rate.models.User;
import com.example.movie_rate.repositories.RolesRepository;
import com.example.movie_rate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles createRole(String label) {

        if (rolesRepository.existsByLabel(label)) {
            throw new RuntimeException("Ce rôle existe déjà");
        }

        Roles role = new Roles();
        role.setLabel(label);

        return rolesRepository.save(role);
    }

    public Roles updateRole(Integer id, String label) {
        Roles role = rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));

        if (!role.getLabel().equals(label) && rolesRepository.existsByLabel(label)) {
            throw new RuntimeException("Ce rôle existe déjà");
        }

        role.setLabel(label);

        return rolesRepository.save(role);
    }

    public void deleteRole(Integer id) {
        if (!rolesRepository.existsById(id)) {
            throw new RuntimeException("Rôle non trouvé");
        }

        List<User> usersWithRole = userRepository.findByRolesId(id);
        if (!usersWithRole.isEmpty()) {
            throw new RuntimeException("Impossible de supprimer ce rôle");
        }

        rolesRepository.deleteById(id);
    }

}