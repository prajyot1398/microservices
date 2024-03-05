package study.microservice.hotelservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HotelModel {

    
    @JsonProperty(access = Access.READ_ONLY)  
    private String hotelId;

    private String hotelName;

    private String hotelLocation;

    private String about;

    private List<Review> reviewsForHotel;
}
