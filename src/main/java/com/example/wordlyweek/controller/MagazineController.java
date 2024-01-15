/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.wordlyweek.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/magazines")
public class MagazineController {

    private final MagazineJpaService magazineJpaService;

    @Autowired
    public MagazineController(MagazineJpaService magazineJpaService) {
        this.magazineJpaService = magazineJpaService;
    }

    // API 1: GET /magazines
    @GetMapping
    public List<Magazine> getAllMagazines() {
        return magazineJpaService.getAllMagazines();
    }

    // API 2: POST /magazines
    @PostMapping
    public Magazine createMagazine(@RequestBody Magazine magazine) {
        return magazineJpaService.createMagazine(magazine);
    }

    // API 3: GET /magazines/{magazineId}
    @GetMapping("/{magazineId}")
    public Magazine getMagazineById(@PathVariable int magazineId) {
        return magazineJpaService.getMagazineById(magazineId);
    }

    // API 4: PUT /magazines/{magazineId}
    @PutMapping("/{magazineId}")
    public Magazine updateMagazine(@PathVariable int magazineId, @RequestBody Magazine magazine) {
        return magazineJpaService.updateMagazine(magazineId, magazine);
    }

    // API 5: DELETE /magazines/{magazineId}
    @DeleteMapping("/{magazineId}")
    public void deleteMagazine(@PathVariable int magazineId) {
        magazineJpaService.deleteMagazine(magazineId);
    }

    // API 6: GET /magazines/{magazineId}/writers
    @GetMapping("/{magazineId}/writers")
    public List<Writer> getWritersByMagazine(@PathVariable int magazineId) {
        return magazineJpaService.getWritersByMagazine(magazineId);
    }

    // API 7: GET /magazines/writers
    @GetMapping("/writers")
    public List<Writer> getAllWritersForMagazines() {
        return magazineJpaService.getAllWritersForMagazines();
    }

    // API 8: POST /magazines/writers
    @PostMapping("/writers")
    public Writer addWriterToMagazine(@RequestParam int magazineId, @RequestParam int writerId) {
        return magazineJpaService.addWriterToMagazine(magazineId, writerId);
    }

    // API 9: GET /magazines/writers/{writerId}
    @GetMapping("/writers/{writerId}")
    public List<Magazine> getMagazinesByWriter(@PathVariable int writerId) {
        return magazineJpaService.getMagazinesByWriter(writerId);
    }

    // API 10: PUT /magazines/writers/{writerId}
    @PutMapping("/writers/{writerId}")
    public Writer updateWriterInMagazine(@PathVariable int writerId, @RequestBody Writer writer) {
        return magazineJpaService.updateWriterInMagazine(writerId, writer);
    }

    // API 11: DELETE /magazines/writers/{writerId}
    @DeleteMapping("/writers/{writerId}")
    public void removeWriterFromMagazine(@PathVariable int writerId) {
        magazineJpaService.removeWriterFromMagazine(writerId);
    }

    // API 12: GET /writers/{writerId}/magazines
    @GetMapping("/writers/{writerId}/magazines")
    public List<Magazine> getMagazinesByWriterId(@PathVariable int writerId) {
        return magazineJpaService.getMagazinesByWriterId(writerId);
    }
}
