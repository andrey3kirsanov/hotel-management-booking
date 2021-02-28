package ru.hotel.management.hotel.booking.mapper

import org.mapstruct.Mapper
import ru.hotel.management.hotel.booking.domain.Customer
import ru.hotel.management.hotel.booking.domain.message.CustomerPush

@Mapper(componentModel = "spring")
interface CustomerPushMapper {
    fun toCustomerPush(customer: Customer): CustomerPush
}