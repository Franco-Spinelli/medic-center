package com.example.Medic.Center.service.medicalSpecialty;

import com.example.Medic.Center.model.entity.MedicalSpecialty;
import com.example.Medic.Center.repository.MedicalSpecialtyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Component

public class MedicalSpecialtyImpl implements MedicalSpecialtyService{
    @Autowired
    private MedicalSpecialtyRepository medicalSpecialtyRepository;

    @Override
    public List<MedicalSpecialty> findAll() {
        List<MedicalSpecialty> medicalSpecialties = medicalSpecialtyRepository.findAll();
        return medicalSpecialties.isEmpty() ? Collections.emptyList() : medicalSpecialties;

    }

    @Override
    public Optional<MedicalSpecialty> findBySpecialtyId(Integer id) {
        if(medicalSpecialtyRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        return medicalSpecialtyRepository.findById(id);
    }

    @Override
    public void save(MedicalSpecialty medicalSpecialty){
      if(medicalSpecialty.getDesc().isBlank()){
          throw new IllegalArgumentException("description cannot be blank.");
      }
      medicalSpecialtyRepository.save(medicalSpecialty);
    }

    @Override
    public void delete(MedicalSpecialty medicalSpecialty){
        if (!medicalSpecialtyRepository.existsById(medicalSpecialty.getId_MedicalSpecialty())) {
            throw new EntityNotFoundException("medical specialty with ID: " + medicalSpecialty.getId_MedicalSpecialty() + " not found.");
        }
        medicalSpecialtyRepository.delete(medicalSpecialty);
    }
}
