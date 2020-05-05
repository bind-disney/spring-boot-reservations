package com.binddisney.spring.boot.reservations.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "rooms")
data class Room(
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "room_sequence", sequenceName = "rooms_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_sequence")
    var id: Int? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "room_number", nullable = false)
    var roomNumber: String? = null,

    @Column(name = "bed_info", nullable = false)
    var bedInfo: String? = null
)
