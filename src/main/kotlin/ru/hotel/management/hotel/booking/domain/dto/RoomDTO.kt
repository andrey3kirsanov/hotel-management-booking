package ru.hotel.management.hotel.booking.domain.dto

import lombok.Builder
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Builder
class RoomDTO(val name: String, val description: String, val price: Int, var availableNumber: Int)
