package ru.hotel.management.hotel.booking.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.hotel.management.hotel.booking.domain.Hotel
import ru.hotel.management.hotel.booking.domain.HotelFacility
import ru.hotel.management.hotel.booking.domain.Room
import ru.hotel.management.hotel.booking.domain.dto.AddHotelFacilityDTO
import ru.hotel.management.hotel.booking.domain.dto.AddRoomDTO
import ru.hotel.management.hotel.booking.domain.dto.HotelDTO
import ru.hotel.management.hotel.booking.domain.dto.HotelFacilityDTO
import ru.hotel.management.hotel.booking.service.HotelsService

@Controller
@RequestMapping("/api/hotels")
class HotelsController(
        val hotelsService: HotelsService
) {

    @PostMapping
    fun createHotel(@RequestBody dto: HotelDTO): ResponseEntity<Hotel> {
        return ResponseEntity.ok(hotelsService.createHotel(dto))
    }

    @PostMapping("/hotel-facility")
    fun createHotelFacility(@RequestBody dto: HotelFacilityDTO): ResponseEntity<HotelFacility> {
        return ResponseEntity.ok(hotelsService.createHotelFacility(dto))
    }

    @PostMapping("/add-hotel-facility")
    fun addHotelFacilityToHotel(@RequestBody dto: AddHotelFacilityDTO): ResponseEntity<Hotel> {
        return ResponseEntity.ok(hotelsService.addHotelFacilityToHotel(dto))
    }

    @PostMapping("/add-room")
    fun addRoomToHotel(@RequestBody dto: AddRoomDTO): ResponseEntity<Room> {
        return ResponseEntity.ok(hotelsService.addRoomToHotel(dto))
    }
}
