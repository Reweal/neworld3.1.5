package org.neworld.springbootmvc.service;


import org.neworld.springbootmvc.entity.Role;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);

    List<Role> findAll();

    List<Role> findAllById(List<Long> id);

    Role findById(Long id);

}