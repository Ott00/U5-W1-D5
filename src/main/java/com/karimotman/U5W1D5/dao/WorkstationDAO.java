package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation, Long> {

}
