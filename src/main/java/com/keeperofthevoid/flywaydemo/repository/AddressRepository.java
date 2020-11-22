package com.keeperofthevoid.flywaydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keeperofthevoid.flywaydemo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
