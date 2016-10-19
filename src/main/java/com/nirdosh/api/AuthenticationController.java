package com.nirdosh.api;

import com.nirdosh.domain.model.user.User;
import com.nirdosh.infrastructure.persistence.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/authentication")
    public User isAuthenticated(@RequestParam String loginName, @RequestParam String password) {

        User user = userRepo.findByUserName(loginName);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

}
