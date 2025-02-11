package com.project.webbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.webbackend.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
