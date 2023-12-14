package com.example.Medic.Center.service.doctor;

import com.example.Medic.Center.model.entity.Doctor;
import com.example.Medic.Center.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class DoctorImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        List<Doctor>doctorList = doctorRepository.findAll();
        return doctorList.isEmpty() ? Collections.emptyList() : doctorList;
    }

    @Override
    public Optional<Doctor> findById(Integer id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void delete(Doctor doctor) {
        if(!doctorRepository.existsById(doctor.getId_doctor())){
            throw new EntityNotFoundException("Doctor with ID: " + doctor.getId_doctor() + " not found.");
        }
        doctorRepository.delete(doctor);
    }
}
