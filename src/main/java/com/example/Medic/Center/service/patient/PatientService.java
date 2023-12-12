package com.example.Medic.Center.service.patient;

import com.example.Medic.Center.model.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {
    List<Patient>findAll();
    Optional<Patient> findById(Integer id);
    void save (Patient patient);
    void delete(Patient patient);
}
