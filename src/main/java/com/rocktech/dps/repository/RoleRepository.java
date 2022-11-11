package com.rocktech.dps.repository;

import com.rocktech.dps.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
