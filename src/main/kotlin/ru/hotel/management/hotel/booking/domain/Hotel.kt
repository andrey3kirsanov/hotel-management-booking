package ru.hotel.management.hotel.booking.domain

import ru.hotel.management.hotel.booking.listener.HotelUpdateListener
import java.time.Instant
import javax.persistence.*

@Entity
@EntityListeners(value = arrayOf(HotelUpdateListener::class))
@Table(name = "hotels")
class Hotel(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelsSeq")
    @SequenceGenerator(name = "hotelsSeq", sequenceName = "hotels_sequence", allocationSize = 1)
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "created_date_time")
    var createdDateTime: Instant,

    @Column(name = "updated_date_time")
    var updatedDateTime: Instant,

    @OneToMany(mappedBy = "hotel")
    var rooms: MutableList<Room>,

    @ManyToMany
    @JoinTable(name = "hotels_facilities",
            joinColumns = [JoinColumn(name = "hotel_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "facility_id", referencedColumnName = "id")])
    var facilities: MutableList<HotelFacility>
)
