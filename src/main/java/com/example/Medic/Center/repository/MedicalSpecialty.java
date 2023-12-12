package com.example.Medic.Center.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalSpecialty extends JpaRepository<MedicalSpecialty,Integer> {
}
