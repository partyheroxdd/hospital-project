package kz.iitu.itis1908.hospitalmanagementservice.service;

import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.PatientDTO;

public interface PatientService {

  PatientDTO getPatient(String patientId);

  PatientDTO updatePatient(PatientDTO patientDTO);

  PatientDTO createPatient(PatientDTO patientDTO);

  void deletePatient(String patientId);

  List<PatientDTO> getAllPatients();

}
