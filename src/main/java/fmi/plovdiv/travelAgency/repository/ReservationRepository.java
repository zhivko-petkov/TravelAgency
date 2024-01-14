package fmi.plovdiv.travelAgency.repository;

import fmi.plovdiv.travelAgency.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
