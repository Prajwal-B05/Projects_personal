package com.url.UrlShortner.Security.jwt;

import com.url.UrlShortner.Services.UserDetailsImpl;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
     @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private Integer jwtExpirationMs;

    //Autorization header Bearer <Token>
    public String getJwtFromHeader(HttpServletRequest request)
    {
        String bearerToken = request.getHeader("Authorization");

        if(bearerToken != null && bearerToken.startsWith("Bearer"))
        {
            return  bearerToken.substring(7);
        }
        return null;
    }

    public String GenerateToken(UserDetailsImpl userDetails)
    {
        String username = userDetails.getUsername();
        String Roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        return Jwts.builder().subject(username).claim("roles",Roles).issuedAt(new Date()).expiration(new Date(new Date().getTime()+ jwtExpirationMs)).signWith(key()).compact();
    }

    public String getUserNameFromJwtToken(String Token)
    {
        return Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(Token).getPayload().getSubject();
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateToken(String authToken)
    {
        try {
            Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(authToken);

            return true;
        } catch (JwtException e) {
            throw new RuntimeException(e);
        }

    }
}
