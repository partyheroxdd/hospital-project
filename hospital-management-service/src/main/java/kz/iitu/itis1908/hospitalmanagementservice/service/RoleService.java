package kz.iitu.itis1908.hospitalmanagementservice.service;

import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Role;

public interface RoleService {

  Role saveRole(Role role);

  Role getRole(Long id);

  void deleteRole(Long id);

  List<Role> getAllRoles();
}
