package study.microservice.userservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {

    @JsonProperty(access = Access.READ_ONLY)  
    private String userId;

    private String email;

    private String name;

    private String about;

    private List<Review> reviewsByUser;
}
