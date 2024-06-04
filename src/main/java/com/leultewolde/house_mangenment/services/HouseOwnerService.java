package com.leultewolde.house_mangenment.services;

import com.leultewolde.house_mangenment.models.HouseOwner;

import java.util.List;
import java.util.Optional;

public interface HouseOwnerService {
    HouseOwner addHouseOwner(HouseOwner houseOwner);
    HouseOwner updateHouseOwner(HouseOwner houseOwner);
    List<HouseOwner> getAllHouseOwners();
    Optional<HouseOwner> getHouseOwnerByPhoneNumber(String phoneNumber);
}
