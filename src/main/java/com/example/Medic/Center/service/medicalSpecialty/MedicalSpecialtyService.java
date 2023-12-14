package com.example.Medic.Center.service.medicalSpecialty;

import com.example.Medic.Center.model.entity.MedicalRecord;
import com.example.Medic.Center.model.entity.MedicalSpecialty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MedicalSpecialtyService {
    List<MedicalSpecialty> findAll();
    Optional<MedicalSpecialty> findBySpecialtyId(Integer id);
    void save (MedicalSpecialty medicalSpecialty);
    void delete(MedicalSpecialty medicalSpecialty);
}
