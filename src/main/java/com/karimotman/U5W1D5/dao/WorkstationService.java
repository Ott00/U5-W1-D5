package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.Workstation;
import com.karimotman.U5W1D5.enums.WorkstationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkstationService {
    @Autowired
    private WorkstationDAO workstationDAO;

    public void save(Workstation workstation) {
        workstationDAO.save(workstation);
        log.info("Postazione salvata correttamente!");
    }

    public List<Workstation> findByTypeAndCity(WorkstationType workstationType, String city) {
        return workstationDAO.findByTypeAndCity(workstationType, city);
    }

    ;
}
