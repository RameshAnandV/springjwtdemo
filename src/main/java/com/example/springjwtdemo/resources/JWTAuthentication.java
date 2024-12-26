package com.example.springjwtdemo.resources;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.Authentication;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JWTAuthentication {

    @GetMapping("/authenticate")
    public void jwtAuthenticate(Authentication authentication) {
  
    }
}
