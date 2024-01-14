package fmi.plovdiv.travelAgency.entity.dto.create;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CreateLocationDTO {

    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;
}
