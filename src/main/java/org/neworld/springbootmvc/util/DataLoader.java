package org.neworld.springbootmvc.util;

import org.neworld.springbootmvc.entity.Role;
import org.neworld.springbootmvc.entity.User;
import org.neworld.springbootmvc.service.RoleService;
import org.neworld.springbootmvc.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {
    private final RoleService roleService;
    private final UserService userService;

    public DataLoader(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("Admin@admin");
        admin.setAge(30);
        admin.setUsername("admin");
        admin.setPassword("admin"); // password is "admin"

        Role adminRole = new Role();
        adminRole.setRole("ROLE_ADMIN");
        roleService.saveRole(adminRole);

        admin.setRoles(Collections.singleton(adminRole));

        User user = new User();
        user.setFirstName("User");
        user.setLastName("User");
        user.setEmail("user@user");
        user.setAge(25);
        user.setUsername("user");
        user.setPassword("user"); // password is "user"

        Role userRole = new Role();
        userRole.setRole("ROLE_USER");
        roleService.saveRole(userRole);

        user.setRoles(Collections.singleton(userRole));

        userService.saveUser(admin);
        userService.saveUser(user);
    }
}

