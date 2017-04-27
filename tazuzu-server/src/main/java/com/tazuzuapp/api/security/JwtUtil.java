package com.tazuzuapp.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtUtil {

    @Autowired
    public JwtUtil(){}

    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "some-secret").compact();
    }

    public Claims parseToken(String token) throws SignatureException {
        return Jwts.parser().setSigningKey("some-secret").parseClaimsJws(token).getBody();
    }
}
