package com.example.to_do_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="name")
    String name;
    @Column(name = "user_name")
    String userName;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn (name = "user_id", referencedColumnName = "id"),
       inverseJoinColumns =     @JoinColumn(name ="role_id",referencedColumnName = "id") )
    private Set<Role> role ;
}
