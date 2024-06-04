package com.leultewolde.house_mangenment;

import com.leultewolde.house_mangenment.models.House;
import com.leultewolde.house_mangenment.models.HouseOwner;
import com.leultewolde.house_mangenment.services.HouseOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class HouseMangenmentApplication implements CommandLineRunner {

    private final HouseOwnerService houseOwnerService;

    @Override
    public void run(String... args) throws Exception {
        // Create Houses and House owners
        HouseOwner houseOwner1 = new HouseOwner("John","Doe", "233-455-667");
        HouseOwner houseOwner2 = new HouseOwner("Jane","Doe", "533-455-667");

        House house1 = new House("1000 N 4th St", houseOwner1);
        House house2 = new House("2000 S 5th St", houseOwner1);
        House house3 = new House("1000 main St", houseOwner2);
        House house4 = new House("2000 river ave", houseOwner2);

        houseOwner1.setHouses(List.of(house1, house2));
        houseOwner2.setHouses(List.of(house3, house4));

        houseOwnerService.addHouseOwner(houseOwner1);
        houseOwnerService.addHouseOwner(houseOwner2);

        // Update house owner
        Optional<HouseOwner> foundHouseOwner = houseOwnerService.getHouseOwnerByPhoneNumber("533-455-667");
        if (foundHouseOwner.isPresent()) {
            HouseOwner updatedHouseOwner = foundHouseOwner.get();
            updatedHouseOwner.setLastname("Smith");
            houseOwnerService.updateHouseOwner(updatedHouseOwner);
        }

        // get all house owners sorted by phone number
        houseOwnerService.getAllHouseOwners()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(HouseMangenmentApplication.class, args);
    }

}
