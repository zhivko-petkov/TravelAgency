package fmi.plovdiv.travelAgency.entity.dto.update;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UpdateLocationDTO {

    private long id;

    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;
}
