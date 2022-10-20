package kz.iitu.itis1908.hospitalmanagementservice.security.jwt;

import java.util.Set;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Role;
import kz.iitu.itis1908.hospitalmanagementservice.security.AccessToken;
import kz.iitu.itis1908.hospitalmanagementservice.security.SecretKey;

public interface IJwtTokenHelper {

  String generateJwtToken(SecretKey secretKey, String username, Set<Role> roles);

  boolean validateJwtToken(SecretKey secretKey, AccessToken accessToken);

  String getUsernameFromJwtToken(SecretKey secretKey, AccessToken accessToken);
}
