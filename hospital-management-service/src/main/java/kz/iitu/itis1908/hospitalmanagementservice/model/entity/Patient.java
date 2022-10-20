package kz.iitu.itis1908.hospitalmanagementservice.model.entity;

import java.time.LocalDate;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "patients")
public class Patient {

  @Id
  private Long patientId;

  private String fullName;

  private String city;

  private String district;

  private String address;

  private LocalDate dateOfBirth;

  private Integer numberOfAppointments;

  private String category;

  private String gender;

}
