package kz.iitu.itis1908.hospitalmanagementservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kz.iitu.itis1908.hospitalmanagementservice.exceptions.NotFoundException;
import kz.iitu.itis1908.hospitalmanagementservice.model.Constants.ApiMessages;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.PatientDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Patient;
import kz.iitu.itis1908.hospitalmanagementservice.repository.PatientRepository;
import kz.iitu.itis1908.hospitalmanagementservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

  private final PatientRepository patientRepository;

  @Override
  public PatientDTO getPatient(String patientId) {
    Patient patient = findPatientById(patientId);
    log.info("Get patient with id - {}", patient.getPatientId());
    return PatientDTO.builder()
        .patientId(patient.getPatientId())
        .fullName(patient.getFullName())
        .city(patient.getCity())
        .district(patient.getDistrict())
        .address(patient.getAddress())
        .dateOfBirth(patient.getDateOfBirth())
        .category(patient.getCategory())
        .gender(patient.getGender())
        .build();
  }

  @Override
  public PatientDTO updatePatient(PatientDTO patientDTO) {
    Patient patient = findPatientById(patientDTO.getPatientId());
    patient.setCity(patientDTO.getCity());
    patient.setDistrict(patientDTO.getDistrict());
    patient.setAddress(patientDTO.getAddress());
    patientRepository.save(patient);
    log.info("Update Patient with id - {}", patientDTO.getPatientId());
    return patientDTO;
  }

  @Override
  public PatientDTO createPatient(PatientDTO patientDTO) {
    Patient patient = Patient.builder()
        .patientId(patientDTO.getPatientId())
        .fullName(patientDTO.getFullName())
        .city(patientDTO.getCity())
        .district(patientDTO.getDistrict())
        .address(patientDTO.getAddress())
        .dateOfBirth(patientDTO.getDateOfBirth())
        .category(patientDTO.getCategory())
        .gender(patientDTO.getGender())
        .build();
    patientRepository.save(patient);
    log.info("Patient successfully created - {}", patient.getPatientId());
    return patientDTO;
  }

  @Override
  public void deletePatient(String patientId) {
    Patient patient = findPatientById(patientId);
    patientRepository.delete(patient);
    log.info("Patient deleted with id - {}", patient.getPatientId());
  }

  @Override
  public List<PatientDTO> getAllPatients() {
    List<Patient> patients = patientRepository.findAll();
    List<PatientDTO> patientDTOList = new ArrayList<>();
    patients.forEach(patient -> patientDTOList.add(PatientDTO.builder()
        .patientId(patient.getPatientId())
        .fullName(patient.getFullName())
        .city(patient.getCity())
        .district(patient.getDistrict())
        .address(patient.getAddress())
        .dateOfBirth(patient.getDateOfBirth())
        .category(patient.getCategory())
        .gender(patient.getGender())
        .build()));
    return patientDTOList;
  }

  public Patient findPatientById(String patientId) {
    Patient patient = patientRepository.findPatientByPatientId(patientId);
    if (Objects.isNull(patient)) {
      throw new NotFoundException(ApiMessages.PATIENT_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
    return patient;
  }
}
