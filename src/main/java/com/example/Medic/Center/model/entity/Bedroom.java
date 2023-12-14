package com.example.Medic.Center.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bedroom")
public class Bedroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bedroom;
    @Column(name = "hospitalSector")
    private String hospitalSector;
    @Column(name = "occupancyStatus")
    private boolean occupancyStatus;
    @Column(name = "capacity")
    private Integer capacity;
    @OneToOne(mappedBy = "bedroom", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Patient>patientList = new ArrayList<>();
    @ManyToMany(mappedBy = "bedrooms")
    private List<Appointment> appointmentList = new ArrayList<>();
}
