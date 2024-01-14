package fmi.plovdiv.travelAgency.entity.dto.update;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class UpdateHolidayDTO {

    private long id;

    private long location;

    private String title;

    private LocalDate startDate;

    private int duration;

    private String price;

    private int freeSlots;

}
