package fmi.plovdiv.travelAgency.service;

import fmi.plovdiv.travelAgency.entity.Holiday;
import fmi.plovdiv.travelAgency.entity.dto.create.CreateHolidayDTO;
import fmi.plovdiv.travelAgency.entity.dto.response.ResponseHolidayDTO;
import fmi.plovdiv.travelAgency.entity.dto.update.UpdateHolidayDTO;
import fmi.plovdiv.travelAgency.mapper.HolidayMapper;
import fmi.plovdiv.travelAgency.repository.HolidayRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HolidayService {

    private final HolidayRepository holidayRepository;

    private final HolidayMapper holidayMapper;

    public List<ResponseHolidayDTO> getAll() {
        List<ResponseHolidayDTO> holidayDTOS = holidayMapper.sourceListToResponseDto(holidayRepository.findAll());
        return holidayDTOS.stream().filter(h -> h.getFreeSlots() > 0).collect(Collectors.toList());
    }

    public ResponseHolidayDTO create(CreateHolidayDTO createHolidayDTO) {
        Holiday created = holidayRepository.save(holidayMapper.createDtoToSource(createHolidayDTO));
        return holidayMapper.sourceToResponseDto(created);
    }

    public Boolean deleteById(long id) {
        if (holidayRepository.findById(id).isPresent()){
            holidayRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResponseHolidayDTO findById(long id) {
        return holidayMapper.sourceToResponseDto(holidayRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found holiday with id " + id)));
    }

    public ResponseHolidayDTO update(UpdateHolidayDTO updateHolidayDTO) {
        Holiday created = holidayRepository.save(holidayMapper.updateDtoToSource(updateHolidayDTO));
        return holidayMapper.sourceToResponseDto(created);
    }
}
