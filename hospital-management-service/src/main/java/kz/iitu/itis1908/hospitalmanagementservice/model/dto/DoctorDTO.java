package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {

  private Long doctorId;
  private Long departmentId;
  private String city;
  private String fullName;
  private String specialization;
  private String position;
}
