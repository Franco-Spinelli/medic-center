package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.Patient;
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
public class BedroomDTO {
    private Integer id_bedroom;
    private String hospitalSector;
    private boolean occupancyStatus;
    private Integer capacity;
    private List<Integer>id_patientsList = new ArrayList<>();
    public BedroomDTO(Bedroom bedroom) {
        this.id_bedroom = bedroom.getId_bedroom();
        this.hospitalSector = bedroom.getHospitalSector();
        this.occupancyStatus = bedroom.isOccupancyStatus();
        this.capacity = bedroom.getCapacity();
        this.id_patientsList = bedroom.getPatientList().stream()
                .map(Patient::getId_patient)
                .collect(Collectors.toList());
    }

}
