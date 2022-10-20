package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientDTO {

  @Size(min = 12, max = 12, message = "Id should be 12 digit IIN form")
  private String patientId;
  private String fullName;
  private String city;
  private String district;
  private String address;
  @JsonFormat(pattern = "dd.MM.yyyy")
  private LocalDate dateOfBirth;
  private String category;
  private String gender;
}
