package com.example.to_do_backend.service;

import com.example.to_do_backend.entity.Role;
import com.example.to_do_backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByIdRole(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Role"+id)
        );
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role newRole = roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Role"+id)
        );
        newRole.setName(role.getName());
        roleRepository.save(newRole);
        return newRole;
    }

    @Override
    public void deleteRole(Long id) {
    Role role = roleRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Not Found Role"+id)
    );
    roleRepository.deleteById(id);
    }
}
