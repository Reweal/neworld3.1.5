package org.neworld.springbootmvc.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neworld.springbootmvc.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.neworld.springbootmvc.entity.Role;

import java.util.List;

@Service
@Data
@Setter
@NoArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        Role temp = roleRepository.findByRole(role.getRole());
        if (temp == null) {
            roleRepository.save(role);
        }
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findAllById(List<Long> id) {
        return roleRepository.findAllById(id);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }
}