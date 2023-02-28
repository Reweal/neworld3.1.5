package org.neworld.springbootmvc.repository;

import org.neworld.springbootmvc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from Role r where r.role = :role")
    Role findByRole(@Param("role") String role);

    @Query("select u from Role u where u.role in (:name)")
    List<Role> findAllByRole(@Param("name") List<String> name);

    @Query("select u from Role u")
    List<Role> findAll();
}
