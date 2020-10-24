package ru.hotel.management.hotel.booking.kafka

import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

private val logging = KotlinLogging.logger {  }

//@Service
//class HotelConsumer {
//
//    @KafkaListener(topics = ["HOTEL_PUSH"])
//    fun consume(@Payload data: HotelPush?,
//                @Header(KafkaHeaders.OFFSET) offset: Int?,
//                @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) key: String?,
//                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int,
//                @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String?,
//                @Header(KafkaHeaders.RECEIVED_TIMESTAMP) ts: Long,
//                acknowledgment: Acknowledgment
//    ) {
//        logging.info(String.format("#### -> Consumed message -> offset: %d\nkey: %s\ndata: %s\npartition: %d\ntopic: %s", offset, key, data.toString(), partition, topic))
//        acknowledgment.acknowledge()
//    }
//}
