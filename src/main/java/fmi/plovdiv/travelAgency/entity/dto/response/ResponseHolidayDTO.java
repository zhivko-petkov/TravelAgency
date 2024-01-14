package fmi.plovdiv.travelAgency.entity.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class ResponseHolidayDTO {

    private long id;

    private ResponseLocationDTO location;

    private String title;

    private LocalDate startDate;

    private int duration;

    private double price;

    private int freeSlots;

}
