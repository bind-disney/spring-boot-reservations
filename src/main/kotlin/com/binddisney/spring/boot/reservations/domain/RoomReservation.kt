package com.binddisney.spring.boot.reservations.domain

import java.util.Date

data class RoomReservation(
    val roomId: Int,
    var guestId: Int? = null,
    val roomName: String,
    val roomNumber: String,
    var firstName: String? = null,
    var lastName: String? = null,
    var date: Date? = null
)
