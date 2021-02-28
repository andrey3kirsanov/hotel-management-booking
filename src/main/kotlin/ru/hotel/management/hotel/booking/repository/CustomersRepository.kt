package ru.hotel.management.hotel.booking.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.hotel.management.hotel.booking.domain.Customer

interface CustomersRepository : JpaRepository<Customer, Long>
