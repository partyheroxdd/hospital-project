package kz.iitu.itis1908.hospitalmanagementservice.service;

import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.DepartmentDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.UserDTO;

public interface DepartmentService {

  DepartmentDTO getDepartment(Long departmentId);

  DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);

  DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

  void deleteDepartment(Long departmentId);

  List<DepartmentDTO> getAllDepartments();

}
