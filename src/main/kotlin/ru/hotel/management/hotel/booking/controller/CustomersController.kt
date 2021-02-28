package ru.hotel.management.hotel.booking.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.hotel.management.hotel.booking.domain.Customer
import ru.hotel.management.hotel.booking.domain.dto.BookRoomCustomerDTO
import ru.hotel.management.hotel.booking.domain.dto.CustomerDTO
import ru.hotel.management.hotel.booking.service.CustomersService

@Controller
@RequestMapping("/api/customers")
class CustomersController(
        val customersService: CustomersService
) {

    @PostMapping
    fun createHotel(@RequestBody dto: CustomerDTO): ResponseEntity<Customer> {
        return ResponseEntity.ok(customersService.createCustomer(dto))
    }

    @PostMapping("/book-room")
    fun addRoomToHotel(@RequestBody dto: BookRoomCustomerDTO): ResponseEntity<Customer> {
        return ResponseEntity.ok(customersService.bookRoomForCustomer(dto))
    }
}
