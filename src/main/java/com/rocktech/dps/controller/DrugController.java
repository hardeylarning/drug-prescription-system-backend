package com.rocktech.dps.controller;

import com.rocktech.dps.model.Drug;
import com.rocktech.dps.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("search/{title}")
    public List<Drug> searchDrugs(@PathVariable String title) {
        return drugService.searchDrugs(title);
    }

    @GetMapping("{id}")
    public Drug getDrug(@PathVariable int id) {
        return drugService.getDrug(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Drug addDrug(@RequestBody Drug drug) {
        return drugService.addDrug(drug);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public int updateDrug(@PathVariable int id, @RequestBody Drug drug) {
        return drugService.updateDrug(id, drug);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteDrug(@PathVariable int id) {
        drugService.deleteDrug(id);
    }
}
