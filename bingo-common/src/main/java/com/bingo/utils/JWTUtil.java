package com.bingo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 徐志斌
 * @Date: 2023/5/8 21:46
 * @Version 1.0
 * @Description: JWTUtil
 */
public class JWTUtil {
    public static final long EXPIRE = 86400000;
    public static final String JWT_SECRET = "Bingo_XuZhiBin_666";

    /**
     * 生成 Token
     */
    public static String generateToken(String userId) {
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("Bingo")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
        return JwtToken;
    }

    /**
     * 解析 Token
     */
    public static Map<String, String> resolveToken(String token) {
        Map<String, String> resultMap = new HashMap<>();
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String userId = (String) claims.get("userId");
        resultMap.put("userId", userId);
        return resultMap;
    }
}
