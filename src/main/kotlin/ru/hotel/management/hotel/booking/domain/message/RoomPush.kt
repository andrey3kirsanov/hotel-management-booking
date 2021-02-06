package ru.hotel.management.hotel.booking.domain.message

import ru.hotel.management.hotel.booking.enums.RoomStatus
import java.time.Instant

class RoomPush(
        var id: Long,

        var name: String,

        var description: String,

        var status: RoomStatus,

        var price: Int = 0,

        var availableNumber: Int = 0,

        var bookedNumber: Int = 0,

        var createdDateTime: Instant,

        var updatedDateTime: Instant,

        var bookedDateTime: Instant?,

        var facilities: List<RoomFacilityPush>
)
