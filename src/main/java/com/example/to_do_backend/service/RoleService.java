package com.example.to_do_backend.service;

import com.example.to_do_backend.entity.Role;
import com.example.to_do_backend.entity.Task;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getByIdRole(Long id);
    List<Role> getAllRoles();
    Role updateRole(Long id,Role role);
    void deleteRole(Long id);
}
