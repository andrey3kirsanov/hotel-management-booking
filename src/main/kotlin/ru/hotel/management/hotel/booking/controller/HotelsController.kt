package ru.hotel.management.hotel.booking.controller

import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.hotel.management.hotel.booking.domain.Hotel
import ru.hotel.management.hotel.booking.domain.HotelPush
import ru.hotel.management.hotel.booking.domain.dto.HotelDTO
import ru.hotel.management.hotel.booking.service.HotelsService

@Controller
@RequestMapping("/api/hotels")
class HotelsController(
        val hotelsService: HotelsService,
        val kafkaTemplate: KafkaTemplate<String, HotelPush>
) {

    @PostMapping
    fun createHotelFacility(@RequestBody dto: HotelDTO): ResponseEntity<Hotel> {
        val createdHotel = hotelsService.createHotel(dto)
        val hotelPush = HotelPush(createdHotel.id, createdHotel.name, createdHotel.description,
                createdHotel.createdDateTime, createdHotel.updatedDateTime, createdHotel.facilities)
        kafkaTemplate.send("hotel.push", hotelPush)
        return ResponseEntity.ok(createdHotel)
    }
}
