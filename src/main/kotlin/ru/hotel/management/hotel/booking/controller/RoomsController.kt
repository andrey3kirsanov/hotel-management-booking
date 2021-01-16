package ru.hotel.management.hotel.booking.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.hotel.management.hotel.booking.domain.Room
import ru.hotel.management.hotel.booking.domain.RoomFacility
import ru.hotel.management.hotel.booking.domain.dto.AddRoomFacilityDTO
import ru.hotel.management.hotel.booking.domain.dto.BookedRoomDTO
import ru.hotel.management.hotel.booking.domain.dto.RoomDTO
import ru.hotel.management.hotel.booking.domain.dto.RoomFacilityDTO
import ru.hotel.management.hotel.booking.service.RoomsService

@Controller
@RequestMapping("/api/rooms")
class RoomsController(
        val roomsService: RoomsService
) {

    @PostMapping
    fun createRoom(@RequestBody dto: RoomDTO): ResponseEntity<Room> {
        return ResponseEntity.ok(roomsService.createRoom(dto))
    }

    @PostMapping("/room-facility")
    fun createRoomFacility(@RequestBody dto: RoomFacilityDTO): ResponseEntity<RoomFacility> {
        return ResponseEntity.ok(roomsService.createRoomFacility(dto))
    }

    @PostMapping("/add-room-facility")
    fun addRoomFacilityToRoom(@RequestBody dto: AddRoomFacilityDTO): ResponseEntity<Room> {
        return ResponseEntity.ok(roomsService.addRoomFacilityToRoom(dto))
    }

    @PostMapping("/book-room")
    fun bookRoom(@RequestBody dto: BookedRoomDTO): ResponseEntity<Room> {
        return ResponseEntity.ok(roomsService.bookRoom(dto))
    }
}
