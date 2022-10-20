package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppointmentDTO {

  private Long appointmentId;
  private String doctorId;
  private String patientId;
  private String status;
  @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
  private LocalDateTime appointmentDate;
  @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
  private LocalDateTime appointmentFinishDate;
  private Boolean accepted;
  private Boolean finished;
}
