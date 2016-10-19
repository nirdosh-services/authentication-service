package com.nirdosh.infrastructure.persistence;

import com.nirdosh.domain.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String>{

    User findByUserName(String userName);
}
