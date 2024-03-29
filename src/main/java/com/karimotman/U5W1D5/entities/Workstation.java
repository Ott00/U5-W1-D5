package com.karimotman.U5W1D5.entities;

import com.karimotman.U5W1D5.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "workstations")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private WorkstationType workstationType;
    @Column(name = "max_user")
    private int maxUser;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @OneToMany(mappedBy = "workstation")
    @ToString.Exclude
    private List<Reservation> workstationList;

    public Workstation(String description, WorkstationType workstationType, int maxUser, Building building) {
        this.description = description;
        this.workstationType = workstationType;
        this.maxUser = maxUser;
        this.building = building;
    }
}
