package com.example.backendai.repositories;
import com.example.backendai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    Optional <User> findById(int id);
}
