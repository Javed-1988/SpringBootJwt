package com.example.springbootweb.repository;

import com.example.springbootweb.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Addressrepository extends JpaRepository<Address,Integer> {
}
