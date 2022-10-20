package kz.iitu.itis1908.hospitalmanagementservice.service;

import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.AppointmentDTO;

public interface AppointmentService {

  AppointmentDTO getAppointment(Long appointmentId);

  AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO);

  AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

  void acceptAppointment(Long appointmentId);

  void finishAppointment(Long appointmentId);

  void deleteAppointment(Long appointmentId);

  List<AppointmentDTO> getAllAppointments();

  List<AppointmentDTO> getAllAppointmentsByDoctorId(String doctorId);

  List<AppointmentDTO> getAllAppointmentsByPatientId(String patientId);

  List<AppointmentDTO> getAllAppointmentsByAccepted(Boolean accepted);

  List<AppointmentDTO> getAllAppointmentsByFinished(Boolean finished);

}
