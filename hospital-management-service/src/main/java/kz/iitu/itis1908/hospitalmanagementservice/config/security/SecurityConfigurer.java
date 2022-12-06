package kz.iitu.itis1908.hospitalmanagementservice.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;

  private final PasswordEncoder passwordEncoder;

  private final TokenFilter tokenFilter;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.cors().and().csrf().disable();

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.
        authorizeRequests()
        .antMatchers("/api/roles/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/api/users/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/api/departments/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/api/doctors/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/api/patients/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .anyRequest().authenticated();
    http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/swagger-ui/**", "/api/v1/api-docs/**", "/api/auth/**", "/health",
        "/actuator/**"
    );
  }


  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}
