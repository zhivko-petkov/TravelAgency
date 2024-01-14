package fmi.plovdiv.travelAgency.controller;

import fmi.plovdiv.travelAgency.entity.dto.create.CreateLocationDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseLocationDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateLocationDTO;
import fmi.plovdiv.travelAgency.service.LocationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@AllArgsConstructor
@Slf4j
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<ResponseLocationDTO>> getAll() {
        try {
            List<ResponseLocationDTO> locationDTOS = locationService.getAll();
            log.info("Find all locations");
            return ResponseEntity.ok(locationDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ResponseLocationDTO> create(@RequestBody CreateLocationDTO createLocationDTO) {
        try {
            ResponseLocationDTO responseLocationDTO = locationService.create(createLocationDTO);
            log.info("Create location " + createLocationDTO.toString());
            return ResponseEntity.ok(responseLocationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        if (locationService.deleteById(id)) {
            log.info("Delete location by id " + id);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseLocationDTO> getById(@PathVariable long id) {
        try {
            ResponseLocationDTO responseLocationDTO = locationService.findById(id);
            log.info("Find location by id " + id);
            return ResponseEntity.ok(responseLocationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<ResponseLocationDTO> update(@RequestBody UpdateLocationDTO updateLocationDTO) {
        try {
            ResponseLocationDTO responseLocationDTO = locationService.update(updateLocationDTO);
            log.info("Update location with id " + updateLocationDTO.getId());
            return ResponseEntity.ok(responseLocationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
