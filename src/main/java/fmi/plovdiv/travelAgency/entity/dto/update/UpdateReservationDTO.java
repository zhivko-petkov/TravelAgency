package fmi.plovdiv.travelAgency.entity.dto.update;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UpdateReservationDTO {

    private long id;

    private String contactName;

    private String phoneNumber;

    private long holiday;
}
