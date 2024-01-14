package fmi.plovdiv.travelAgency.controller;

import fmi.plovdiv.travelAgency.entity.dto.create.CreateHolidayDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseHolidayDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateHolidayDTO;
import fmi.plovdiv.travelAgency.service.HolidayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
@Slf4j
public class HolidayController {

    private final HolidayService holidayService;

    @GetMapping
    public ResponseEntity<List<ResponseHolidayDTO>> getAll() {
        try {
            List<ResponseHolidayDTO> responseHolidayDTOS = holidayService.getAll();
            log.info("Find all holidays");
            return ResponseEntity.ok(responseHolidayDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ResponseHolidayDTO> create(@RequestBody CreateHolidayDTO createHolidayDTO) {
        try {
            ResponseHolidayDTO responseHolidayDTO = holidayService.create(createHolidayDTO);
            log.info("Create holiday " + createHolidayDTO.toString());
            return ResponseEntity.ok(responseHolidayDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        try {
            boolean isDeleted = holidayService.deleteById(id);
            log.info("Delete holiday by id " + id);
            return ResponseEntity.ok(isDeleted);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseHolidayDTO> getById(@PathVariable long id) {
        try {
            ResponseHolidayDTO responseHolidayDTO = holidayService.findById(id);
            log.info("Delete holiday by id " + id);
            return ResponseEntity.ok(responseHolidayDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<ResponseHolidayDTO> update(@RequestBody UpdateHolidayDTO updateHolidayDTO) {
        try {
            ResponseHolidayDTO responseHolidayDTO = holidayService.update(updateHolidayDTO);
            return ResponseEntity.ok(responseHolidayDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
