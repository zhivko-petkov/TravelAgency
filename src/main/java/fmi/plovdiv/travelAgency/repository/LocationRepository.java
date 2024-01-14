package fmi.plovdiv.travelAgency.repository;

import fmi.plovdiv.travelAgency.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
