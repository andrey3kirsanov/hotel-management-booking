package ru.hotel.management.hotel.booking.domain.dto

import lombok.Builder
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Builder
class AddRoomFacilityDTO(val roomFacilityId: Long, val roomId: Long)