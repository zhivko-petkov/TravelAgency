package fmi.plovdiv.travelAgency.entity.dto.create;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CreateReservationDTO {

    private String contactName;

    private String phoneNumber;

    private long holiday;

}
