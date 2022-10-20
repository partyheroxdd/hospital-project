package kz.iitu.itis1908.hospitalmanagementservice.service;

import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.UserDTO;

public interface UserService {

  UserDTO getUser(Long id);

  UserDTO updateUser(UserDTO userDTO);

  UserDTO createUser(UserDTO userDTO);

  void deleteUser(Long id);

  List<UserDTO> getAllUsers();

}
