package com.example.Medic.Center.service.patient;

import com.example.Medic.Center.exception.RoomOccupiedException;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.Patient;
import com.example.Medic.Center.repository.BedroomRepository;
import com.example.Medic.Center.repository.PatientRepository;
import com.example.Medic.Center.service.bedroom.BedroomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class PatientImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.isEmpty() ? Collections.emptyList() : patients;
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        if(patientRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        return patientRepository.findById(id);
    }

    @Override
    public void save(Patient patient){
        //if the patient have -0 age throws the exception.
        if(patient.getAge()<0){
            throw new IllegalArgumentException("The patient's age cannot be negative.");
        }
        patientRepository.save(patient);
    }

    @Override
    public void delete(Patient patient) {
        //if the patient not exist throws the exception.
        if (!patientRepository.existsById(patient.getId_patient())) {
            throw new EntityNotFoundException("Patient with ID: " + patient.getId_patient() + " not found.");
        }
        patientRepository.delete(patient);
    }
}
