package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.MedicalRecord;
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
}
