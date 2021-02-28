package ru.hotel.management.hotel.booking.listener

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.hotel.management.hotel.booking.domain.Customer
import ru.hotel.management.hotel.booking.domain.message.CustomerPush
import ru.hotel.management.hotel.booking.mapper.CustomerPushMapper
import javax.persistence.PostPersist
import javax.persistence.PostUpdate

@Service
class CustomerUpdateListener(
        val customerKafkaTemplate: KafkaTemplate<String, CustomerPush>?,
        val customerPushMapper: CustomerPushMapper?
) {
    constructor(): this(null, null)

    @PostPersist
    @PostUpdate
    fun pushHotel(customer: Customer) {
        customerKafkaTemplate?.send("customer.push", customerPushMapper?.toCustomerPush(customer))
    }
}