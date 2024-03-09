package study.microservice.rating_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RatingsModel {

    @JsonProperty(access = Access.READ_ONLY) 
    private String ratingId;
    private String userId;
    private String hotelId;
    private int ratings;
    private String reviewComment;
}   
