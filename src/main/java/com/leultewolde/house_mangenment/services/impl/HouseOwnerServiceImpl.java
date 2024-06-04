package com.leultewolde.house_mangenment.services.impl;

import com.leultewolde.house_mangenment.models.HouseOwner;
import com.leultewolde.house_mangenment.repositories.HouseOwnerRepository;
import com.leultewolde.house_mangenment.services.HouseOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseOwnerServiceImpl implements HouseOwnerService {

    private final HouseOwnerRepository repository;

    @Override
    public HouseOwner addHouseOwner(HouseOwner houseOwner) {
        return repository.save(houseOwner);
    }

    @Override
    public HouseOwner updateHouseOwner(HouseOwner houseOwner) {
        Optional<HouseOwner> optionalFoundHouseOwner = repository.findById(houseOwner.getId());
        if (optionalFoundHouseOwner.isPresent()) {
            HouseOwner foundHouseOwner = optionalFoundHouseOwner.get();
            foundHouseOwner.setFirstname(houseOwner.getFirstname());
            foundHouseOwner.setLastname(houseOwner.getLastname());
            foundHouseOwner.setHouses(houseOwner.getHouses());
            foundHouseOwner.setPhoneNumber(houseOwner.getPhoneNumber());
            return repository.save(foundHouseOwner);
        }
        return null;
    }

    @Override
    public List<HouseOwner> getAllHouseOwners() {
        List<HouseOwner> houseOwners = repository.findAll();
        return houseOwners.stream()
                .sorted(Comparator.comparing(HouseOwner::getPhoneNumber))
                .toList();
    }

    @Override
    public Optional<HouseOwner> getHouseOwnerByPhoneNumber(String phoneNumber) {
        return repository.findHouseOwnerByPhoneNumber(phoneNumber);
    }
}
