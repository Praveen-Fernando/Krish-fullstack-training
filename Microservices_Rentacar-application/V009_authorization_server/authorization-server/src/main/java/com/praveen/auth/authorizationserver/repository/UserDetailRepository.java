package com.praveen.auth.authorizationserver.repository;

import com.praveen.auth.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {

    Optional<User> findByName(String name);

}
