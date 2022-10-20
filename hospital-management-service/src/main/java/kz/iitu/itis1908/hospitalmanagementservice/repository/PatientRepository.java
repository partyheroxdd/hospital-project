package kz.iitu.itis1908.hospitalmanagementservice.repository;

import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
  Patient findPatientByPatientId(String patientId);
}
