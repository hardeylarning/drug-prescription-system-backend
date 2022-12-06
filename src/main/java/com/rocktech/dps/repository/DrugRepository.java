package com.rocktech.dps.repository;

import com.rocktech.dps.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
    List<Drug> findAllByTitleLike(String title);
}
