package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO {

  private Long appointmentId;
  private Long doctorId;
  private Long patientId;
  private String status;
  private LocalDateTime appointmentDate;
  private LocalDateTime appointmentFinishDate;
  private boolean accepted;
}
