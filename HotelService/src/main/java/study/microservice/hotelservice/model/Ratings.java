package study.microservice.hotelservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ratings {

    private String reviewId;
    private String userId;
    private String hotelId;
    private int ratings;
    private String reviewComment;
}
