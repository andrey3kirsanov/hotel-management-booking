package ru.hotel.management.hotel.booking.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hotel.management.hotel.booking.domain.Hotel
import ru.hotel.management.hotel.booking.domain.HotelFacilities
import ru.hotel.management.hotel.booking.domain.dto.HotelDTO
import ru.hotel.management.hotel.booking.domain.dto.HotelFacilitiesDTO
import ru.hotel.management.hotel.booking.repository.HotelsFacilitiesRepository
import ru.hotel.management.hotel.booking.repository.HotelsRepository
import java.time.Instant
import java.util.*

@Service
class HotelsService(
        val hotelsRepository: HotelsRepository,
        val hotelsFacilitiesRepository: HotelsFacilitiesRepository
) {
    @Transactional
    fun createHotel(dto: HotelDTO) : Hotel {
        val hotel = Hotel(0L,
                dto.name, dto.description, Instant.now(), Instant.now(), Collections.emptyList()
        )
        return hotelsRepository.save(hotel)
    }

    @Transactional
    fun createHotelFacility(dto: HotelFacilitiesDTO) : HotelFacilities {
        val hotelFacility = HotelFacilities(0L,
                dto.name, dto.description, Instant.now(), Instant.now()
        )
        return hotelsFacilitiesRepository.save(hotelFacility)
    }

}
