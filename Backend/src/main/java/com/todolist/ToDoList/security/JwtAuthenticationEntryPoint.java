package com.todolist.ToDoList.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Access Denied !! " + authException.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing response: " + e.getMessage());
        }
    }
}