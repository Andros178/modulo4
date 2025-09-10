package com.example.rol;

import com.example.security.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@RequiredArgsConstructor
public class RolService {

    private final JwtUtil jwtUtil;

    public Long getRolIdFromCurrentRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new IllegalStateException("No se encontró el token JWT en la solicitud.");
        }

        String jwtToken = authHeader.substring(7);
        return jwtUtil.extractRolId(jwtToken);
    }
}
