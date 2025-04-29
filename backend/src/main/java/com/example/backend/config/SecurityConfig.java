package com.example.backend.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .formLogin(fl -> fl
                        .loginProcessingUrl("/mew/login")
                        .successHandler((req, res, auth) -> {
                            // 세션 기반이라면 아무것도 안 해도 됨 (Security가 세션에 저장)
                            res.setStatus(HttpServletResponse.SC_OK);
                        })
                        .failureHandler((req,res,ex) -> res.sendError(401, "Bad credentials"))
                )

                .logout(lo -> lo
                        .logoutUrl("/mew/logout")
                        .logoutSuccessHandler((req,res,auth) -> res.setStatus(200)))

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                );
                //.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}