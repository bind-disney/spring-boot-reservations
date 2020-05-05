package com.binddisney.spring.boot.reservations.service

import com.binddisney.spring.boot.reservations.domain.RoomReservation
import java.util.Date

interface ReservationService {
    fun getRoomReservationsForDate(date: Date): List<RoomReservation>
}
