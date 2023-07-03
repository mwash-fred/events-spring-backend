package apps.myuzinc.events.config;

import apps.myuzinc.events.dao.Permissions.PermissionsRepository;
import apps.myuzinc.events.dao.Roles.Role;
import apps.myuzinc.events.dao.Roles.RoleRepository;
import apps.myuzinc.events.dao.Users.Users;
import apps.myuzinc.events.dao.Users.UsersRepository;
import apps.myuzinc.events.utils.enums.Permissions;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component @Transactional
@RequiredArgsConstructor
public class UserInitializer implements ApplicationRunner {
    private static final String ADMIN =  "ADMIN";
    private static final String ROLE_ADMIN =  "ROLE_ADMIN";
    private final UsersRepository usersRepository;
    private final PermissionsRepository permissionsRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) {
        try {
            initializer();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void initializer(){
        Authentication anonymousAuth = new AnonymousAuthenticationToken(
                "SYSTEM",
                "SYSTEM",
                List.of(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))
        );
        SecurityContextHolder.getContext().setAuthentication(anonymousAuth);

        List<apps.myuzinc.events.dao.Permissions.Permissions> permissions = Arrays
                .stream(Permissions.values())
                .map(permission -> {
                    if (!permissionsRepository.existsByName(permission)) {  // Pass the enum instance
                        return permissionsRepository.save(apps.myuzinc.events.dao.Permissions.Permissions.builder()
                                .name(permission)
                                .build());
                    }
                    return null;
                })
                .toList();

        Role role = Role.builder()
                .name(ROLE_ADMIN)
                .privileges(permissions)
                .build();
        if(!roleRepository.existsByName(ROLE_ADMIN)){
            roleRepository.save(role);
        }
        if(!usersRepository.existsByEmail(ADMIN)){
            usersRepository.save(Users.builder()
                            .roles(List.of(role))
                            .email("admin@myuzinc.com")
                            .mobileNo("254708881885")
                            .name("Myuzinc Admin")
                            .isEnabled(true)
                            .isCredentialsExpired(false)
                            .isAccountLocked(false)
                            .isAccountExpired(false)
                            .password(passwordEncoder.encode("password"))
                    .build()
            );
        }
    }
}
