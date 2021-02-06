package ru.hotel.management.hotel.booking.mapper

import org.mapstruct.Mapper
import ru.hotel.management.hotel.booking.domain.Hotel
import ru.hotel.management.hotel.booking.domain.message.HotelPush

@Mapper(componentModel = "spring")
interface HotelPushMapper {
    fun toHotelPush(hotel: Hotel): HotelPush
}