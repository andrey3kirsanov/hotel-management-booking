package ru.hotel.management.hotel.booking.exception

import java.lang.RuntimeException

class ClientErrorException : RuntimeException {
    constructor(message: String?, cause: Throwable?) : super(message, cause)

    constructor(message: String?) : super(message)
}