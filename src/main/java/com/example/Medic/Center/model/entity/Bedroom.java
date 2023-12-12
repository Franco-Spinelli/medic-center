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
    @ManyToMany(mappedBy = "bedrooms")
    private List<Appointment> appointmentList = new ArrayList<>();
}
