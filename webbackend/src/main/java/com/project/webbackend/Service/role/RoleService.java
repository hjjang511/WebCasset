package com.project.webbackend.Service.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.project.webbackend.Entity.Role;
import com.project.webbackend.Repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService{
    private final RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
