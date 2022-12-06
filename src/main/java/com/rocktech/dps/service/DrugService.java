package com.rocktech.dps.service;

import com.rocktech.dps.model.Drug;
import com.rocktech.dps.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService {
    @Autowired
    DrugRepository drugRepository;

    public List<Drug> getDrugs() {
        return drugRepository.findAll();
    }

    public List<Drug> searchDrugs(String title) {
        return drugRepository.findAllByTitleLike("%"+title+"%");
    }

    public Drug getDrug(int id) {
        return drugRepository.findById(id).get();
    }

    public Drug addDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    public int updateDrug(int id, Drug drug) {
        Optional<Drug> drugRepositoryById = drugRepository.findById(id);
        if (drugRepositoryById.isPresent()){
//            Drug drug1 = drugRepositoryById.get();
//            drug1.setAge(drug.getAge());
//            drug1.setImage(drug.getImage());
//
//            drug1.setDescription(drug.getDescription());
//            drug1.setDosage(drug.getDosage());
//            drug1.setExDate(drug.getExDate());
//            drug1.setMfDate(drug.getMfDate());
//            drug1.setSideEffect(drug1.getSideEffect());
            drug.setId(id);
            drugRepository.save(drug);
            return id;
        }
        return 0;
    }

    public void deleteDrug(int id) {
        drugRepository.deleteById(id);
    }
}
