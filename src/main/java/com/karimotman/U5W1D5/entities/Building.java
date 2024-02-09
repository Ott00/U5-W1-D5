package com.karimotman.U5W1D5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "buildings")
@NoArgsConstructor
@Getter
@Setter
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "building")
    private List<Workstation> workstationList;

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}
