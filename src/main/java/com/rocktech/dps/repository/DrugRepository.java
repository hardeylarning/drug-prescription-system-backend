package com.rocktech.dps.repository;

import com.rocktech.dps.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
}
