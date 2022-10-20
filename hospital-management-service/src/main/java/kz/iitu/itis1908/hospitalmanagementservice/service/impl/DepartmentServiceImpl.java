package kz.iitu.itis1908.hospitalmanagementservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kz.iitu.itis1908.hospitalmanagementservice.exceptions.NotFoundException;
import kz.iitu.itis1908.hospitalmanagementservice.model.Constants.ApiMessages;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.DepartmentDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Department;
import kz.iitu.itis1908.hospitalmanagementservice.repository.DepartmentRepository;
import kz.iitu.itis1908.hospitalmanagementservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  @Override
  public DepartmentDTO getDepartment(Long departmentId) {
    Department department = findDepartmentById(departmentId);
    log.info("Get department with id {}", departmentId);
    return DepartmentDTO.builder()
        .departmentId(department.getDepartmentId())
        .name(department.getName())
        .build();
  }

  @Override
  public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
    Department department = findDepartmentById(departmentDTO.getDepartmentId());
    department.setName(departmentDTO.getName());
    departmentRepository.save(department);
    log.info("Update Department with id {}", departmentDTO.getDepartmentId());
    return departmentDTO;
  }

  @Override
  public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
    Department department = Department.builder()
        .departmentId(departmentDTO.getDepartmentId())
        .name(departmentDTO.getName())
        .build();
    departmentRepository.save(department);
    log.info("Department successfully created {}", department);
    return departmentDTO;
  }

  @Override
  public void deleteDepartment(Long departmentId) {
    Department department = findDepartmentById(departmentId);
    departmentRepository.delete(department);
    log.info("Delete department with id {}", departmentId);
  }

  @Override
  public List<DepartmentDTO> getAllDepartments() {
    List<Department> departments = departmentRepository.findAll();
    List<DepartmentDTO> departmentDTOList = new ArrayList<>();
    departments.forEach(department -> departmentDTOList.add(DepartmentDTO.builder()
        .departmentId(department.getDepartmentId())
        .name(department.getName())
        .build()));
    return departmentDTOList;
  }

  private Department findDepartmentById(Long departmentId) {
    Department department = departmentRepository.findDepartmentByDepartmentId(departmentId);
    if (Objects.isNull(department)) {
      throw new NotFoundException(ApiMessages.DEPARTMENT_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
    return department;
  }
}
