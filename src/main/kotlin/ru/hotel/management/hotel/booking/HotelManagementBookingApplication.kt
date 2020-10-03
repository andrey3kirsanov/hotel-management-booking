package ru.hotel.management.hotel.booking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(LiquibaseProperties::class)
class HotelManagementBookingApplication
fun main(args: Array<String>) {
    runApplication<HotelManagementBookingApplication>(*args)
}