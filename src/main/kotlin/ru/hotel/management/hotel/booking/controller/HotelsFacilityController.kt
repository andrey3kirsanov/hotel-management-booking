package ru.hotel.management.hotel.booking.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.hotel.management.hotel.booking.domain.HotelFacilities
import ru.hotel.management.hotel.booking.domain.dto.HotelFacilitiesDTO
import ru.hotel.management.hotel.booking.service.HotelsService

@Controller
@RequestMapping("/api/hotels-facilities")
class HotelsFacilityController(
        val hotelsService: HotelsService
) {

    @PostMapping
    fun createHotelFacility(@RequestBody dto: HotelFacilitiesDTO): ResponseEntity<HotelFacilities> {
        return ResponseEntity.ok(hotelsService.createHotelFacility(dto))
    }
}
