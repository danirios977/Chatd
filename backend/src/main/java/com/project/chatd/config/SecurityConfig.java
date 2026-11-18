package com.project.chatd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.chatd.security.ApiKeyAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Value("${app.security.api-key}")
	private String apiKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       ApiKeyAuthFilter filter = new ApiKeyAuthFilter(apiKey);
    	
    	http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/api/public/**").permitAll()
            		.anyRequest().authenticated()
            		);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails tester = User.builder()
                .username("admin")
                .password("{noop}123456") // {noop} le dice a Spring que compare la contraseña en texto plano de forma literal
                .roles("ADMIN")
                .build();
            
        return new InMemoryUserDetailsManager(tester);
    }
}