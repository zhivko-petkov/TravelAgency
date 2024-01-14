package fmi.plovdiv.travelAgency.entity.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponseLocationDTO {

    private long id;

    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;
}
