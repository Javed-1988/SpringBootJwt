package com.example.springbootweb.repository;

import com.example.springbootweb.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer>
{
public Optional<UserInfo> findByUsername(String username);
}
