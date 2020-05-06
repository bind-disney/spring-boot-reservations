package com.binddisney.spring.boot.reservations.controller

import com.binddisney.spring.boot.reservations.entity.Guest
import com.binddisney.spring.boot.reservations.entity.Reservation
import com.binddisney.spring.boot.reservations.entity.Room
import com.binddisney.spring.boot.reservations.repository.GuestRepository
import com.binddisney.spring.boot.reservations.repository.ReservationRepository
import com.binddisney.spring.boot.reservations.repository.RoomRepository
import com.binddisney.spring.boot.reservations.util.DateParser
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@ActiveProfiles(profiles = ["test"])
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
class ReservationControllerIT {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var dateParser: DateParser

    @Autowired
    private lateinit var roomRepository: RoomRepository

    @Autowired
    private lateinit var guestRepository: GuestRepository

    @Autowired
    private lateinit var reservationRepository: ReservationRepository

    @BeforeEach
    fun setUp() {
        roomRepository.deleteAll()
        guestRepository.deleteAll()
        reservationRepository.deleteAll()

        val room = roomRepository.save(buildRoom())
        val guest = guestRepository.save(buildGuest())
        val reservation = Reservation(date = dateParser.parseDate(DATE), room = room, guest = guest)

        reservationRepository.save(reservation)
    }

    @Test
    @Sql(scripts = ["classpath:/sql/test-schema.sql"])
    fun indexTest() {
        mockMvc.perform(get("/reservations?date=$DATE"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Smith, John")))
    }

    private fun buildRoom() = Room(
        name = "Test Room",
        roomNumber = "J1",
        bedInfo = "2D"
    )

    private fun buildGuest() = Guest(
        firstName = "John",
        lastName = "Smith",
        email = "john@smith.com",
        phoneNumber = "555-777-999",
        country = "USA",
        state = "NYC",
        address = "Address"
    )

    companion object {
        const val DATE = "2020-01-01"
    }
}
