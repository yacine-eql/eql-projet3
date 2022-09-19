package com.eql.repository;

import com.eql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);




    Boolean existsByEmail(String email);

}
