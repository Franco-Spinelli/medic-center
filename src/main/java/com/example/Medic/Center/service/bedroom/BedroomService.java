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
    void save (Bedroom bedroom);
    void delete(Bedroom bedroom);
}
