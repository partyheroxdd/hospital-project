package kz.iitu.itis1908.hospitalmanagementservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.AppointmentDTO;
import kz.iitu.itis1908.hospitalmanagementservice.service.AppointmentService;
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
@RequestMapping("api/appointments")
@Tag(name = "Appointments", description = "Appointments API")
public class AppointmentController {

  private final AppointmentService appointmentService;

  @GetMapping("/all")
  @Operation(summary = "Method to get all appointments")
  public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
    return ResponseEntity.ok(appointmentService.getAllAppointments());
  }

  @GetMapping("/allByDoctor/{doctorId}")
  @Operation(summary = "Method to get all appointments by doctor id")
  public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByDoctorId(
      @Parameter(description = "Doctor id") @PathVariable String doctorId) {
    return ResponseEntity.ok(appointmentService.getAllAppointmentsByDoctorId(doctorId));
  }

  @GetMapping("/allByPatient/{patientId}")
  @Operation(summary = "Method to get all appointments by patient id")
  public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByPatientId(
      @Parameter(description = "Patient id") @PathVariable String patientId) {
    return ResponseEntity.ok(appointmentService.getAllAppointmentsByPatientId(patientId));
  }

  @GetMapping("/allByAccepted/{accepted}")
  @Operation(summary = "Method to get all appointments by accepted status")
  public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByAccepted(
      @Parameter(description = "Accepted status") @PathVariable Boolean accepted) {
    return ResponseEntity.ok(appointmentService.getAllAppointmentsByAccepted(accepted));
  }

  @GetMapping("/allByFinished/{finished}")
  @Operation(summary = "Method to get all appointments by finished status")
  public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByFinished(
      @Parameter(description = "Finished status") @PathVariable Boolean finished) {
    return ResponseEntity.ok(appointmentService.getAllAppointmentsByFinished(finished));
  }

  @GetMapping("/{appointmentId}")
  @Operation(summary = "Method to get appointment by id")
  public ResponseEntity<AppointmentDTO> getAppointment(
      @Parameter(description = "Appointment id") @PathVariable Long appointmentId) {
    return ResponseEntity.ok(appointmentService.getAppointment(appointmentId));
  }

  @PostMapping()
  @Operation(summary = "Method to create appointment")
  public ResponseEntity<AppointmentDTO> createAppointment(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Appointment") @RequestBody AppointmentDTO appointmentDTO) {
    return ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
  }


  @PutMapping()
  @Operation(summary = "Method to update appointment by id")
  public ResponseEntity<AppointmentDTO> updateAppointment(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of Appointment") @RequestBody AppointmentDTO appointmentDTO) {
    return ResponseEntity.ok(appointmentService.updateAppointment(appointmentDTO));
  }

  @PostMapping("/accept/{appointmentId}")
  @Operation(summary = "Method to accept appointment by id")
  public ResponseEntity<?> apporveAppointment(
      @Parameter(description = "Appointment id") @PathVariable Long appointmentId) {
    appointmentService.acceptAppointment(appointmentId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/finish/{appointmentId}")
  @Operation(summary = "Method to finish appointment by id")
  public ResponseEntity<?> finishAppointment(
      @Parameter(description = "Appointment id") @PathVariable Long appointmentId) {
    appointmentService.finishAppointment(appointmentId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{appointmentId}")
  @Operation(summary = "Method to delete appointment by id")
  public ResponseEntity<?> deleteAppointment(
      @Parameter(description = "Appointment id") @PathVariable Long appointmentId) {
    appointmentService.deleteAppointment(appointmentId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
