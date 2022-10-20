package kz.iitu.itis1908.hospitalmanagementservice.model.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "appointments")
public class Appointment {

  @Id
  private Long appointmentId;

  private Long doctorId;

  private Long patientId;

  private String status;

  private LocalDateTime appointmentDate;

  private LocalDateTime appointmentFinishDate;

  private boolean accepted;

}
