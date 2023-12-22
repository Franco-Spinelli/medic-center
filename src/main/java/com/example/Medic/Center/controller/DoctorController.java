package com.example.Medic.Center.controller;

import com.example.Medic.Center.model.dto.AppointmentDTO;
import com.example.Medic.Center.model.dto.DoctorDTO;
import com.example.Medic.Center.model.dto.MedicalSpecialtyDTO;
import com.example.Medic.Center.model.entity.Doctor;
import com.example.Medic.Center.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        if(doctorService.findAll().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<DoctorDTO>doctorDTOList = doctorService.findAll().stream()
                .map(doctor -> DoctorDTO.builder()
                        .id_doctor(doctor.getId_doctor())
                        .name(doctor.getName())
                        .lastName(doctor.getLastName())
                        .medicalSpecialty(doctor.getMedicalSpecialty().getTitle())
                        .appointmentList(doctor.getAppointmentList().stream()
                                .map(appointment -> AppointmentDTO.builder()
                                        .date(appointment.getDate())
                                        .appointment_time(appointment.getAppointment_time())
                                        .id_appointment(appointment.getId_appointment())
                                        .id_doctor(doctor.getId_doctor())
                                        .id_patient(appointment.getPatient().getId_patient()).build()).toList()
                        ).build()).toList();
        return ResponseEntity.ok(doctorDTOList);
    }
    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody Doctor doctor){
        doctorService.save(doctor);
        return ResponseEntity.ok("Save success ");
    }
}
