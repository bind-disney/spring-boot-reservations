package com.binddisney.spring.boot.reservations.repository

import com.binddisney.spring.boot.reservations.entity.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : JpaRepository<Room, Int>
