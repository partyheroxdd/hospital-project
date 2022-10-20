package kz.iitu.itis1908.hospitalmanagementservice.security;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Role;
import org.springframework.security.core.Authentication;

public interface ITokenProvider {


  AccessToken createToken(String username, Set<Role> roles);

  boolean validateToken(AccessToken accessToken);

  AccessToken getTokenFromHeader(HttpServletRequest httpServletRequest);

  Authentication getAuthentication(AccessToken accessToken);
}
