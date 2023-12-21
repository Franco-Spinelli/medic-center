package com.example.Medic.Center.controller;

import com.example.Medic.Center.service.bedroom.BedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bedroom")
public class BedroomController {
    @Autowired
    private BedroomService bedroomService;
    @PutMapping("/assignBedroom/{id_patient}/{id_bedroom}")
    public ResponseEntity<?>assignBedroom(@PathVariable(value = "id_patient") Integer id_patient, @PathVariable(value = "id_bedroom") Integer id_bedroom){
        bedroomService.addPatientInBedroomById(id_patient,id_bedroom);
        return ResponseEntity.ok().build();
    }
}
