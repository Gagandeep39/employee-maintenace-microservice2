package com.cg.employeevalidationservice.repository;

import com.cg.employeevalidationservice.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
