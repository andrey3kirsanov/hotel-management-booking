package ru.hotel.management.hotel.booking.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "booked_rooms")
class BookedRoom (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookedRoomsSeq")
    @SequenceGenerator(name = "bookedRoomsSeq", sequenceName = "booked_rooms_sequence", allocationSize = 1)
    val id: Long,

    @Column(name = "status")
    val status: String,

    @Column(name = "created_data_time")
    val createdDateTime: Instant,

    @Column(name = "updated_data_time")
    val updatedDateTime: Instant,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    val room: Room
)
