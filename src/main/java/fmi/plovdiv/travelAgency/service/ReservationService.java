package fmi.plovdiv.travelAgency.service;

import fmi.plovdiv.travelAgency.entity.Holiday;
import fmi.plovdiv.travelAgency.entity.Reservation;
import fmi.plovdiv.travelAgency.entity.dto.create.CreateReservationDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseReservationDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateReservationDTO;
import fmi.plovdiv.travelAgency.mapper.ReservationMapper;
import fmi.plovdiv.travelAgency.repository.HolidayRepository;
import fmi.plovdiv.travelAgency.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final HolidayRepository holidayRepository;

    private final ReservationMapper reservationMapper;

    public List<ResponseReservationDTO> getAll() {
        return reservationMapper.sourceListToResponseDto(reservationRepository.findAll());
    }

    public ResponseReservationDTO create(CreateReservationDTO createReservationDTO) throws OperationNotSupportedException {
        Reservation createdReservation = reservationMapper.createDtoToSource(createReservationDTO);
        if (nonNull(createdReservation)) {
            Holiday foundHol = holidayRepository.findById(createdReservation.getHoliday().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Not found holiday for your reservation"));
            int countOfRest = foundHol.getFreeSlots();

            if (countOfRest > 0) {
                countOfRest--;
                foundHol.setFreeSlots(countOfRest);
                createdReservation = reservationRepository.save(createdReservation);
                holidayRepository.save(foundHol);
                return reservationMapper.sourceToResponseDto(createdReservation);
            }
        }
       return null;
    }

    public ResponseReservationDTO findById(long id) {
        return reservationMapper.sourceToResponseDto(reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found reservation with id " + id)));
    }

    public ResponseReservationDTO update(UpdateReservationDTO updateReservationDTO) {
        Reservation created = reservationRepository.save(reservationMapper.updateDtoToSource(updateReservationDTO));
        return reservationMapper.sourceToResponseDto(created);
    }

    public Boolean deleteById(long id) {
        Optional<Reservation> createdReservation = reservationRepository.findById(id);
        if (createdReservation.isPresent()) {
            reservationRepository.deleteById(id);
            Holiday foundHol = holidayRepository.findById(createdReservation.get().getHoliday().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Not found holiday with id " + createdReservation.get().getHoliday().getId()));
            int countOfRest = foundHol.getFreeSlots();
            countOfRest++;
            foundHol.setFreeSlots(countOfRest);
            holidayRepository.save(foundHol);
            return true;
        }
        return false;
    }
}
