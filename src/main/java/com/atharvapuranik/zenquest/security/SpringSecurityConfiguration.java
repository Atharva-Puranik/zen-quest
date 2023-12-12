package com.atharvapuranik.zenquest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("Atharva")
                .password("test")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filters(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
          auth ->auth.anyRequest().authenticated()
        );
          httpSecurity.formLogin(Customizer.withDefaults());
          httpSecurity.csrf(csrf -> csrf.disable());
          httpSecurity.headers(headers -> headers
                  .frameOptions(frameOptions -> frameOptions
                          .sameOrigin()
                  )
          );
          return httpSecurity.build();
    }
}
