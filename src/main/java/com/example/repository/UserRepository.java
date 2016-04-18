package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.entity.User;

import java.util.List;

/**
 * Created by alex on 28/03/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
