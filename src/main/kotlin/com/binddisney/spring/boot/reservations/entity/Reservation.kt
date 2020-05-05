package com.binddisney.spring.boot.reservations.entity

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "reservations")
data class Reservation(
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "reservation_sequence", sequenceName = "reservations_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_sequence")
    var id: Int? = null,

    @Column(name = "reservation_date", nullable = false)
    var date: Date? = null,

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    var room: Room? = null,

    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    var guest: Guest? = null
)
