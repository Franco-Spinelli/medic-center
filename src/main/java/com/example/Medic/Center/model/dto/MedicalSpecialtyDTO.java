package com.example.Medic.Center.model.dto;

import com.example.Medic.Center.model.entity.Doctor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalSpecialtyDTO {
    private Integer id_MedicalSpecialty;
    private String title;
    private String desc;
    private List<Integer> id_doctorList = new ArrayList<>();
}
