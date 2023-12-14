package com.example.Medic.Center.service.bedroom;

import com.example.Medic.Center.exception.RoomOccupiedException;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.Patient;
import com.example.Medic.Center.repository.BedroomRepository;
import com.example.Medic.Center.repository.PatientRepository;
import com.example.Medic.Center.service.patient.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BedroomImpl implements BedroomService{
    @Autowired
    private BedroomRepository bedroomRepository;
    @Autowired
    private PatientService patientService;

    @Override
    public List<Bedroom> findAll() {
        List<Bedroom>bedroomsList = bedroomRepository.findAll();
        return bedroomsList.isEmpty()? Collections.emptyList(): bedroomsList;
    }

    @Override
    public Optional<Bedroom> findById(Integer id) {
        return bedroomRepository.findById(id);
    }
    @Override
    public void deletePatientInBedroomById(Integer id_patient, Integer id_bedroom) {
       Optional<Patient>patientOptional =  patientService.findById(id_patient);
        if(patientOptional.isEmpty() || !patientOptional.get().getBedroom().getId_bedroom().equals(id_bedroom)){
            throw new EntityNotFoundException("Patient with ID: " + patientOptional.get().getId_patient() + " not found.");
        }
        Patient patient = patientOptional.get();
        patient.setBedroom(null);
        patientService.save(patient);
        Optional<Bedroom> bedroomOptional = bedroomRepository.findById(id_patient);
        Bedroom bedroom = bedroomOptional.get();
        bedroom.getPatientList().remove(patient);
        bedroomRepository.save(bedroom);
    }

    @Override
    public void increaseSize(Integer number, Integer id_bedroom) {
        Optional<Bedroom>bedroomOptional = bedroomRepository.findById(id_bedroom);
        if(bedroomOptional.isEmpty()){
            throw new EntityNotFoundException("Bedroom with ID: " + bedroomOptional.get().getId_bedroom() + " not found.");
        }
        Bedroom bedroom = bedroomOptional.get();
        bedroom.setCapacity(bedroom.getCapacity() + number);
        bedroomRepository.save(bedroom);
    }

    @Override
    public void addPatientInBedroomById(Integer id_patient, Integer id_bedroom) {
        Optional<Patient>patientOptional = patientService.findById(id_patient);
        if(patientOptional.isEmpty()){
            throw new EntityNotFoundException("Patient with ID: " + patientOptional.get().getId_patient() + " not found.");
        }
        Optional<Bedroom>bedroomOptional = bedroomRepository.findById(id_bedroom);
        if(bedroomOptional.isEmpty()){
            throw new EntityNotFoundException("Bedroom with ID: " + bedroomOptional.get().getId_bedroom() + " not found.");
        }
        Bedroom bedroom = bedroomOptional.get();
        if(bedroom.isOccupancyStatus()){
            throw new RoomOccupiedException();

        }
        Patient patient = patientOptional.get();
        bedroom.getPatientList().add(patient);
        if(bedroom.getPatientList().size() == bedroom.getCapacity()){
            bedroom.setOccupancyStatus(true);
        }
        bedroomRepository.save(bedroom);
        patient.setBedroom(bedroom);
        patientService.save(patient);
    }

    @Override
    public void save(Bedroom bedroom) {
        bedroomRepository.save(bedroom);
    }

    @Override
    public void delete(Integer id_bedroom) {
        if(!bedroomRepository.existsById(id_bedroom)){
            throw new EntityNotFoundException("Bedroom with ID: " + id_bedroom + " not found.");
        }
        bedroomRepository.deleteById(id_bedroom);
    }
}
