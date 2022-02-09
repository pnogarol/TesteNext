package com.test.train.repository;

import com.test.train.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StationRepository extends JpaRepository<Station, Integer> {
}
