package ru.hotel.management.hotel.booking.listener

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.hotel.management.hotel.booking.domain.Room
import ru.hotel.management.hotel.booking.domain.message.HotelPush
import ru.hotel.management.hotel.booking.mapper.HotelPushMapper
import ru.hotel.management.hotel.booking.repository.HotelsRepository
import javax.persistence.PostPersist
import javax.persistence.PostUpdate

@Service
class RoomUpdateListener(
        val kafkaTemplate: KafkaTemplate<String, HotelPush>?,
        val hotelsRepository: HotelsRepository?,
        val hotelPushMapper: HotelPushMapper?
) {
    constructor(): this(null, null, null)

    @PostPersist
    @PostUpdate
    fun pushHotel(room: Room) {
        if (room.hotel == null) {
            return
        }
        val hotelOptional = hotelsRepository?.findById(room.hotel!!.id)
        if (hotelOptional!!.isPresent) {
            kafkaTemplate?.send("hotel.push", hotelPushMapper?.toHotelPush(hotelOptional.get()))
        }
    }
}