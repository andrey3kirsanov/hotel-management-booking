package ru.hotel.management.hotel.booking.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Getter
import lombok.Setter
import ru.hotel.management.hotel.booking.enums.RoomStatus
import ru.hotel.management.hotel.booking.listener.RoomUpdateListener
import java.time.Instant
import javax.persistence.*

@Getter
@Setter
@Entity
@EntityListeners(value = arrayOf(RoomUpdateListener::class))
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
    @Enumerated(EnumType.STRING)
    var status: RoomStatus,

    @Column(name = "price")
    var price: Int = 0,

    @Column(name = "available_number")
    var availableNumber: Int = 0,

    @Column(name = "booked_number")
    var bookedNumber: Int = 0,

    @Column(name = "created_date_time")
    var createdDateTime: Instant,

    @Column(name = "updated_date_time")
    var updatedDateTime: Instant,

    @Column(name = "booked_date_time")
    var bookedDateTime: Instant?,

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    var hotel: Hotel?,

    @ManyToMany
    @JoinTable(name = "rooms_facilities",
            joinColumns = [JoinColumn(name = "room_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "facility_id", referencedColumnName = "id")])
    var facilities: MutableList<RoomFacility>,

    @ManyToMany(mappedBy = "rooms")
    var customers: MutableList<Customer>
)
