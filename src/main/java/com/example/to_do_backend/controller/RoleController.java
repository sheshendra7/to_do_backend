package com.example.to_do_backend.controller;

import com.example.to_do_backend.entity.Role;
import com.example.to_do_backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getByIdRole(@PathVariable("id") Long id){
        return ResponseEntity.ok(roleService.getByIdRole(id));
    }

    @GetMapping("/allroles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") Long id,@RequestBody Role role){
        return ResponseEntity.ok(roleService.updateRole(id,role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok("Successfully Deleted the role");
    }
}
