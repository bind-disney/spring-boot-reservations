package com.binddisney.spring.boot.reservations.util

import com.binddisney.spring.boot.reservations.service.impl.ReservationServiceImpl
import org.springframework.stereotype.Component
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

@Component
class DateParser {
    fun parseDate(dateString: String?): Date {
        return if (dateString != null) {
            try {
                DATE_FORMAT.parse(dateString)
            } catch (exception: ParseException) {
                Date()
            }
        } else {
            Date()
        }
    }

    companion object {
        private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd")
    }
}
