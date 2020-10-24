package ru.hotel.management.hotel.booking.domain

import lombok.Getter
import lombok.Setter
import java.time.Instant
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "hotel_facility")
class HotelFacilities(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelFacilitySeq")
    @SequenceGenerator(name = "hotelFacilitySeq", sequenceName = "hotel_facility_sequence", allocationSize = 1)
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "created_data_time")
    var createdDateTime: Instant,

    @Column(name = "updated_data_time")
    var updatedDateTime: Instant
)
