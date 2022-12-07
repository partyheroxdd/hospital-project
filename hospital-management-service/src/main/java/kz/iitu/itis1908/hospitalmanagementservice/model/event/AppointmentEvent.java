package kz.iitu.itis1908.hospitalmanagementservice.model.event;

import kz.iitu.itis1908.hospitalmanagementservice.model.dto.AppointmentDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentEvent {

  private String message;
  private EventStatus status;
  private AppointmentDTO appointmentDTO;
}
