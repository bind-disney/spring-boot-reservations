package com.binddisney.spring.boot.reservations.controller

import com.binddisney.spring.boot.reservations.service.ReservationService
import com.binddisney.spring.boot.reservations.util.DateParser
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(path = ["/reservations"], produces = [MediaType.TEXT_HTML_VALUE])
class ReservationController(private val reservationService: ReservationService, private val dateParser: DateParser) {

    @GetMapping
    fun index(@RequestParam(name = "date", required = false) dateString: String? = null, model: Model): String {
        val date = dateParser.parseDate(dateString)

        model["roomReservations"] = reservationService.getRoomReservationsForDate(date)

        return "reservations/index"
    }
}
