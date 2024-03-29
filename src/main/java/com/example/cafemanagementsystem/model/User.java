package com.example.cafemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
@NamedQuery(name = "User.findByEmaild",query = "select u from user u where u.email=:email")
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "user")
public class User implements Serializable {
private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "contact_number")
    private  String contactNumber;

    @Column(name = "password")
    private  String password;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private  String status;

    @Column(name = "role")
    private String role;
}
