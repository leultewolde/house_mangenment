package com.leultewolde.house_mangenment.repositories;

import com.leultewolde.house_mangenment.models.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseOwnerRepository extends JpaRepository<HouseOwner, Long> {
    Optional<HouseOwner> findHouseOwnerByPhoneNumber(String phoneNumber);
}
