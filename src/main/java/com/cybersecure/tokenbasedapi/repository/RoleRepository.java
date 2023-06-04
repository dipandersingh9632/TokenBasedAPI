package com.cybersecure.tokenbasedapi.repository;

import com.cybersecure.tokenbasedapi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
