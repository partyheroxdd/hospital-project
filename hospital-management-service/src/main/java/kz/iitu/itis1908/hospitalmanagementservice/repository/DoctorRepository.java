package kz.iitu.itis1908.hospitalmanagementservice.repository;

import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

  Doctor findDoctorByDoctorId(String doctorId);
}
