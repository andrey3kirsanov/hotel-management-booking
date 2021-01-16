package ru.hotel.management.hotel.booking.domain.dto

import lombok.Builder
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Builder
class AddRoomDTO(val roomId: Long, val hotelId: Long)