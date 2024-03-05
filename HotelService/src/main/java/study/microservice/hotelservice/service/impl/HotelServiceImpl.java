package study.microservice.hotelservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.microservice.hotelservice.entity.Hotel;
import study.microservice.hotelservice.model.HotelModel;
import study.microservice.hotelservice.repo.HotelRepo;
import study.microservice.hotelservice.service.HotelService;
import study.microservice.hotelservice.util.HotelUtil;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepository;

    @Override
    public HotelModel saveHotel(HotelModel model) {
        if(model.getHotelId() != null) {
            //System.out.println("Cannot Pass Id While Creating User");
            throw new RuntimeException("Cannot Pass Id While Creating Hotel");
        }

        Hotel entity = HotelUtil.mapModelToEntity.apply(model);
        entity.setId(UUID.randomUUID().toString());
        entity = this.hotelRepository.save(entity);
        return HotelUtil.mapEntityToModel.apply(entity);
    }

    @Override
    public HotelModel getHotelById(String hotelId) {
        return HotelUtil.mapEntityToModel.apply(
            this.hotelRepository.findById(hotelId).orElseThrow(
                () -> {
                    throw new RuntimeException("No Hotel Found With Id : "+hotelId);
                }
            ));
    }

    @Override
    public List<HotelModel> getAllHotels() {
        return this.hotelRepository
            .findAll()
            .stream()
            .map((entity) -> HotelUtil.mapEntityToModel.apply(entity))
            .toList();
    }

    @Override
    public HotelModel getHotelByName(String hotelName) {
        return HotelUtil.mapEntityToModel.apply(
            this.hotelRepository.findByHotelName(hotelName).orElseThrow(
                () -> {
                    throw new RuntimeException("No Hotel Found With Name : "+hotelName);
                }
            ));
    }

}
