package com.binddisney.spring.boot.reservations.repository

import com.binddisney.spring.boot.reservations.entity.Guest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestRepository : JpaRepository<Guest, Int>
