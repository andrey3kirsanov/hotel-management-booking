package ru.hotel.management.hotel.booking.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hotel.management.hotel.booking.domain.Customer
import ru.hotel.management.hotel.booking.domain.dto.BookRoomCustomerDTO
import ru.hotel.management.hotel.booking.domain.dto.CustomerDTO
import ru.hotel.management.hotel.booking.enums.RoomStatus
import ru.hotel.management.hotel.booking.exception.ClientErrorException
import ru.hotel.management.hotel.booking.repository.CustomersRepository
import ru.hotel.management.hotel.booking.repository.RoomsRepository
import java.time.Instant
import java.util.*

@Service
class CustomersService(
        val customersRepository: CustomersRepository,
        val roomsRepository: RoomsRepository
) {
    @Transactional
    fun createCustomer(dto: CustomerDTO): Customer {
        val customer = Customer(0L,
                dto.firstName, dto.lastName, dto.dateOfBirth, Instant.now(), Instant.now(), Collections.emptyList()
        )
        return customersRepository.save(customer)
    }

    @Transactional
    fun bookRoomForCustomer(dto: BookRoomCustomerDTO): Customer {
        val room = roomsRepository.findById(dto.roomId)
                .orElseThrow { throw ClientErrorException("Room is not found") }
        val customer = customersRepository.findById(dto.customerId)
                .orElseThrow { throw ClientErrorException("Customer is not found") }
        room.bookedNumber++

        if (room.bookedNumber > room.availableNumber) {
            throw ClientErrorException("Room is already booked by somebody")
        }
        room.status = RoomStatus.BOOKED
        room.bookedDateTime = Instant.now()

        roomsRepository.save(room)

        customer.rooms.add(room)
        customer.updatedDateTime = Instant.now()
        return customersRepository.save(customer)
    }
}