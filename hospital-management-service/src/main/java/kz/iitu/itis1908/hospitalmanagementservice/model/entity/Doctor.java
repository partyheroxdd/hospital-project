package kz.iitu.itis1908.hospitalmanagementservice.model.entity;

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
@Document(collection = "doctors")
public class Doctor {

  @Id
  private Long doctorId;

  private String city;

  private String fullName;

  private Long departmentId;

  private String specialization;

  private String position;

}
