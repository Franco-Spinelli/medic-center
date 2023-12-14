package com.example.Medic.Center.service.bedroom;

import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BedroomService {
    List<Bedroom> findAll();
    Optional<Bedroom> findById(Integer id);
    void deletePatientInBedroomById(Integer id_patient, Integer id_bedroom);
    void increaseSize(Integer number, Integer id_bedroom);
    void addPatientInBedroomById(Integer id_patient, Integer id_bedroom);
    void save (Bedroom bedroom);
    void delete(Integer id_bedroom);
}
