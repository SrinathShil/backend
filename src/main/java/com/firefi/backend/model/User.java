package com.firefi.backend.model;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "app_user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password; // Store hashed in production
    private String email;

}