package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.Doctor;
import com.example.Medic.Center.model.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {
    private Integer id_appointment;
    private Date date;
    private String appointment_time;
    private Integer id_doctor;
    private Integer id_patient;
    public AppointmentDTO(Appointment appointment) {
        this.id_appointment = appointment.getId_appointment();
        this.date = appointment.getDate();
        this.appointment_time = appointment.getAppointment_time();
        this.id_doctor = appointment.getDoctor().getId_doctor();
        this.id_patient = appointment.getPatient().getId_patient();
    }
}
