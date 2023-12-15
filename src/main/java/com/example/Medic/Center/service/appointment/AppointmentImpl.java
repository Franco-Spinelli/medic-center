package com.example.Medic.Center.service.appointment;

import com.example.Medic.Center.exception.RoomOccupiedException;
import com.example.Medic.Center.model.entity.Appointment;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.Patient;
import com.example.Medic.Center.repository.AppointmentRepository;
import com.example.Medic.Center.service.bedroom.BedroomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AppointmentImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private BedroomService bedroomService;

    @Override
    public List<Appointment> findAll() {
        List<Appointment>appointmentList = appointmentRepository.findAll();
        return appointmentList.isEmpty()? Collections.emptyList(): appointmentList;
    }

    @Override
    public Optional<Appointment> findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void save(Appointment appointment) {
        List<Bedroom> bedrooms = appointment.getBedrooms();
        Patient patient = appointment.getPatient();
        for (Bedroom bedroom: bedrooms) {
            try {
                bedroomService.addPatientInBedroomById(patient.getId_patient(),bedroom.getId_bedroom());
            }catch (RoomOccupiedException e){
                System.out.printf(e.getMessage());
            }
        }
        appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Integer id_appointment) {
        if(!appointmentRepository.existsById(id_appointment)){
            throw new EntityNotFoundException("Appointment with ID: " + id_appointment + " not found.");
        }
        appointmentRepository.deleteById(id_appointment);
    }
}
