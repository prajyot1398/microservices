package study.microservice.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels", uniqueConstraints = { @UniqueConstraint(columnNames = { "hotel_name", "hotel_location" }) })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hotel {

    @Id
    private String id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name= "hotel_location")
    private String location;

    @Column(name="about")
    private String about;
}
