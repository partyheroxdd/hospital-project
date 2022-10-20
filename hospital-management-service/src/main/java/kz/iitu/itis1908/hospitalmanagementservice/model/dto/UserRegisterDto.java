package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

  @Size(min = 12, max = 12, message = "Username length must be 12 phone form")
  private String username;

  @Size(min = 8, message = "Password length must be minimum 8, maximum 40")
  private String password;

  private String[] roles;
}
