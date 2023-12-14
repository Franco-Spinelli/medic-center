package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> id_appointmentsList = new ArrayList<>();
}
