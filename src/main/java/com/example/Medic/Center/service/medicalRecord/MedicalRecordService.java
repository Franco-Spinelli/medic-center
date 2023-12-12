package com.example.Medic.Center.service.medicalRecord;

import com.example.Medic.Center.model.entity.Doctor;
import com.example.Medic.Center.model.entity.MedicalRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MedicalRecordService {
    List<MedicalRecord> findAll();
    Optional<MedicalRecord> findByPatientId(Integer id);
    void save (MedicalRecord medicalRecord);
    void delete(MedicalRecord medicalRecord);
}
