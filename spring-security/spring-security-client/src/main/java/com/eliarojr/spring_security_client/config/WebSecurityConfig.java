package com.eliarojr.spring_security_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    //Array of endpoints to be whitelisted despite being unauthenticated
    private static final String [] WHITE_LIST_URLS = {
            "/hello",
            "/register",
            "/verifyRegistration",
            "/resendVerifyToken*",
            "/resetPassword",
            "/savePassword",
            "/changePassword"
    };

    //Password encoder to make sure that the password can't be read even by the program
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    //Method to filter and whitelist urls
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for simplicity (enable in production if needed)
                .cors(cors -> {}) // Uses default CORS configs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(WHITE_LIST_URLS).permitAll() // Allow public access to whitelisted URLs
                        .requestMatchers("/api/**").authenticated() // Require authentication for /api/**
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/oauth2/authorization/api-client-oidc") // Redirect to OAuth 2.0 login
                )
                .oauth2Client(withDefaults()); // Enable OAuth 2.0 client support

        return http.build();
    }

}
