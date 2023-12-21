package com.example.Medic.Center.controller;

import com.example.Medic.Center.exception.RoomOccupiedException;
import com.example.Medic.Center.model.dto.*;
import com.example.Medic.Center.model.entity.*;
import com.example.Medic.Center.repository.BedroomRepository;
import com.example.Medic.Center.service.bedroom.BedroomService;
import com.example.Medic.Center.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("/findAll")
    public ResponseEntity<?>findAll(){
        List<PatientDTO>patientDTOList = patientService.findAll().stream()
                .map(patient -> PatientDTO.builder()
                        .id_patient(patient.getId_patient())
                        .age(patient.getAge())
                        .name(patient.getName())
                        .dni(patient.getDni())
                        .lastName(patient.getLastName())
                        .height(patient.getHeight())
                        .weight(patient.getWeight())
                        /*
                        .medicalRecord(MedicalRecordDTO.builder()
                                .id_patient(patient.getId_patient())
                                .id_medicalRecord(patient.getMedicalRecord().getId_medicalRecord())
                                .currentMedication(patient.getMedicalRecord().getCurrentMedication())
                                .previousIllness(patient.getMedicalRecord().getPreviousIllness()).build())

                         */
                        .id_bedroom((patient.getBedroom().getId_bedroom()!= null && patient.getBedroom().getId_bedroom() > 0) ? patient.getBedroom().getId_bedroom() : 0)
                        /*
                        .appointmentList(patient.getAppointmentList().stream()
                                .map(appointment -> AppointmentDTO.builder()
                                        .id_appointment(appointment.getId_appointment())
                                        .id_patient(appointment.getPatient().getId_patient())
                                        .date(appointment.getDate())
                                        .id_doctor(appointment.getDoctor().getId_doctor())
                                        .appointment_time(appointment.getAppointment_time())
                                        .build()).toList())

                         */
                        .build()).toList();
        return ResponseEntity.ok(patientDTOList);
    }
    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody Patient patient){
        patientService.save(patient);
        return ResponseEntity.ok(patient);
        }

    }

