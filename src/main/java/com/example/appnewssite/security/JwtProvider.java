package com.example.appnewssite.security;

import com.example.appnewssite.entity.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtProvider {
    static long expireTime=36_000_000;
   static String secretKey="BuTokenniMaxfiySuziHechKimBilmasin123456789lkqwajhdoiqwjpdojaspdojqwpodjapsjpdaojsdpoqjepdoajsdpoasjdpojwadpojo0";

    public   String generatedToken(String username, Set<Role> roles){
//        String token=com.auth0.jwt.JWT.create()
//                .withSubject(username)
//                .withIssuedAt(new Date())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 3_600 * 10000))
//                .sign(Algorithm.HMAC256(secretKey.getBytes()));

        String  token=Jwts.
                builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .claim("roles",roles)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
       return token;
    }
    public boolean validateToken(String token){
        try {





            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token).getBody();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getUserNameFromToken(String token){
        try{
            String username = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return username;
        }catch (Exception e){
            return  null;
        }
    }
}
