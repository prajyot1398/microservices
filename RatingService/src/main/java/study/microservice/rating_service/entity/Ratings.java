package study.microservice.rating_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Ratings")
@Builder
public class Ratings {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String reviewComment;
}
