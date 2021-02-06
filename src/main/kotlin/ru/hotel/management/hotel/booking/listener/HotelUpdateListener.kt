package ru.hotel.management.hotel.booking.listener

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.hotel.management.hotel.booking.domain.Hotel
import ru.hotel.management.hotel.booking.domain.message.HotelPush
import ru.hotel.management.hotel.booking.mapper.HotelPushMapper
import javax.persistence.PostPersist
import javax.persistence.PostUpdate

@Service
class HotelUpdateListener(
        val kafkaTemplate: KafkaTemplate<String, HotelPush>?,
        val hotelPushMapper: HotelPushMapper?
) {
    constructor(): this(null, null)

    @PostPersist
    @PostUpdate
    fun pushHotel(hotel: Hotel) {
        kafkaTemplate?.send("hotel.push", hotelPushMapper?.toHotelPush(hotel))
    }
}