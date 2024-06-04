package com.leultewolde.house_mangenment.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "address field cannot be blank")
    private String address;
    @ManyToOne
    @JoinColumn(name = "house_owner_id", referencedColumnName = "id")
    private HouseOwner owner;

    public House(String address, HouseOwner owner) {
        this.address = address;
        this.owner = owner;
    }

    public House(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                '}';
    }
}
