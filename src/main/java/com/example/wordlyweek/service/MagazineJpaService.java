/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.*;
 *
 */

// Write your code here
package com.example.wordlyweek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class MagazineJpaService {

    private final MagazineRepository magazineRepository;
    private final WriterRepository writerRepository;

    @Autowired
    public MagazineJpaService(MagazineRepository magazineRepository, WriterRepository writerRepository) {
        this.magazineRepository = magazineRepository;
        this.writerRepository = writerRepository;
    }

    public List<Magazine> getAllMagazines() {
        return magazineRepository.findAll();
    }

    public Magazine createMagazine(Magazine magazine) {

        return magazineRepository.save(magazine);
    }

    public Magazine getMagazineById(int magazineId) {
        return magazineRepository.findById(magazineId).orElse(null);
    }

    public Magazine updateMagazine(int magazineId, Magazine magazine) {

        return magazineRepository.save(magazine);
    }

    public void deleteMagazine(int magazineId) {
        magazineRepository.deleteById(magazineId);
    }

    public List<Writer> getWritersByMagazine(int magazineId) {
        Magazine magazine = magazineRepository.findById(magazineId).orElse(null);
        if (magazine != null) {
            return magazine.getWriters();
        }
        return null;
    }

    public List<Writer> getAllWritersForMagazines() {

        return null;
    }

    public Writer addWriterToMagazine(int magazineId, int writerId) {

        return null;
    }

    public List<Magazine> getMagazinesByWriter(int writerId) {

        return null;
    }

}
