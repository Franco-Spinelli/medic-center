package com.example.Medic.Center.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_appointment;
    @Column(name = "appointment_date")
    private Date date;
    @Column(name = "appointment_time")
    private String appointment_time;
    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;
}
