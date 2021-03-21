package ru.hotel.management.hotel.booking.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import ru.hotel.management.hotel.booking.listener.CustomerUpdateListener
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*

@Entity
@EntityListeners(value = arrayOf(CustomerUpdateListener::class))
@Table(name = "customers")
class Customer(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customersSeq")
        @SequenceGenerator(name = "customersSeq", sequenceName = "customers_sequence", allocationSize = 1)
        var id: Long,

        @Column(name = "first_name")
        var firstName: String,

        @Column(name = "last_name")
        var lastName: String,

        @Column(name = "date_of_birth")
        var dateOfBirth: LocalDate,

        @Column(name = "created_date_time")
        var createdDateTime: Instant,

        @Column(name = "updated_date_time")
        var updatedDateTime: Instant,

        @JsonIgnore
        @ManyToMany
        @JoinTable(name = "customers_rooms",
                joinColumns = [JoinColumn(name = "customer_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "room_id", referencedColumnName = "id")])
        var rooms: MutableList<Room>
)
