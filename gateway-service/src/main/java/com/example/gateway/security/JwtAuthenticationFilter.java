package com.example.gateway.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        String path = request.getServletPath();

        return path.startsWith("/auth/")
                || path.startsWith("/swagger-ui/")
                || path.equals("/swagger-ui.html")
                || path.startsWith("/v3/api-docs/")
                || path.equals("/auth-service/v3/api-docs")
                || path.equals("/audit-service/v3/api-docs")
                || path.equals("/user-profile-service/v3/api-docs")
                || path.equals("/car-service-operations/v3/api-docs")
                || path.equals("/car-details-validation-service/v3/api-docs")
                || path.startsWith("/actuator/")
                || path.startsWith("/audit-service/actuator/")
                || path.startsWith("/auth-service/actuator/")
                || path.startsWith("/user-profile-service/actuator/")
                || path.startsWith("/car-service-operations/actuator/")
                || path.startsWith("/car-details-validation-service/actuator/");
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {

            if (jwtService.isValid(token)) {

                String username = jwtService.extractUsername(token);
                String role = jwtService.extractRole(token);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                List.of(new SimpleGrantedAuthority(role)));

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }

        } catch (Exception ex) {

            SecurityContextHolder.clearContext();

        }

        filterChain.doFilter(request, response);
    }
}