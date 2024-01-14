package fmi.plovdiv.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "holidays")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Location.class)
    @JoinColumn(name = "location")
    @JsonIgnore
    private Location location;

    private String title;

    private LocalDate startDate;

    private int duration;

    private double price;

    private int freeSlots;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "holiday")
    private Set<Reservation> reservations;
}
