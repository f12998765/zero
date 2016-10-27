package com.x.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by xi on 16-10-23.
 */
public class TokenUtil {


    final static private String secret = "xizero";



    public static String CreatToken(int userid, String subject, long oktime) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
        long nowMillis = System. currentTimeMillis();

        Instant now = Instant.now();

        JwtBuilder builder = Jwts. builder()
                .setIssuer(String.valueOf(userid))
                .setIssuedAt(Date.from(now))
                .setSubject(subject)
                .signWith(signatureAlgorithm, secret);

        if (oktime >= 0){
            builder.setExpiration(Date.from(now.plusSeconds(oktime)));
        }
        return builder.compact();
    }


    public static Claims ParseToken(String token) throws Exception{

        Claims claims = Jwts. parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        return claims;
    }

}
