package com.karimotman.U5W1D5.runner;

import com.github.javafaker.Faker;
import com.karimotman.U5W1D5.dao.BuildingService;
import com.karimotman.U5W1D5.dao.ReservationService;
import com.karimotman.U5W1D5.dao.UserService;
import com.karimotman.U5W1D5.dao.WorkstationService;
import com.karimotman.U5W1D5.entities.Building;
import com.karimotman.U5W1D5.entities.Reservation;
import com.karimotman.U5W1D5.entities.User;
import com.karimotman.U5W1D5.entities.Workstation;
import com.karimotman.U5W1D5.enums.WorkstationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
public class RunnerPrenotazioni implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    WorkstationService workstationService;
    @Autowired
    BuildingService buildingService;
    @Autowired
    ReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(Locale.ITALY);

        for (int i = 0; i < 2; i++) {
            User user = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
            User user2 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
            User user3 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
            Building building = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().city());
            Workstation workstation = new Workstation(faker.lorem().sentence(10), WorkstationType.SALA_RIUNIONI, 1, building);
            Workstation workstation2 = new Workstation(faker.lorem().sentence(10), WorkstationType.PRIVATO, 2, building);
            Workstation workstation3 = new Workstation(faker.lorem().sentence(10), WorkstationType.OPENSPACE, 5, building);
            Reservation reservation = new Reservation(LocalDate.now(), user, workstation);

            //TEST per vedere se l'app permette più prenotazioni lo stesso giorno dallo stesso utente ***
            //Reservation reservationTest = new Reservation(LocalDate.now(), user, workstation2);

            //TEST per vedere se l'app permette più prenotazioni nonostante raggiunta la capienza ***
            //Reservation reservationTest2 = new Reservation(LocalDate.now(), user, workstation);

            Reservation reservation2 = new Reservation(LocalDate.now(), user2, workstation2);
            Reservation reservation3 = new Reservation(LocalDate.now(), user3, workstation3);

            userService.save(user);
            userService.save(user2);
            userService.save(user3);
            buildingService.save(building);
            workstationService.save(workstation);
            workstationService.save(workstation2);
            workstationService.save(workstation3);
            reservationService.save(reservation);
            reservationService.save(reservation2);
            reservationService.save(reservation3);

            //reservationService.save(reservationTest); ***
            //reservationService.save(reservationTest2); ***
        }

        System.out.println("TEST RICERCA POSTAZIONE");
        workstationService
                .findByTypeAndCity(WorkstationType.SALA_RIUNIONI, "Giordano Sardo")
                .forEach(System.out::println);
    }
}
