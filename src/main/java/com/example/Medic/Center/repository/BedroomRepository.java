package com.example.Medic.Center.repository;

import com.example.Medic.Center.model.entity.Bedroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedroomRepository extends JpaRepository<Bedroom,Integer> {
}
