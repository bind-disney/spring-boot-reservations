package com.binddisney.spring.boot.reservations.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "guests")
data class Guest(
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "guest_sequence", sequenceName = "guests_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_sequence")
    var id: Int? = null,

    @Column(name = "first_name", nullable = false, length = 64)
    var firstName: String? = null,

    @Column(name = "last_name", nullable = false, length = 64)
    var lastName: String? = null,

    @Column(name = "email", nullable = false, length = 100)
    var email: String? = null,

    @Column(name = "phone_number", nullable = false, length = 24)
    var phoneNumber: String? = null,

    @Column(name = "address", nullable = false, length = 100)
    var address: String? = null,

    @Column(name = "country", nullable = false, length = 32)
    var country: String? = null,

    @Column(name = "state", nullable = false, length = 12)
    var state: String? = null
)
