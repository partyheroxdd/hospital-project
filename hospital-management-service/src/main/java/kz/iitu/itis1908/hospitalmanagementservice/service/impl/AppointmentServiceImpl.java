package kz.iitu.itis1908.hospitalmanagementservice.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kz.iitu.itis1908.hospitalmanagementservice.exceptions.NotFoundException;
import kz.iitu.itis1908.hospitalmanagementservice.model.Constants.ApiMessages;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.AppointmentDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Appointment;
import kz.iitu.itis1908.hospitalmanagementservice.repository.AppointmentRepository;
import kz.iitu.itis1908.hospitalmanagementservice.repository.PatientRepository;
import kz.iitu.itis1908.hospitalmanagementservice.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final PatientRepository patientRepository;
  @Override
  public AppointmentDTO getAppointment(Long appointmentId) {
    Appointment appointment = findAppointmentById(appointmentId);
    log.info("Get appointment with id - {}", appointmentId);
    return AppointmentDTO.builder()
        .appointmentId(appointment.getAppointmentId())
        .doctorId(appointment.getDoctorId())
        .patientId(appointment.getPatientId())
        .status(appointment.getStatus())
        .appointmentDate(appointment.getAppointmentDate())
        .appointmentFinishDate(appointment.getAppointmentFinishDate())
        .accepted(appointment.getAccepted())
        .finished(appointment.getFinished())
        .build();
  }

  @Override
  public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO) {
    Appointment appointment = findAppointmentById(appointmentDTO.getAppointmentId());
    appointment.setDoctorId(appointmentDTO.getDoctorId());
    appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
    appointmentRepository.save(appointment);
    log.info("Update Appointment with id - {}", appointmentDTO.getAppointmentId());
    return appointmentDTO;
  }

  @Override
  public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
    if (appointmentRepository.existsByDoctorIdAndAppointmentDate(appointmentDTO.getDoctorId(),
        appointmentDTO.getAppointmentDate())) {
      throw new NotFoundException(ApiMessages.APPOINTMENT_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
    }
    Appointment appointment = Appointment.builder()
        .appointmentId(appointmentDTO.getAppointmentId())
        .doctorId(appointmentDTO.getDoctorId())
        .patientId(appointmentDTO.getPatientId())
        .status("created")
        .appointmentDate(appointmentDTO.getAppointmentDate())
        .appointmentFinishDate(appointmentDTO.getAppointmentFinishDate())
        .accepted(false)
        .finished(false)
        .build();
    appointmentRepository.save(appointment);
    log.info("Appointment successfully created - {}", appointment.getAppointmentId());
    return appointmentDTO;
  }

  @Override
  public void acceptAppointment(Long appointmentId) {
    Appointment appointment = findAppointmentById(appointmentId);
    appointment.setStatus("accepted");
    appointment.setAccepted(true);
    appointmentRepository.save(appointment);
    log.info("Appointment with id - {} accepted", appointmentId);
  }

  @Override
  public void finishAppointment(Long appointmentId) {
    Appointment appointment = findAppointmentById(appointmentId);
    appointment.setStatus("finished");
    appointment.setAppointmentFinishDate(LocalDateTime.now());
    appointment.setFinished(true);
    appointmentRepository.save(appointment);
    log.info("Appointment with id - {} finished", appointmentId);
  }

  @Override
  public void deleteAppointment(Long appointmentId) {
    Appointment appointment = findAppointmentById(appointmentId);
    appointmentRepository.delete(appointment);
    log.info("Delete appointment with id - {}", appointmentId);
  }

  @Override
  public List<AppointmentDTO> getAllAppointments() {
    List<Appointment> appointments = appointmentRepository.findAll();
    List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
    appointments.forEach(appointment -> appointmentDTOList.add(AppointmentDTO.builder()
        .appointmentId(appointment.getAppointmentId())
        .doctorId(appointment.getDoctorId())
        .patientId(appointment.getPatientId())
        .status(appointment.getStatus())
        .appointmentDate(appointment.getAppointmentDate())
        .appointmentFinishDate(appointment.getAppointmentFinishDate())
        .accepted(appointment.getAccepted())
        .finished(appointment.getFinished())
        .build()));
    return appointmentDTOList;
  }

  @Override
  public List<AppointmentDTO> getAllAppointmentsByDoctorId(String doctorId) {
    List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctorId(doctorId);
    List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
    appointments.forEach(appointment -> appointmentDTOList.add(AppointmentDTO.builder()
        .appointmentId(appointment.getAppointmentId())
        .doctorId(appointment.getDoctorId())
        .patientId(appointment.getPatientId())
        .status(appointment.getStatus())
        .appointmentDate(appointment.getAppointmentDate())
        .appointmentFinishDate(appointment.getAppointmentFinishDate())
        .accepted(appointment.getAccepted())
        .finished(appointment.getFinished())
        .build()));
    return appointmentDTOList;
  }

  @Override
  public List<AppointmentDTO> getAllAppointmentsByPatientId(String patientId) {
    List<Appointment> appointments = appointmentRepository.findAppointmentsByPatientId(patientId);
    List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
    appointments.forEach(appointment -> appointmentDTOList.add(AppointmentDTO.builder()
        .appointmentId(appointment.getAppointmentId())
        .doctorId(appointment.getDoctorId())
        .patientId(appointment.getPatientId())
        .status(appointment.getStatus())
        .appointmentDate(appointment.getAppointmentDate())
        .appointmentFinishDate(appointment.getAppointmentFinishDate())
        .accepted(appointment.getAccepted())
        .finished(appointment.getFinished())
        .build()));
    return appointmentDTOList;
  }

  @Override
  public List<AppointmentDTO> getAllAppointmentsByAccepted(Boolean accepted) {
    List<Appointment> appointments = appointmentRepository.findAppointmentsByAccepted(accepted);
    List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
    appointments.forEach(appointment -> appointmentDTOList.add(AppointmentDTO.builder()
        .appointmentId(appointment.getAppointmentId())
        .doctorId(appointment.getDoctorId())
        .patientId(appointment.getPatientId())
        .status(appointment.getStatus())
        .appointmentDate(appointment.getAppointmentDate())
        .appointmentFinishDate(appointment.getAppointmentFinishDate())
        .accepted(appointment.getAccepted())
        .finished(appointment.getFinished())
        .build()));
    return appointmentDTOList;
  }

  @Override
  public List<AppointmentDTO> getAllAppointmentsByFinished(Boolean finished) {
    List<Appointment> appointments = appointmentRepository.findAppointmentsByFinished(finished);
    List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
    appointments.forEach(appointment -> appointmentDTOList.add(AppointmentDTO.builder()
        .appointmentId(appointment.getAppointmentId())
        .doctorId(appointment.getDoctorId())
        .patientId(appointment.getPatientId())
        .status(appointment.getStatus())
        .appointmentDate(appointment.getAppointmentDate())
        .appointmentFinishDate(appointment.getAppointmentFinishDate())
        .accepted(appointment.getAccepted())
        .finished(appointment.getFinished())
        .build()));
    return appointmentDTOList;
  }

  private Appointment findAppointmentById(Long appointmentId) {
    Appointment appointment = appointmentRepository.findAppointmentByAppointmentId(appointmentId);
    if (Objects.isNull(appointment)) {
      throw new NotFoundException(ApiMessages.APPOINTMENT_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
    return appointment;
  }
}
