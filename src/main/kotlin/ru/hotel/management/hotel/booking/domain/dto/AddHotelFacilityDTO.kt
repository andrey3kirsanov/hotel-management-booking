package ru.hotel.management.hotel.booking.domain.dto

import lombok.Builder
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Builder
class AddHotelFacilityDTO(val hotelFacilityId: Long, val hotelId: Long)