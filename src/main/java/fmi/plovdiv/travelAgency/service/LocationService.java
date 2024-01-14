package fmi.plovdiv.travelAgency.service;

import fmi.plovdiv.travelAgency.entity.Location;
import fmi.plovdiv.travelAgency.entity.dto.create.CreateLocationDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseLocationDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateLocationDTO;
import fmi.plovdiv.travelAgency.mapper.LocationMapper;
import fmi.plovdiv.travelAgency.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;

    public List<ResponseLocationDTO> getAll() {
        return locationMapper.locationListToResponseDtoList(locationRepository.findAll());
    }

    public ResponseLocationDTO create(CreateLocationDTO createLocationDTO) {
        return locationMapper.sourceToResponseDto(locationRepository.save(locationMapper.createDtoToSource(createLocationDTO)));
    }

    public ResponseLocationDTO findById(long id) {
        return locationMapper.sourceToResponseDto(locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found location with id " + id)));
    }

    public ResponseLocationDTO update(UpdateLocationDTO updateLocationDTO) {
        Location created = locationRepository.save(locationMapper.updateDtoToSource(updateLocationDTO));
        return locationMapper.sourceToResponseDto(created);
    }

    public Boolean deleteById(long id) {
        if (locationRepository.findById(id).isPresent()) {
            locationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
