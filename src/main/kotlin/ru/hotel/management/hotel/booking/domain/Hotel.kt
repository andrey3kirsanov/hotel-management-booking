package ru.hotel.management.hotel.booking.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "hotels")
class Hotel(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelsSeq")
    @SequenceGenerator(name = "hotelsSeq", sequenceName = "hotels_sequence", allocationSize = 1)
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "created_data_time")
    val createdDateTime: Instant,

    @Column(name = "updated_data_time")
    val updatedDateTime: Instant,

    @OneToMany(mappedBy = "hotel")
    val rooms: MutableList<Room>,

    @ManyToMany
    @JoinTable(name = "hotels_facilities",
            joinColumns = [JoinColumn(name = "hotel_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "facility_id", referencedColumnName = "id")])
    val facilities: MutableList<HotelFacility>
)
