package ru.hotel.management.hotel.booking.domain.dto

import lombok.Builder
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Builder
class RoomFacilityDTO(val name: String, val description: String)