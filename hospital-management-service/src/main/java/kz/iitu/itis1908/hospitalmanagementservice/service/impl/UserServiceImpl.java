package kz.iitu.itis1908.hospitalmanagementservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.UserDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.User;
import kz.iitu.itis1908.hospitalmanagementservice.repository.UserRepository;
import kz.iitu.itis1908.hospitalmanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDTO getUser(Long id) {
    User user = userRepository.findUserById(id);
    log.info("Get user with id - {}", id);
    return UserDTO.builder()
        .id(user.getId())
        .username(user.getUsername())
        .password(user.getPassword())
        .roles(user.getRoles())
        .build();
  }

  @Override
  public UserDTO createUser(UserDTO userDTO) {
    User user = User.builder()
        .username(userDTO.getUsername())
        .password(passwordEncoder.encode(userDTO.getPassword()))
        .roles(userDTO.getRoles())
        .build();
    userRepository.save(user);
    log.info("User successfully created - {}", user.getUsername());
    return userDTO;
  }

  @Override
  public UserDTO updateUser(UserDTO userDTO) {
    User user = userRepository.findUserById(userDTO.getId());
    user.setUsername(userDTO.getUsername());
    user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    user.setRoles(userDTO.getRoles());
    userRepository.save(user);
    log.info("User successfully updated with id - {}", user.getId());
    return userDTO;
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
    log.info("Delete user with id - {}", id);
  }

  @Override
  public List<UserDTO> getAllUsers() {
    List<User> users = userRepository.findAll();
    List<UserDTO> userInfoDTOList = new ArrayList<>();
    users.forEach(user -> userInfoDTOList.add(UserDTO.builder()
        .id(user.getId())
        .username(user.getUsername())
        .password(user.getPassword())
        .roles(user.getRoles())
        .build()));
    return userInfoDTOList;
  }

}
