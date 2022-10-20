package kz.iitu.itis1908.hospitalmanagementservice.repository;

import java.time.LocalDateTime;
import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, Long> {

  Appointment findAppointmentByAppointmentId(Long appointmentId);

  List<Appointment> findAppointmentsByDoctorId(String doctorId);

  List<Appointment> findAppointmentsByPatientId(String patientId);

  List<Appointment> findAppointmentsByAccepted(Boolean accepted);

  List<Appointment> findAppointmentsByFinished(Boolean finished);

  boolean existsByDoctorIdAndAppointmentDate(String doctorId, LocalDateTime appointmentDate);
}
