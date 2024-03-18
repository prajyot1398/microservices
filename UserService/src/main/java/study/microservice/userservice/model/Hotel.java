package study.microservice.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Hotel {

    private String hotelId;

    private String hotelName;

    private String hotelLocation;

    private String about;
    //private List<Ratings> reviewsForHotel;
}
