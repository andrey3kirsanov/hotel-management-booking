package ru.hotel.management.hotel.booking.domain.dto

import lombok.Builder
import lombok.Getter
import lombok.Setter
import java.time.LocalDate

@Getter
@Setter
@Builder
class CustomerDTO(val firstName: String, val lastName: String, val dateOfBirth: LocalDate)