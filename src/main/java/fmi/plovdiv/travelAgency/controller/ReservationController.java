package fmi.plovdiv.travelAgency.controller;

import fmi.plovdiv.travelAgency.entity.dto.create.CreateReservationDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseReservationDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateReservationDTO;
import fmi.plovdiv.travelAgency.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ResponseReservationDTO>> getAll() {
        try {
            List<ResponseReservationDTO> responseReservationDTOS = reservationService.getAll();
            log.info("Find all reservations");
            return ResponseEntity.ok(responseReservationDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ResponseReservationDTO> create(@RequestBody CreateReservationDTO createReservationDTO) {
        try {
            ResponseReservationDTO responseReservationDTO = reservationService.create(createReservationDTO);
            log.info("Create reservation " + responseReservationDTO.toString());
            return ResponseEntity.ok(responseReservationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        if (reservationService.deleteById(id)) {
            log.info("Delete reservation by id " + id);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseReservationDTO> getById(@PathVariable long id) {
        try {
            ResponseReservationDTO responseReservationDTO = reservationService.findById(id);
            log.info("Find reservation by id " + id);
            return ResponseEntity.ok(responseReservationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<ResponseReservationDTO> update(@RequestBody UpdateReservationDTO updateReservationDTO) {
        try {
            ResponseReservationDTO responseReservationDTO = reservationService.update(updateReservationDTO);
            log.info("Update reservation with id " + updateReservationDTO.getId());
            return ResponseEntity.ok(responseReservationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
