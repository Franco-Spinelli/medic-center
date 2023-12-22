package com.example.Medic.Center.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignBedroomDTO {
    private Integer id_patient;
    private Integer id_bedroom;
}
