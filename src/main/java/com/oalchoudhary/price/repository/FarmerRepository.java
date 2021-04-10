package com.oalchoudhary.price.repository;


import com.oalchoudhary.price.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
}
