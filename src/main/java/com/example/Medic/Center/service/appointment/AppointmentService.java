package com.example.Medic.Center.service.appointment;

import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Bedroom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService {
    List<Appointment> findAll();
    Optional<Appointment> findById(Integer id);
    void save (Appointment appointment);
    void delete(Integer id_appointment);
}
