package com.example.ewizyta.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .mvcMatchers("/", "/patient-registration/**", "/go-to-weather", "/weather/**").permitAll()
                .mvcMatchers("/doctors-appointment-list/**").hasAnyRole("ADMIN", "DOCTOR")
                .mvcMatchers("/all-patient-visits").hasAnyRole("ADMIN", "PATIENT")
                .mvcMatchers("/all-doctors-visits/**").hasAnyRole("ADMIN", "DOCTOR")
                .mvcMatchers("/add-visit", "/save-visit").hasAnyRole("ADMIN", "DOCTOR")
                .mvcMatchers("/styles/**").permitAll()
                .mvcMatchers("/**").authenticated()

        );

        http.formLogin(login -> login.loginPage("/login")
                .permitAll());

        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**",
                        HttpMethod.GET.name()))
                .logoutSuccessUrl("/")
        );

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
