package fmi.plovdiv.travelAgency.entity.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponseReservationDTO {

    private long id;

    private String contactName;

    private String phoneNumber;

    private ResponseHolidayDTO holiday;
}
