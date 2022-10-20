package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {

  private String patientId;
  private String fullName;
  private String city;
  private String district;
  private String address;
  private LocalDate dateOfBirth;
  private Integer numberOfAppointments;
  private String category;
  private String gender;
}
