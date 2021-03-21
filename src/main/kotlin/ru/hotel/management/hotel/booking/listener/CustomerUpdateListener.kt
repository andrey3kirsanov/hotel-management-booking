package ru.hotel.management.hotel.booking.listener

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.hotel.management.hotel.booking.domain.Customer
import ru.hotel.management.hotel.booking.domain.message.CustomerPush
import ru.hotel.management.hotel.booking.mapper.CustomerPushMapper
import javax.persistence.PostPersist
import javax.persistence.PostUpdate
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@Service
class CustomerUpdateListener(
        val customerKafkaTemplate: KafkaTemplate<String, CustomerPush>?,
        val customerPushMapper: CustomerPushMapper?
) {
    constructor(): this(null, null)

    @PrePersist
    @PreUpdate
    @PostPersist
    @PostUpdate
    fun pushCustomer(customer: Customer) {
        customerKafkaTemplate?.send("customer.push", customerPushMapper?.toCustomerPush(customer))
    }
}