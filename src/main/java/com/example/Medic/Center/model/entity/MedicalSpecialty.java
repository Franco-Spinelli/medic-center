package com.example.Medic.Center.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicalSpecialty")
public class MedicalSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_MedicalSpecialty;
    @Column(name = "title")
    private String title;
    @Column(name = "desc")
    private String desc;
    @OneToMany(mappedBy = "medicalSpecialty", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Doctor> doctorList = new ArrayList<>();
}
