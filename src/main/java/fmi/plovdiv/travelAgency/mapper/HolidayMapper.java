package fmi.plovdiv.travelAgency.mapper;

import fmi.plovdiv.travelAgency.entity.Holiday;
import fmi.plovdiv.travelAgency.entity.Location;
import fmi.plovdiv.travelAgency.entity.dto.create.CreateHolidayDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseHolidayDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateHolidayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HolidayMapper {

    List<ResponseHolidayDTO> sourceListToResponseDto(List<Holiday> sourceList);

    @Mapping(source = "location", target = "location", qualifiedByName = "mapIdToLocation")
    Holiday createDtoToSource(CreateHolidayDTO createHolidayDTO);

    @Mapping(source = "location", target = "location", qualifiedByName = "mapIdToLocation")
    Holiday updateDtoToSource(UpdateHolidayDTO updateHolidayDTO);

    ResponseHolidayDTO sourceToResponseDto(Holiday source);

    @Named("mapIdToLocation")
    default Location mapIdToLocation(Long id) {
        Location current = new Location();
        current.setId(id);
        return current;
    }
}
