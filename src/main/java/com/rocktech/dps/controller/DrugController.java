package com.rocktech.dps.controller;

import com.rocktech.dps.model.Drug;
import com.rocktech.dps.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drugs")
public class DrugController {

    @Autowired
    DrugService drugService;

    @GetMapping
    public List<Drug> allDrugs() {
        return drugService.getDrugs();
    }

    @GetMapping("{id}")
    public Drug getDrug(@PathVariable int id) {
        return drugService.getDrug(id);
    }

    @PostMapping
    public Drug addDrug(@RequestBody Drug drug) {
        return drugService.addDrug(drug);
    }

    @PutMapping("{id}")
    public int updateDrug(@PathVariable int id, @RequestBody Drug drug) {
        return drugService.updateDrug(id, drug);
    }

    @DeleteMapping("{id}")
    public void deleteDrug(@PathVariable int id) {
        drugService.deleteDrug(id);
    }
}
