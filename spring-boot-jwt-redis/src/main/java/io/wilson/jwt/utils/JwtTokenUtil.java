//package io.wilson.jwt.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Header;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * JwtToken生成的工具类
// * JWT token的格式：header.payload.signature
// * header的格式（算法、token的类型）：
// * {"alg": "HS512","typ": "JWT"}
// * payload的格式（用户名、创建时间、生成时间）：
// * {"sub":"wang","created":1489079981393,"exp":1489684781}
// * signature的生成算法：
// * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
// * Created by macro on 2018/4/26.
// */
//@Component
//@Slf4j
//public class JwtTokenUtil {
//    private static final String CLAIM_KEY_CREATED = "created";
//    public static final String TOKEN_HEADER = "Authorization";
//    @Value("${jwt.secret:secretKey}")
//    private String secret;
//    @Value("${jwt.expiration:86400}")
//    private Long expiration;
//    /**
//     * token濒死时间
//     */
//    private static final long NEAR_DEATH_TIME = 300L;
//    @Resource
//    private RedisUtils redisUtils;
//
//    /**
//     * 根据负责生成JWT的token
//     */
//    private String generateToken(Map<String, Object> claims) {
//        String token = Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//        redisUtils.set(TOKEN_HEADER + ":" + token, claims.get(Claims.SUBJECT), 86400);
//        return token;
//    }
//
//    /**
//     * 从token中获取JWT中的负载
//     */
//    private Claims getClaimsFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    /**
//     * 生成token的过期时间
//     */
//    private Date generateExpirationDate() {
//        return new Date(System.currentTimeMillis() + expiration);
//    }
//
//    /**
//     * 从token中获取登录用户名
//     */
//    public String getUserNameFromToken(String token) {
//        return getClaimsFromToken(token).getSubject();
//    }
//
//    /**
//     * 验证token是否还有效
//     *
//     * @param token       客户端传入的token
//     * @param userDetails 从数据库中查询出来的用户信息
//     */
//    public boolean isValidToken(String token, UserDetails userDetails) {
//        return getUserNameFromToken(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    /**
//     * 根据过期时间校验token返回结果
//     *
//     * @param token       校验token值
//     * @param userDetails
//     * @return token未濒死返回原token<br>
//     * token濒死返回新token<br>
//     * token失效返回null
//     */
//    public String getValidateTokenResult(String token, UserDetails userDetails) {
//        String username = userDetails.getUsername();
//        if (!isTokenExpired(token) && getUserNameFromToken(token).equals(username)) {
//            if (isTokenNearDeath(token, NEAR_DEATH_TIME)) {
//                String newToken = generateToken(userDetails);
//                // todo 加分布式锁:分布式并发问题,2个请求发现token濒死,各自生成了新的token导致其中一个失效
//                redisUtils.set(newToken, username);
//                redisUtils.delete(token);
//                return newToken;
//            }
//            return token;
//        }
//        return null;
//    }
//
//    /**
//     * 判断token是否已经失效
//     */
//    private boolean isTokenExpired(String token) {
//        return getExpiredDateFromToken(token).before(new Date());
//    }
//
//    /**
//     * 判断token已达濒死状态
//     */
//    private boolean isTokenNearDeath(String token, long deathLongTime) {
//        return getExpiredDateFromToken(token).getTime() - System.currentTimeMillis() > deathLongTime;
//    }
//
//    /**
//     * 从token中获取过期时间
//     */
//    private Date getExpiredDateFromToken(String token) {
//        return getClaimsFromToken(token).getExpiration();
//    }
//
//    /**
//     * 根据用户信息生成token
//     */
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>(2);
//        claims.put(Claims.SUBJECT, userDetails.getUsername());
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }
//
//    /**
//     * 判断token是否可以被刷新
//     */
//    public boolean canRefresh(String token) {
//        return !isTokenExpired(token);
//    }
//
//    /**
//     * 刷新token
//     */
//    public String refreshToken(String token) {
//        Claims claims = getClaimsFromToken(token);
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }
//
//    public static void main(String[] args) {
//        Map<String, Object> claims = new HashMap<>(2);
//        claims.put(Claims.SUBJECT, "root");
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        System.out.println(Jwts.builder()
//                .setClaims(claims)
//                .signWith(SignatureAlgorithm.HS512, "secretKey")
//                .compact());
//
//        String pastToken = Jwts.builder()
//                .setSubject("321321")
//                .addClaims(claims)
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
//                .signWith(SignatureAlgorithm.HS512, "secretKey")
//                .setExpiration(new Date(System.currentTimeMillis() + 604800))
//                .compact();
//        System.out.println("pastToken:" + pastToken);
//        System.out.println("-----------");
//        System.out.println(Jwts.parser()
//                .setSigningKey("secretKey")
//                .parse(pastToken));
//    }
//}
