package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.Reservation;
import com.karimotman.U5W1D5.entities.User;
import com.karimotman.U5W1D5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.user = :user AND r.date = :date")
    List<Reservation> filterBySameUserAndDate(User user, LocalDate date);

    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.workstation = :workstation AND r.date = :date")
    int fullSlot(Workstation workstation, LocalDate date);
}
