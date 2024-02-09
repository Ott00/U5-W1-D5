package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;

    public void save(Reservation reservation) {
        int maxSlotOfWorkstation = reservation.getWorkstation().getMaxUser();
        int actualFullSlotOfWorkstation = reservationDAO.fullSlot(reservation.getWorkstation(), reservation.getDate());
        List<Reservation> reservations = reservationDAO.filterBySameUserAndDate(reservation.getUser(), reservation.getDate());

        if (reservations.isEmpty() && maxSlotOfWorkstation < actualFullSlotOfWorkstation) {
            reservationDAO.save(reservation);
            log.info("Prenotazione salvata correttamente!");
        } else {
            throw new RuntimeException("L'utente ha già una prenotazione per questa data!");
        }
    }
}
