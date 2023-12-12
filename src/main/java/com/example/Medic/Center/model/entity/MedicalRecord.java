package com.example.Medic.Center.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "medicalRecord")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_medicalRecord;
    @Column(name = "previousIllnesses")
    private  List<String> previousIllnesses;
    @Column(name = "vaccinationRecord")
    private  List<String> vaccinationRecord;
    @Column(name = "currentMedications")
    private  List<String> currentMedications;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private Patient patient;
}
