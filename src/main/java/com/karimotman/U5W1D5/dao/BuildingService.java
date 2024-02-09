package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.Building;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    private BuildingDAO buildingDao;

    public void save(Building building) {
        if (buildingDao.existsByName(building.getName())) {
            throw new RuntimeException("Nome già assegnato!");
        } else {
            buildingDao.save(building);
            log.info("Edificio salvato correttamente!");
        }
    }
}
