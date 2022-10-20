package kz.iitu.itis1908.hospitalmanagementservice.repository;

import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, Long> {
  Appointment findAppointmentByAppointmentId(Long appointmentId);
}
