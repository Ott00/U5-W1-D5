package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.Workstation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkstationService {
    @Autowired
    private WorkstationDAO workstationDAO;

    public void save(Workstation workstation) {
        workstationDAO.save(workstation);
        log.info("Postazione salvata correttamente!");
    }
}
