package com.binddisney.spring.boot.reservations.controller.api

import com.binddisney.spring.boot.reservations.domain.RoomReservation
import com.binddisney.spring.boot.reservations.service.ReservationService
import com.binddisney.spring.boot.reservations.util.DateParser
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("reservationApiController")
@RequestMapping(path = ["/api/v1/reservations"], produces = [MediaType.APPLICATION_JSON_VALUE])
class ReservationController(private val reservationService: ReservationService, private val dateParser: DateParser) {

    @GetMapping(path = ["", "/{date}"])
    fun index(@PathVariable(name = "date", required = false) dateString: String? = null): List<RoomReservation> {
        val date = dateParser.parseDate(dateString)
        return reservationService.getRoomReservationsForDate(date)
    }
}
