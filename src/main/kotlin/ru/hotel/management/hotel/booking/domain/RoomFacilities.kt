package ru.hotel.management.hotel.booking.domain

import lombok.Getter
import lombok.Setter
import ru.hotel.management.hotel.booking.domain.Room
import java.time.Instant
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "room_facility")
class RoomFacilities(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomFacilitySeq")
    @SequenceGenerator(name = "roomFacilitySeq", sequenceName = "room_facility_sequence", allocationSize = 1)
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "created_data_time")
    var createdDateTime: Instant,

    @Column(name = "updated_data_time")
    var updatedDateTime: Instant,

    @ManyToMany(mappedBy = "facilities")
    var rooms: List<Room>
)
