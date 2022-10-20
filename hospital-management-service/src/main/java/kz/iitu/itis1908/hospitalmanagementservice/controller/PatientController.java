package kz.iitu.itis1908.hospitalmanagementservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.PatientDTO;
import kz.iitu.itis1908.hospitalmanagementservice.service.PatientService;
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
@RequestMapping("api/patients")
@Tag(name = "Patients", description = "Patients API")
public class PatientController {

  private final PatientService patientService;

  @GetMapping("/all")
  @Operation(summary = "Method to get all patients")
  public ResponseEntity<List<PatientDTO>> getAllPatients() {
    return ResponseEntity.ok(patientService.getAllPatients());
  }

  @GetMapping("/{patientId}")
  @Operation(summary = "Method to get patient by id")
  public ResponseEntity<PatientDTO> getPatient(
      @Parameter(description = "Patient id") @PathVariable String patientId) {
    return ResponseEntity.ok(patientService.getPatient(patientId));
  }

  @PostMapping()
  @Operation(summary = "Method to create patient")
  public ResponseEntity<PatientDTO> createPatient(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Patient") @RequestBody PatientDTO patientDTO) {
    return ResponseEntity.ok(patientService.createPatient(patientDTO));
  }

  @PutMapping()
  @Operation(summary = "Method to update patient by id")
  public ResponseEntity<PatientDTO> updatePatient(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Patient") @RequestBody PatientDTO patientDTO) {
    return ResponseEntity.ok(patientService.updatePatient(patientDTO));
  }

  @DeleteMapping("/{patientId}")
  @Operation(summary = "Method to delete patient by id")
  public ResponseEntity<?> deletePatient(
      @Parameter(description = "Patient id") @PathVariable String patientId) {
    patientService.deletePatient(patientId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
