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
@RequestMapping("/writers")
public class WriterController {

    private final WriterJpaService writerJpaService;

    @Autowired
    public WriterController(WriterJpaService writerJpaService) {
        this.writerJpaService = writerJpaService;
    }

    // API 1: GET /writers
    @GetMapping
    public List<Writer> getAllWriters() {
        return writerJpaService.getAllWriters();
    }

    // API 2: POST /writers
    @PostMapping
    public Writer createWriter(@RequestBody Writer writer) {
        return writerJpaService.createWriter(writer);
    }

    // API 3: GET /writers/{writerId}
    @GetMapping("/{writerId}")
    public Writer getWriterById(@PathVariable int writerId) {
        return writerJpaService.getWriterById(writerId);
    }

    // API 4: PUT /writers/{writerId}
    @PutMapping("/{writerId}")
    public Writer updateWriter(@PathVariable int writerId, @RequestBody Writer writer) {
        return writerJpaService.updateWriter(writerId, writer);
    }

    // API 5: DELETE /writers/{writerId}
    @DeleteMapping("/{writerId}")
    public void deleteWriter(@PathVariable int writerId) {
        writerJpaService.deleteWriter(writerId);
    }

    // API 6: GET /writers/{writerId}/magazines
    @GetMapping("/{writerId}/magazines")
    public List<Magazine> getMagazinesByWriter(@PathVariable int writerId) {
        return writerJpaService.getMagazinesByWriterId(writerId);
    }

    // API 7: GET /magazines/writers
    @GetMapping("/magazines/writers")
    public List<Writer> getAllWritersForMagazines() {
        return writerJpaService.getAllWritersForMagazines();
    }

    // API 8: POST /magazines/writers
    @PostMapping("/magazines/writers")
    public Magazine addMagazineToWriter(@RequestParam int writerId, @RequestParam int magazineId) {
        return writerJpaService.addMagazineToWriter(writerId, magazineId);
    }

    // API 9: GET /magazines/writers/{writerId}
    @GetMapping("/magazines/writers/{writerId}")
    public List<Magazine> getMagazinesByWriterId(@PathVariable int writerId) {
        return writerJpaService.getMagazinesByWriterId(writerId);
    }

    // API 10: PUT /magazines/writers/{writerId}
    @PutMapping("/magazines/writers/{writerId}")
    public Writer updateMagazineInWriter(@PathVariable int writerId, @RequestBody Writer writer) {
        return writerJpaService.updateMagazineInWriter(writerId, writer);
    }

    // API 11: DELETE /magazines/writers/{writerId}
    @DeleteMapping("/magazines/writers/{writerId}")
    public void removeMagazineFromWriter(@PathVariable int writerId) {
        writerJpaService.removeMagazineFromWriter(writerId);
    }

    // API 12: GET /writers/{writerId}/magazines
    @GetMapping("/{writerId}/magazines")
    public List<Magazine> getMagazinesByWriterId(@PathVariable int writerId) {
        return writerJpaService.getMagazinesByWriterId(writerId);
    }
}
