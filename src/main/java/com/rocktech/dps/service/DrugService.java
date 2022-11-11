package com.rocktech.dps.service;

import com.rocktech.dps.model.Drug;
import com.rocktech.dps.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {
    @Autowired
    DrugRepository drugRepository;

    public List<Drug> getDrugs() {
        return drugRepository.findAll();
    }

    public Drug getDrug(int id) {
        return drugRepository.findById(id).get();
    }

    public Drug addDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    public int updateDrug(int id, Drug drug) {
//        drugRepository.findById(id);
        drugRepository.save(drug);
        return id;
    }

    public void deleteDrug(int id) {
        drugRepository.deleteById(id);
    }
}
