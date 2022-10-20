package kz.iitu.itis1908.hospitalmanagementservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.DoctorDTO;
import kz.iitu.itis1908.hospitalmanagementservice.service.DoctorService;
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
@RequestMapping("api/doctors")
@Tag(name = "Doctors", description = "Doctors API")
public class DoctorController {

  private final DoctorService doctorService;

  @GetMapping("/all")
  @Operation(summary = "Method to get all doctors")
  public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
    return ResponseEntity.ok(doctorService.getAllDoctors());
  }

  @GetMapping("/{doctorId}")
  @Operation(summary = "Method to get doctor by id")
  public ResponseEntity<DoctorDTO> getDoctor(
      @Parameter(description = "Doctor id") @PathVariable String doctorId) {
    return ResponseEntity.ok(doctorService.getDoctor(doctorId));
  }

  @PostMapping()
  @Operation(summary = "Method to create doctor")
  public ResponseEntity<DoctorDTO> createDoctor(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Doctor") @RequestBody DoctorDTO doctorDTO) {
    return ResponseEntity.ok(doctorService.createDoctor(doctorDTO));
  }

  @PutMapping()
  @Operation(summary = "Method to update doctor by id")
  public ResponseEntity<DoctorDTO> updateDoctor(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Doctor") @RequestBody DoctorDTO doctorDTO) {
    return ResponseEntity.ok(doctorService.updateDoctor(doctorDTO));
  }

  @DeleteMapping("/{doctorId}")
  @Operation(summary = "Method to delete doctor by id")
  public ResponseEntity<?> deleteDoctor(
      @Parameter(description = "Doctor id") @PathVariable String doctorId) {
    doctorService.deleteDoctor(doctorId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
