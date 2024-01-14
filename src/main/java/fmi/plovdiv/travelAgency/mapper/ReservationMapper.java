package fmi.plovdiv.travelAgency.mapper;

import fmi.plovdiv.travelAgency.entity.Holiday;
import fmi.plovdiv.travelAgency.entity.Reservation;
import fmi.plovdiv.travelAgency.entity.dto.create.CreateReservationDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseReservationDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    List<ResponseReservationDTO> sourceListToResponseDto(List<Reservation> sourceList);

    @Mapping(source = "holiday", target = "holiday", qualifiedByName = "mapIdToHoliday")
    Reservation createDtoToSource(CreateReservationDTO createReservationDTO);

    @Mapping(source = "holiday", target = "holiday", qualifiedByName = "mapIdToHoliday")
    Reservation updateDtoToSource(UpdateReservationDTO updateReservationDTO);

    ResponseReservationDTO sourceToResponseDto(Reservation source);

    @Named("mapIdToHoliday")
    default Holiday mapIdToHoliday(Long id) {
        Holiday holiday = new Holiday();
        holiday.setId(id);
        return holiday;
    }
}
