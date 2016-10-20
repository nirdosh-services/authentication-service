package com.nirdosh.api;

import com.nirdosh.domain.model.user.User;
import com.nirdosh.infrastructure.persistence.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import javax.xml.ws.WebServiceException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    public static final String SECRET_KEY = "this_is_my_secret_key_to_test_123";

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/authentication")
    public String authenticate(@RequestParam String username, @RequestParam String password) {

        User user = userRepo.findByUserName(username);
        if(user == null || isNotAuthenticated(user, password)){
            throw new WebServiceException("Not authorized");
        }
        return getJwtToken(username, user);
    }

    private String getJwtToken(@RequestParam String username, User user) {
        String  token = Jwts.builder()
                        .setSubject(username)
                        .claim("roles", user.getId())
                        .setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                        .compact();

        return token;
    }

    private boolean isNotAuthenticated(User user, String password) {
        return !user.getPassword().equals(password);
    }

    @RequestMapping("/validate")
    public Claims validate(String jwtToken){
        Claims claims = Jwts.parser()
                            .setSigningKey(SECRET_KEY)
                            .parseClaimsJws(jwtToken)
                            .getBody();
        return claims;
    }
}
