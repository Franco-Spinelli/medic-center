package com.example.Medic.Center.repository;

import com.example.Medic.Center.model.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer> {

    @Query("SELECT m FROM MedicalRecord m WHERE m.patient.id_patient = :id ")
    MedicalRecord findByPatientId(@Param("id") Integer id);
}
