package com.leultewolde.house_mangenment.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "firstname field can not be blank")
    private String firstname;
    @NotBlank(message = "lastname field can not be blank")
    private String lastname;
    @NotBlank(message = "phone numbers field can not be blank")
    private String phoneNumber;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<House> houses;

    public HouseOwner(String firstname, String lastname, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "HouseOwner{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", houses=" + houses +
                '}';
    }
}
