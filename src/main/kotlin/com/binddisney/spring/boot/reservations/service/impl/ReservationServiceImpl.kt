package com.binddisney.spring.boot.reservations.service.impl

import com.binddisney.spring.boot.reservations.domain.RoomReservation
import com.binddisney.spring.boot.reservations.repository.GuestRepository
import com.binddisney.spring.boot.reservations.repository.ReservationRepository
import com.binddisney.spring.boot.reservations.repository.RoomRepository
import com.binddisney.spring.boot.reservations.service.ReservationService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date

@Service
class ReservationServiceImpl(
    private val roomRepository: RoomRepository,
    private val reservationRepository: ReservationRepository,
    private val guestRepository: GuestRepository
) : ReservationService {
    override fun getRoomReservationsForDate(date: Date): List<RoomReservation> {
        val reservations = buildRoomReservations()

        populateRoomReservations(reservations, date)

        return reservations.values.toList()
    }

    private fun buildRoomReservations(): MutableMap<Int, RoomReservation> {
        val reservations = mutableMapOf<Int, RoomReservation>()

        roomRepository.findAll().forEach { room ->
            reservations[room.id!!] = RoomReservation(
                roomId = room.id!!,
                roomName = room.name!!,
                roomNumber = room.roomNumber!!
            )
        }

        return reservations
    }

    private fun populateRoomReservations(reservations: MutableMap<Int, RoomReservation>, date: Date) {
        reservationRepository.findByDate(date).forEach { reservation ->
            reservation.guest?.let {
                guestRepository.findByIdOrNull(it.id)?.let { guest ->
                    reservation.room?.let { room ->
                        reservations[room.id]?.let { roomReservation ->
                            roomReservation.date = date
                            roomReservation.guestId = guest.id
                            roomReservation.firstName = guest.firstName
                            roomReservation.lastName = guest.lastName
                        }
                    }
                }
            }
        }
    }
}
