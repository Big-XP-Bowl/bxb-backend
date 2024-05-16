package dat3.bxb.configuration;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

import java.util.Optional;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    PasswordEncoder passwordEncoder;
    String passwordUsedByAll;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, PasswordEncoder passwordEncoder) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.passwordEncoder = passwordEncoder;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        setupUserWithRoleUsers();
    }
    private void setupUserWithRoleUsers() {
        System.out.println("Setup users");
        saveUserWithRoles("user1", passwordUsedByAll, "user1@a.dk", Role.USER);
        saveUserWithRoles("user2", passwordUsedByAll, "user2@a.dk", Role.ADMIN, Role.BAR, Role.MAINTENANCE, Role.USER); //Admins can also be bartenders/maintenance/users
        saveUserWithRoles("user3", passwordUsedByAll, "user3@a.dk", Role.BAR, Role.USER); //Bar personal can also be users
        saveUserWithRoles("user4", passwordUsedByAll, "user4@a.dk", Role.MAINTENANCE);
    }

    private void saveUserWithRoles(String username, String password, String email, Role... roles) {
        Optional<UserWithRoles> existingUser = Optional.ofNullable(userWithRolesRepository.findByUsername(username));
        if (existingUser.isPresent()) {
            System.out.println("User " + username + " already exists. Skipping.");
            return;
        }
        UserWithRoles user = new UserWithRoles(username, password, email);
        for (Role role : roles) {
            user.addRole(role);
        }
        userWithRolesRepository.save(user);
    }
}
