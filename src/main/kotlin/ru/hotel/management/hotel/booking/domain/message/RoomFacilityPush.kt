package ru.hotel.management.hotel.booking.domain.message

import java.time.Instant

class RoomFacilityPush(
        var id: Long,

        var name: String,

        var description: String,

        var createdDateTime: Instant,

        var updatedDateTime: Instant
)
