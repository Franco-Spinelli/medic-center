package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.MedicalRecord;
import com.example.Medic.Center.model.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientDTO {
    private Integer id_patient;
    private String name;
    private String lastName;
    private String dni;
    private Integer age;
    private float weight;
    private float height;
    private Integer id_bedroom;
    //private MedicalRecordDTO medicalRecord;
    //private List<AppointmentDTO> appointmentList = new ArrayList<>();
    public PatientDTO(Patient patient) {
        this.id_patient = patient.getId_patient();
        this.name = patient.getName();
        this.lastName = patient.getLastName();
        this.dni = patient.getDni();
        this.age = patient.getAge();
        this.weight = patient.getWeight();
        this.height = patient.getHeight();
        this.id_bedroom = patient.getBedroom().getId_bedroom();
    }
}
