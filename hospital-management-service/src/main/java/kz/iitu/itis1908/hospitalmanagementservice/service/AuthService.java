package kz.iitu.itis1908.hospitalmanagementservice.service;

import kz.iitu.itis1908.hospitalmanagementservice.model.dto.UserChangePasswordDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.UserLoginDto;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.UserRegisterDto;
import kz.iitu.itis1908.hospitalmanagementservice.security.AccessToken;

public interface AuthService {

  AccessToken register(UserRegisterDto userRegisterDto);

  AccessToken login(UserLoginDto userLoginDto);

  void changePassword(UserChangePasswordDTO userChangePasswordDTO);
}
