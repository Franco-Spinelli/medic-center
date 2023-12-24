package com.example.Medic.Center.controller;

import com.example.Medic.Center.model.dto.AppointmentDTO;
import com.example.Medic.Center.model.dto.DoctorDTO;
import com.example.Medic.Center.model.dto.MedicalSpecialtyDTO;
import com.example.Medic.Center.model.entity.Doctor;
import com.example.Medic.Center.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Doctor>doctorList = doctorService.findAll();
        List<DoctorDTO>doctorDTOList = new ArrayList<>();
        for (Doctor doctor:doctorList) {
            DoctorDTO doctorDTO = new DoctorDTO(doctor);
            doctorDTOList.add(doctorDTO);
        }
        return ResponseEntity.ok(doctorDTOList);
    }
    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody Doctor doctor){
        doctorService.save(doctor);
        return ResponseEntity.ok("Save success ");
    }
}
