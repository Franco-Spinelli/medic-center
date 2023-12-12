package com.example.Medic.Center.service.doctor;

import com.example.Medic.Center.model.entity.Doctor;
import com.example.Medic.Center.model.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    List<Doctor> findAll();
    Optional<Doctor> findById(Integer id);
    void save (Doctor doctor);
    void delete(Doctor doctor);
}
