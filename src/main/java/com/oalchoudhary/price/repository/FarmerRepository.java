package com.oalchoudhary.price.repository;


import com.oalchoudhary.price.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    @Query("select u from Farmer u where u.phone_number = ?1")
    List<Farmer> findByPhone_number(String phone_number);


}
