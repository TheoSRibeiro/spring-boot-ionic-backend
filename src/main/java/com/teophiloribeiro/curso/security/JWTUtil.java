package com.teophiloribeiro.curso.security;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;
    
    public String generateToken(String username){
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //cal.add(Calendar.HOUR_OF_DAY, Integer.valueOf(expiration.intValue()/60000));
        cal.add(Calendar.MINUTE, Integer.valueOf(expiration.intValue()/60000));
        cal.getTime();
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(cal.getTime())
            .signWith(SignatureAlgorithm.HS512, secret.getBytes())
            .compact();
    }

    public boolean tokenValido(String token){

        Claims claims = getClaims(token);

        if(claims != null){
            String userName = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());

            if(userName != null && expirationDate != null && now.before(expirationDate)){
                return true;
            }
        }
        return false;
    }

    public String getUsername(String token){
        Claims claims = getClaims(token);

        if(claims != null){
            return claims.getSubject();
        }
        return null;
    }

    private Claims getClaims(String token){
        try{
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        }catch (Exception e){
            return null;
        }
    }
}
