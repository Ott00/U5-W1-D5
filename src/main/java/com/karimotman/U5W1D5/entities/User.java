package com.karimotman.U5W1D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private String name;
    private String email;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Reservation> reservationList;

    public User(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }
}
