package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.Workstation;
import com.karimotman.U5W1D5.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation, Long> {
    @Query("SELECT w FROM Workstation w JOIN w.building b WHERE w.workstationType = :workstationType AND LOWER(b.city) = LOWER(:city)")
    List<Workstation> findByTypeAndCity(WorkstationType workstationType, String city);
}
