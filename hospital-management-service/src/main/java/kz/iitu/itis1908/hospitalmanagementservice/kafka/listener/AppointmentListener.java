package kz.iitu.itis1908.hospitalmanagementservice.kafka.listener;

import java.time.LocalDateTime;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.AppointmentDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Appointment;
import kz.iitu.itis1908.hospitalmanagementservice.model.event.AppointmentEvent;
import kz.iitu.itis1908.hospitalmanagementservice.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppointmentListener {

  private final AppointmentRepository appointmentRepository;

  @KafkaListener(
      topics = "${spring.kafka.topic1.name}",
      groupId = "${spring.kafka.consumer.group-id}"
  )
  public void consumeRequestAppointment(AppointmentEvent appointmentEvent) {
    AppointmentDTO appointmentDTO = appointmentEvent.getAppointmentDTO();

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

    log.info("Appointment requested => {}", appointment);
  }

  @KafkaListener(
      topics = "${spring.kafka.topic2.name}",
      groupId = "${spring.kafka.consumer.group-id}"
  )
  public void consumeAcceptAppointment(AppointmentEvent appointmentEvent) {
    AppointmentDTO appointmentDTO = appointmentEvent.getAppointmentDTO();

    Appointment appointment = appointmentRepository.findAppointmentByAppointmentId(
        appointmentDTO.getAppointmentId());
    appointment.setAccepted(true);
    appointment.setStatus("accepted");
    appointmentRepository.save(appointment);

    log.info("Appointment accepted => {}", appointment);
  }

  @KafkaListener(
      topics = "${spring.kafka.topic3.name}",
      groupId = "${spring.kafka.consumer.group-id}"
  )
  public void consumeFinishAppointment(AppointmentEvent appointmentEvent) {
    AppointmentDTO appointmentDTO = appointmentEvent.getAppointmentDTO();

    Appointment appointment = appointmentRepository.findAppointmentByAppointmentId(
        appointmentDTO.getAppointmentId());

    appointment.setFinished(true);
    appointment.setStatus("finished");
    appointment.setAppointmentFinishDate(LocalDateTime.now());
    appointmentRepository.save(appointment);

    log.info("Appointment finished => {}", appointment);
  }

}
