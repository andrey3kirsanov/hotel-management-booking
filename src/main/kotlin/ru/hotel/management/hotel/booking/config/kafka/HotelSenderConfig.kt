package ru.hotel.management.hotel.admin.config.kafka

//@Configuration
//class HotelSenderConfig {
//    @Value("\${spring.kafka.bootstrap-servers}")
//    private val bootstrapServers: String? = null
//
//    private val JAAS_TEMPLATE: String = "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"%s\" password=\"%s\";"
//
//    @Bean
//    fun producerConfigs(): Map<String, Any?> {
//        val props: MutableMap<String, Any?> = HashMap()
//        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
//        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
//        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
//        props[ProducerConfig.CLIENT_ID_CONFIG] = "booking"
//        props[ProducerConfig.RETRIES_CONFIG] = 2
//        val jaasConfig: String  = String.format(JAAS_TEMPLATE, "admin", "admin-secret");
//        props["sasl.jaas.config"] = jaasConfig
//        props["sasl.mechanism"] = "PLAIN"
//        props["security.protocol"] = "SASL_PLAINTEXT"
//        return props
//    }
//
//    @Bean
//    fun producerFactory(): ProducerFactory<String, HotelPush> {
//        return DefaultKafkaProducerFactory(producerConfigs())
//    }
//
//    @Bean
//    fun kafkaTemplate(): KafkaTemplate<String, HotelPush> {
//        return KafkaTemplate(producerFactory())
//    }
//}
