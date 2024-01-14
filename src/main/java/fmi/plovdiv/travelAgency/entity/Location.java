package fmi.plovdiv.travelAgency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "locations")
@Getter
@Setter
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "location")
    private Set<Holiday> holidays;
}
