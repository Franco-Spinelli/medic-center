package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Doctor;
import com.example.Medic.Center.model.entity.MedicalSpecialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Integer id_doctor;
    private String name;
    private String lastName;
    private String medicalSpecialty;
    private List<AppointmentDTO> appointmentList = new ArrayList<>();
    public DoctorDTO(Doctor doctor) {
        this.id_doctor = doctor.getId_doctor();
        this.name = doctor.getName();
        this.lastName = doctor.getLastName();
        this.medicalSpecialty = doctor.getMedicalSpecialty().getTitle();
        this.appointmentList = doctor.getAppointmentList().stream()
                .map(AppointmentDTO::new)
                .collect(Collectors.toList());
    }
}

