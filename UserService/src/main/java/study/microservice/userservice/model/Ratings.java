package study.microservice.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ratings {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int ratings;
    private String reviewComment;
}
