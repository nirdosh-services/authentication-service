package com.nirdosh.api;

import com.nirdosh.domain.model.User;
import com.nirdosh.infrastructure.persistence.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/authentication/{authorization}")
    public boolean isAuthenticated(@PathVariable String authorization){
        String base64Credentials = authorization.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                Charset.forName("UTF-8"));
        final String[] usernamePasswordPair = credentials.split(":");
        String  userName = usernamePasswordPair[0].trim();
        String  password = usernamePasswordPair[1].trim();

        User user = userRepo.findByUserName(userName);
        if(user !=null && user.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
