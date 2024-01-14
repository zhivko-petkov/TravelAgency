package fmi.plovdiv.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String contactName;

    private String phoneNumber;

    @ManyToOne(targetEntity = Holiday.class)
    @JoinColumn(name = "holiday")
    @JsonIgnore
    private Holiday holiday;
}
