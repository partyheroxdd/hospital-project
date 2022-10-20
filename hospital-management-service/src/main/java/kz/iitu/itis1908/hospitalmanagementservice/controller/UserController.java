package kz.iitu.itis1908.hospitalmanagementservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.UserDTO;
import kz.iitu.itis1908.hospitalmanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
@Tag(name = "Users", description = "Users API")
public class UserController {

  private final UserService userService;

  @GetMapping("/all")
  @Operation(summary = "Method to get all users")
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  @Operation(summary = "Method to get user by id")
  public ResponseEntity<UserDTO> getUser(
      @Parameter(description = "User id") @PathVariable Long id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

  @PostMapping()
  @Operation(summary = "Method to update user by id")
  public ResponseEntity<UserDTO> updateUser(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Request body of User") @RequestBody UserDTO userDTO) {
    return ResponseEntity.ok(userService.updateUser(userDTO));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Method to delete user by id")
  public ResponseEntity<?> deleteUser(
      @Parameter(description = "User id") @PathVariable Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
