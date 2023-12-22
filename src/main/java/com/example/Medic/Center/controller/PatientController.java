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
        List<Patient>patientList = patientService.findAll();
        List<PatientDTO>patientDTOList = new ArrayList<>();
        for (Patient patient:patientList) {
            PatientDTO patientDTO = new PatientDTO(patient);
            patientDTOList.add(patientDTO);
        }

        return ResponseEntity.ok(patientDTOList);
    }
    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody Patient patient){
        patientService.save(patient);
        return ResponseEntity.ok(patient);
        }

    }

