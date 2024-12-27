package com.example.springjwtdemo.resources;

import com.example.springjwtdemo.pojo.JwtResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jwt")
public class JWTAuthentication {

    private JwtEncoder jwtEncoder;

    public JWTAuthentication(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @GetMapping("/authenticate")
    public JwtResponse jwtAuthenticate(Authentication authentication) {
        return getJwtResponse(authentication);
    }

    public JwtResponse getJwtResponse(Authentication authentication) {
        JwtClaimsSet claimSet = JwtClaimsSet.builder()
                .issuer("JWTDemo")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(900))
                .claim("scope", addScopeFromAuthentication(authentication))
                .build();
        JwtEncoderParameters parameters = JwtEncoderParameters.from(claimSet);
        String token = jwtEncoder.encode(parameters).getTokenValue();
        return new JwtResponse(token);
    }

    private String addScopeFromAuthentication(Authentication authentication) {
        return authentication.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.joining(","));
    }

}
