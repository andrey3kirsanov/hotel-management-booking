package ru.hotel.management.hotel.booking.domain.message

import lombok.Getter
import lombok.Setter
import java.time.Instant
import java.time.LocalDate

@Getter
@Setter
class CustomerPush(
        val id: Long,

        val firstName: String,

        val lastName: String,

        val dateOfBirth: LocalDate,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        val rooms: List<RoomPush>
)
