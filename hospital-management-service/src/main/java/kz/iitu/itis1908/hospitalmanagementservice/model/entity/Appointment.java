package kz.iitu.itis1908.hospitalmanagementservice.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

  private String doctorId;

  private String patientId;

  private String status;

  @JsonFormat(pattern = "dd.MM.yyyy")
  private LocalDateTime appointmentDate;

  @JsonFormat(pattern = "dd.MM.yyyy")
  private LocalDateTime appointmentFinishDate;

  private Boolean accepted;

  private Boolean finished;

}
