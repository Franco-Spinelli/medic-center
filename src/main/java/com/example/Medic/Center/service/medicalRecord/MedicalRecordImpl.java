package com.example.Medic.Center.service.medicalRecord;

import com.example.Medic.Center.model.entity.MedicalRecord;
import com.example.Medic.Center.model.entity.MedicalSpecialty;
import com.example.Medic.Center.model.entity.Patient;
import com.example.Medic.Center.repository.MedicalRecordRepository;
import com.example.Medic.Center.repository.PatientRepository;
import com.example.Medic.Center.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class MedicalRecordImpl implements MedicalRecordService{
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Autowired
    private PatientService patientService;
    @Override
    public List<MedicalRecord> findAll() {
        List<MedicalRecord> medicalRecord = medicalRecordRepository.findAll();
        return medicalRecord.isEmpty() ? Collections.emptyList() : medicalRecord;
    }

    @Override
    public MedicalRecord findByPatientId(Integer id) {

        return medicalRecordRepository.findByPatientId(id);
    }

    @Override
    public void save(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public void delete(Integer id) {
        medicalRecordRepository.deleteById(id);
    }
}
