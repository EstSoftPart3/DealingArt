package com.da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.da.model.SampleBoard;

@Repository
public interface SampleBoardRepository extends JpaRepository<SampleBoard, Integer>{

}
