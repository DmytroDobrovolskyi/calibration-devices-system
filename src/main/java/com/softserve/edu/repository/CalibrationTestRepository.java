package com.softserve.edu.repository;

import com.softserve.edu.entity.CalibrationTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalibrationTestRepository extends CrudRepository<CalibrationTest, Long> {}
