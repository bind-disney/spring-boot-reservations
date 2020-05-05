package com.binddisney.spring.boot.reservations.repository

import com.binddisney.spring.boot.reservations.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<Reservation, Int>
