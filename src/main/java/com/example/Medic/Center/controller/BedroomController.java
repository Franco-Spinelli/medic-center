package com.example.Medic.Center.controller;

import com.example.Medic.Center.model.dto.AssignBedroomDTO;
import com.example.Medic.Center.model.dto.BedroomDTO;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.service.bedroom.BedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/bedroom")
public class BedroomController {
    @Autowired
    private BedroomService bedroomService;

    @GetMapping("/findAll")
    public ResponseEntity<?>findAll(){
        List<Bedroom>bedrooms = bedroomService.findAll();
        List<BedroomDTO>bedroomDTOS = new ArrayList<>();
        for (Bedroom bedroom:bedrooms) {
            BedroomDTO bedroomDTO = new BedroomDTO(bedroom);
            bedroomDTOS.add(bedroomDTO);
        }
        return ResponseEntity.ok(bedroomDTOS);
    }

    @PutMapping("/assignBedroom")
    public ResponseEntity<?>assignBedroom(@RequestBody AssignBedroomDTO assignBedroomDTO){
        bedroomService.addPatientInBedroomById(assignBedroomDTO.getId_patient(),assignBedroomDTO.getId_bedroom());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/deletePatientInBedroom")
    public ResponseEntity<?>deletePatientInBedroom(@RequestBody AssignBedroomDTO assignBedroomDTO){
        bedroomService.deletePatientInBedroomById(assignBedroomDTO.getId_patient(),assignBedroomDTO.getId_bedroom());
        return ResponseEntity.ok().build();
    }



}
