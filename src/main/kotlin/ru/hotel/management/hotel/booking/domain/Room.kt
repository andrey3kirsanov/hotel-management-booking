package ru.hotel.management.hotel.booking.domain

import lombok.Getter
import lombok.Setter
import ru.hotel.management.hotel.booking.enums.BookedRoomStatus
import java.time.Instant
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "rooms")
class Room(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomsSeq")
    @SequenceGenerator(name = "roomsSeq", sequenceName = "rooms_sequence", allocationSize = 1)
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "status")
    var status: BookedRoomStatus,

    @Column(name = "price")
    var price: Int = 0,

    @Column(name = "available_number")
    var availableNumber: Int = 0,

    @Column(name = "booked_number")
    var bookedNumber: Int = 0,

    @Column(name = "created_data_time")
    var createdDateTime: Instant,

    @Column(name = "updated_data_time")
    var updatedDateTime: Instant,

    @Column(name = "booked_data_time")
    var bookedDateTime: Instant?,

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    var hotel: Hotel,

    @ManyToMany
    @JoinTable(name = "hotels_rooms",
            joinColumns = [JoinColumn(name = "room_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "facility_id", referencedColumnName = "id")])
    var facilities: MutableList<RoomFacility>
)
