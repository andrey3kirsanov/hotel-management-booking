package ru.hotel.management.hotel.booking.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hotel.management.hotel.booking.domain.Hotel
import ru.hotel.management.hotel.booking.domain.HotelFacility
import ru.hotel.management.hotel.booking.domain.dto.AddHotelFacilityDTO
import ru.hotel.management.hotel.booking.domain.dto.AddRoomDTO
import ru.hotel.management.hotel.booking.domain.dto.HotelDTO
import ru.hotel.management.hotel.booking.domain.dto.HotelFacilityDTO
import ru.hotel.management.hotel.booking.exception.ClientErrorException
import ru.hotel.management.hotel.booking.repository.HotelsFacilityRepository
import ru.hotel.management.hotel.booking.repository.HotelsRepository
import ru.hotel.management.hotel.booking.repository.RoomsRepository
import java.time.Instant
import java.util.*

@Service
class HotelsService(
        val hotelsRepository: HotelsRepository,
        val hotelsFacilityRepository: HotelsFacilityRepository,
        val roomsRepository: RoomsRepository
) {
    @Transactional
    fun createHotel(dto: HotelDTO) : Hotel {
        val hotel = Hotel(0L,
                dto.name, dto.description, Instant.now(), Instant.now(), Collections.emptyList(),
                Collections.emptyList()
        )
        return hotelsRepository.save(hotel)
    }

    @Transactional
    fun createHotelFacility(dto: HotelFacilityDTO) : HotelFacility {
        val hotelFacility = HotelFacility(0L,
                dto.name, dto.description, Instant.now(), Instant.now(), Collections.emptyList()
        )
        return hotelsFacilityRepository.save(hotelFacility)
    }

    @Transactional
    fun addHotelFacilityToHotel(dto: AddHotelFacilityDTO) : Hotel {
        val hotel = hotelsRepository.findById(dto.hotelId)
                .orElseThrow { throw ClientErrorException("Hotel is not found") }
        val hotelFacility = hotelsFacilityRepository.findById(dto.hotelFacilityId)
                .orElseThrow { throw ClientErrorException("Hotel Facility is not found") }

        hotel.facilities.add(hotelFacility)
        return hotelsRepository.save(hotel)
    }

    @Transactional
    fun addRoomToHotel(dto: AddRoomDTO) : Hotel {
        val hotel = hotelsRepository.findById(dto.hotelId)
                .orElseThrow { throw ClientErrorException("Hotel is not found") }
        val room = roomsRepository.findById(dto.roomId)
                .orElseThrow { throw ClientErrorException("Room is not found") }

        hotel.rooms.add(room)
        return hotelsRepository.save(hotel)
    }

}
