package kz.iitu.itis1908.hospitalmanagementservice.model.dto;

import java.util.Set;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDTO {

  private Long id;
  private String username;
  private String password;
  private Set<Role> roles;
}
