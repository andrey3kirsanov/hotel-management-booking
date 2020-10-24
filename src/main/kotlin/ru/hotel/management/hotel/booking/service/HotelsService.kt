package ru.hotel.management.hotel.booking.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hotel.management.hotel.booking.domain.HotelFacilities
import ru.hotel.management.hotel.booking.domain.dto.HotelFacilitiesDTO
import ru.hotel.management.hotel.booking.repository.HotelsFacilitiesRepository
import java.time.Instant

@Service
class HotelsService(
        val hotelsFacilitiesRepository: HotelsFacilitiesRepository
) {
    @Transactional
    fun createHotelFacility(dto: HotelFacilitiesDTO) : HotelFacilities {
        val hotelFacility = HotelFacilities(0L,
                dto.name, dto.description, Instant.now(), Instant.now()
        )
        return hotelsFacilitiesRepository.save(hotelFacility)
    }
}
