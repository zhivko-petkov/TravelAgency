package fmi.plovdiv.travelAgency.mapper;

import fmi.plovdiv.travelAgency.entity.Location;
import fmi.plovdiv.travelAgency.entity.dto.create.CreateLocationDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseLocationDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateLocationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    ResponseLocationDTO sourceToResponseDto(Location source);

    Location responseDtoToSource(ResponseLocationDTO response);

    List<ResponseLocationDTO> locationListToResponseDtoList(List<Location> locationList);

    Location createDtoToSource(CreateLocationDTO createLocationDTO);

    Location updateDtoToSource(UpdateLocationDTO updateLocationDTO);
}
