package com.nirdosh.api;

import com.nirdosh.domain.model.auth.Token;
import com.nirdosh.domain.model.auth.TokenGenerator;
import com.nirdosh.domain.model.errors.ApplicationExeption;
import com.nirdosh.domain.model.errors.BadArgumentException;
import com.nirdosh.domain.model.errors.UserNotFoundException;
import com.nirdosh.domain.model.user.User;
import com.nirdosh.infrastructure.persistence.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.xml.ws.WebServiceException;

@RestController
public class AuthenticationController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/authentication/{authorization}")
    public Token isAuthenticated(@PathVariable String authorization) throws ApplicationExeption{
        String credentials = new String(Base64.getDecoder().decode(authorization),
                Charset.forName("UTF-8"));
        final String[] usernamePasswordPair = credentials.split(":");
        if(usernamePasswordPair.length != 2){
            throw new BadArgumentException("Bad Argument");
        }
        String  userName = usernamePasswordPair[0].trim();
        String  password = usernamePasswordPair[1].trim();
        String passwordEncoded = Base64.getEncoder().encodeToString(password.getBytes());

        User user = userRepo.findByUserName(userName);
        Token token = null;
        if(user !=null && user.getPassword().equals(passwordEncoded)){
            token = TokenGenerator.nextToken();
        }else{
            throw new UserNotFoundException("Authentication failed!");
        }

        return token ;
    }

}
