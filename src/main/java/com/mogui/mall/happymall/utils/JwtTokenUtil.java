package com.mogui.mall.happymall.utils;

import com.mogui.mall.happymall.pojo.MgUmUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *@author ke nan
 *@date 2020/6/12 22:12
 * jwt实现认证和授权
 * 1.用户调用登录接口，登录成功后生成token返回前端保存
 * 2.用户每次调用接口都在请求里携带上token
 * 3.后端对每次请求作校验
 */
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    //秘钥
    @Value("${jwt.secret}")
    private String secret;
    //有效时间
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 生成token的过期时间
     * 当前时间+设置的过期时间
     */
    private Date getExpirationDate(){
        return new Date(System.currentTimeMillis()+expiration * 1000);
    }
    /**
     * 根据负载生成token
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    /**
     * 根据用户信息生成token
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<String,Object>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }
    /**
     * 获取token中的负载
     */
    private Claims getClaimsFromToken(String token){

        Claims claims = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token)
                        .getBody();
        return  claims;
    }

    /**
     * 从token中获取用户名
     */
    public String getUserNameFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        String userNmae = claims.getSubject();
        return  userNmae;
    }

    /**
     * 验证token是否有效
     */
    public boolean isValidToken(String token,UserDetails userDetails){
        String userName = getUserNameFromToken(token);
        return userName.equals(userDetails.getUsername());
    }

    /**
     * 获取token过期时间
     */
    private Date tokenExpirationTime(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }
    /**
     * 判断token是否过期失效
     */
    private boolean isExpirationToken(String token){
        Date expirationTime = tokenExpirationTime(token);
        return new Date().after(expirationTime);
    }

    /**
     * 刷新token
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }
}
