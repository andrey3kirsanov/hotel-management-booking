package ru.hotel.management.hotel.booking.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hotel.management.hotel.booking.domain.Room
import ru.hotel.management.hotel.booking.domain.RoomFacility
import ru.hotel.management.hotel.booking.domain.dto.AddRoomFacilityDTO
import ru.hotel.management.hotel.booking.domain.dto.BookedRoomDTO
import ru.hotel.management.hotel.booking.domain.dto.RoomDTO
import ru.hotel.management.hotel.booking.domain.dto.RoomFacilityDTO
import ru.hotel.management.hotel.booking.enums.BookedRoomStatus
import ru.hotel.management.hotel.booking.exception.ClientErrorException
import ru.hotel.management.hotel.booking.repository.HotelsRepository
import ru.hotel.management.hotel.booking.repository.RoomsFacilityRepository
import ru.hotel.management.hotel.booking.repository.RoomsRepository
import java.time.Instant
import java.util.*

@Service
class RoomsService(
        val hotelsRepository: HotelsRepository,
        val roomsRepository: RoomsRepository,
        val roomsFacilityRepository: RoomsFacilityRepository
) {
    @Transactional
    fun createRoom(dto: RoomDTO) : Room {
        val hotel = hotelsRepository.findById(dto.hotelId)
                .orElseThrow{ throw ClientErrorException("Hotel is not found") }

        val room = Room(0L,
                dto.name, dto.description, BookedRoomStatus.AVAILABLE, dto.price,
                dto.availableNumber, 0, Instant.now(), Instant.now(), null,
                hotel, Collections.emptyList()
        )
        return roomsRepository.save(room)
    }

    @Transactional
    fun createRoomFacility(dto: RoomFacilityDTO) : RoomFacility {
        val roomFacility = RoomFacility(0L,
                dto.name, dto.description, Instant.now(), Instant.now(), Collections.emptyList()
        )
        return roomsFacilityRepository.save(roomFacility)
    }

    @Transactional
    fun addRoomFacilityToRoom(dto: AddRoomFacilityDTO) : Room {
        val room = roomsRepository.findById(dto.roomId)
                .orElseThrow { throw ClientErrorException("Room is not found") }
        val roomFacility = roomsFacilityRepository.findById(dto.roomFacilityId)
                .orElseThrow { throw ClientErrorException("Room Facility is not found") }

        room.facilities.add(roomFacility)
        return roomsRepository.save(room)

    }

    @Transactional
    fun bookRoom(dto: BookedRoomDTO) : Room {
        val room = roomsRepository.findById(dto.roomId)
                .orElseThrow { throw ClientErrorException("Room is not found") }
        room.bookedNumber++

        if (room.bookedNumber > room.availableNumber) {
            throw ClientErrorException("Room is already booked by somebody")
        }
        room.status = BookedRoomStatus.BOOKED
        room.bookedDateTime = Instant.now()
        return roomsRepository.save(room)
    }

}
