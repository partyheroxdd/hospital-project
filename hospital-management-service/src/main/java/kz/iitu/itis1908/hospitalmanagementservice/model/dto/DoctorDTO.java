package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DoctorDTO {

  @Size(min = 12, max = 12, message = "Id should be 12 digit IIN form")
  private String doctorId;
  private Long departmentId;
  private String city;
  private String fullName;
  private String specialization;
  private String position;
}
