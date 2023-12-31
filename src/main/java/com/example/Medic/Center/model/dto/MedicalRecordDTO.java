package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MedicalRecordDTO {
    private Integer id_medicalRecord;
    private String previousIllness;
    private  String currentMedication;
    private Integer id_patient;
}
