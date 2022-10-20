package kz.iitu.itis1908.hospitalmanagementservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.DepartmentDTO;
import kz.iitu.itis1908.hospitalmanagementservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/departments")
@Tag(name = "Departments", description = "Departments API")
public class DepartmentController {

  private final DepartmentService departmentService;

  @GetMapping("/all")
  @Operation(summary = "Method to get all departments")
  public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
    return ResponseEntity.ok(departmentService.getAllDepartments());
  }

  @GetMapping("/{departmentId}")
  @Operation(summary = "Method to get department by id")
  public ResponseEntity<DepartmentDTO> getDepartment(
      @Parameter(description = "Department id") @PathVariable Long departmentId) {
    return ResponseEntity.ok(departmentService.getDepartment(departmentId));
  }

  @PostMapping()
  @Operation(summary = "Method to create department")
  public ResponseEntity<DepartmentDTO> createDepartment(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Department") @RequestBody DepartmentDTO departmentDTO) {
    return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));
  }

  @PutMapping()
  @Operation(summary = "Method to update department by id")
  public ResponseEntity<DepartmentDTO> updateDepartment(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Department") @RequestBody DepartmentDTO departmentDTO) {
    return ResponseEntity.ok(departmentService.updateDepartment(departmentDTO));
  }

  @DeleteMapping("/{departmentId}")
  @Operation(summary = "Method to delete department by id")
  public ResponseEntity<?> deleteDepartment(
      @Parameter(description = "Department id") @PathVariable Long departmentId) {
    departmentService.deleteDepartment(departmentId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
