package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {
  private Long departmentId;
  private String name;
}
