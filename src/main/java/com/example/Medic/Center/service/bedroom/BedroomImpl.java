package com.example.Medic.Center.service.bedroom;

import com.example.Medic.Center.exception.RoomOccupiedException;
import com.example.Medic.Center.model.entity.Bedroom;
import com.example.Medic.Center.model.entity.Patient;
import com.example.Medic.Center.repository.BedroomRepository;
import com.example.Medic.Center.repository.PatientRepository;
import com.example.Medic.Center.service.patient.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Component
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
       //If the patient does not exist or is not in the room, it throws an exception.
        if(patientOptional.isEmpty() || !patientOptional.get().getBedroom().getId_bedroom().equals(id_bedroom)){
            throw new EntityNotFoundException("Patient with ID: " + patientOptional.get().getId_patient() + " not found.");
        }
        Patient patient = patientOptional.get();
        //delete the bedroom in patient.
        patient.setBedroom(null);
        patientService.save(patient);
        Optional<Bedroom> bedroomOptional = bedroomRepository.findById(id_patient);
        Bedroom bedroom = bedroomOptional.get();
        //delete the patient in bedroom.
        bedroom.getPatientList().remove(patient);
        //set the occupancy in false.
        bedroom.setOccupancyStatus(false);
        bedroomRepository.save(bedroom);
    }

    @Override
    public void increaseSize(Integer number, Integer id_bedroom) {
        Optional<Bedroom>bedroomOptional = bedroomRepository.findById(id_bedroom);
        //if the room not exist throws the exception.
        if(bedroomOptional.isEmpty()){
            throw new EntityNotFoundException("Bedroom with ID: " + bedroomOptional.get().getId_bedroom() + " not found.");
        }
        Bedroom bedroom = bedroomOptional.get();
        //change the bedroom capacity.
        bedroom.setCapacity(bedroom.getCapacity() + number);
        bedroomRepository.save(bedroom);
    }

    @Override
    public void addPatientInBedroomById(Integer id_patient, Integer id_bedroom) {
        Optional<Patient>patientOptional = patientService.findById(id_patient);
        //if the patient not exist throws the exception.
        if(patientOptional.isEmpty()){
            throw new EntityNotFoundException("Patient with ID: " + patientOptional.get().getId_patient() + " not found.");
        }
        Optional<Bedroom>bedroomOptional = bedroomRepository.findById(id_bedroom);
        //if the room not exist throws the exception.
        if(bedroomOptional.isEmpty()){
            throw new EntityNotFoundException("Bedroom with ID: " + bedroomOptional.get().getId_bedroom() + " not found.");
        }
        Bedroom bedroom = bedroomOptional.get();
        //if the room is occupied throws the exception.
        if(bedroom.isOccupancyStatus()){
            throw new RoomOccupiedException();

        }
        Patient patient = patientOptional.get();
        //If the patient already has an assigned room, changing it will vacate the current one.
        if(patient.getBedroom() != null){
            Bedroom bedroomPatient = patient.getBedroom();
            bedroomPatient.getPatientList().remove(patient);
            bedroomPatient.setOccupancyStatus(false);
            bedroomRepository.save(bedroomPatient);
        }
        //If the room is filled upon adding the patient, its status changes.
        if(bedroom.getPatientList().size() + 1 == bedroom.getCapacity()){
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
        //if the room not exist throws the exception
        if(!bedroomRepository.existsById(id_bedroom)){
            throw new EntityNotFoundException("Bedroom with ID: " + id_bedroom + " not found.");
        }
        bedroomRepository.deleteById(id_bedroom);
    }
}
