package ru.hotel.management.hotel.booking.domain.message

import lombok.Getter
import lombok.Setter
import ru.hotel.management.hotel.booking.domain.HotelFacility
import java.time.Instant

@Getter
@Setter
class HotelPush(
        val id: Long,

        val name: String,

        val description: String,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        val facilities: List<HotelFacility>
)
