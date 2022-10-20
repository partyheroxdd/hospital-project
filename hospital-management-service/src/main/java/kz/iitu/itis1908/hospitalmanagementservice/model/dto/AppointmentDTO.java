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
  private String doctorId;
  private String patientId;
  private String status;
  private LocalDateTime appointmentDate;
  private LocalDateTime appointmentFinishDate;
  private boolean accepted;
}
