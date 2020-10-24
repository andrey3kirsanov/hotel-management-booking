package ru.hotel.management.hotel.booking.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.hotel.management.hotel.booking.domain.BookedRoom

interface BookedRoomsRepository : JpaRepository<BookedRoom, Long>
