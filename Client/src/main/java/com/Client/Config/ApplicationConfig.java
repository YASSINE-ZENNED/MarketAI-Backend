package com.Client.Config;

import com.Client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
  private ClientRepository clientRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return email ->
        clientRepository
            .findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
  }
}
