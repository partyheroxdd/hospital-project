package kz.iitu.itis1908.hospitalmanagementservice.model.entity;

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
@Document(collection = "doctors")
public class Doctor {

  @Id
  private String doctorId;

  private String city;

  private String fullName;

  private Long departmentId;

  private String specialization;

  private String position;

}
