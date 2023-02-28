package org.neworld.springbootmvc.service;

import org.neworld.springbootmvc.entity.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.neworld.springbootmvc.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
    List<Role> getListRoles();
    List<Role> getListByRole(List<String> name);
    boolean saveUser(User user);
    Set<User> getSetUsers();
    void deleteById(Long id);
    void updateUser(User user);
    User findById(Long id);
    User findByUsername(String username);
}
