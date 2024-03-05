package study.microservice.hotelservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import study.microservice.hotelservice.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

    Optional<Hotel> findByHotelName(String hotelName);
}
