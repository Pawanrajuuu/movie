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
        Magazine existingMagazine = magazineRepository.findById(magazineId).orElse(null);
        if (existingMagazine != null) {
            existingMagazine.setMagazineName(magazine.getMagazineName());
            existingMagazine.setPublicationDate(magazine.getPublicationDate());
            existingMagazine.setWriters(magazine.getWriters());
            return magazineRepository.save(existingMagazine);
        }
        return null;
    }

    public void deleteMagazine(int magazineId) {
        magazineRepository.deleteById(magazineId);
    }

    public List<Writer> getWritersByMagazine(int magazineId) {
        Magazine magazine = magazineRepository.findById(magazineId).orElse(null);
        return magazine != null ? magazine.getWriters() : null;
    }

    public List<Writer> getAllWritersForMagazines() {
    
        return null;
    }

    public Writer addWriterToMagazine(int magazineId, int writerId) {
        Magazine magazine = magazineRepository.findById(magazineId).orElse(null);
        Writer writer = writerRepository.findById(writerId).orElse(null);

        if (magazine != null && writer != null) {
            List<Writer> writers = magazine.getWriters();
            writers.add(writer);
            magazine.setWriters(writers);
            magazineRepository.save(magazine);

            return writer;
        }
        return null;
    }

    public List<Magazine> getMagazinesByWriter(int writerId) {
        Writer writer = writerRepository.findById(writerId).orElse(null);
        return writer != null ? writer.getMagazines() : null;
    }

    public Writer updateWriterInMagazine(int writerId, Writer writer) {
        Writer existingWriter = writerRepository.findById(writerId).orElse(null);
        if (existingWriter != null) {
            existingWriter.setWriterName(writer.getWriterName());
            existingWriter.setBio(writer.getBio());
            existingWriter.setMagazines(writer.getMagazines());
            return writerRepository.save(existingWriter);
        }
        return null;
    }

    public void removeWriterFromMagazine(int writerId) {
        
    }

    public List<Magazine> getMagazinesByWriterId(int writerId) {
        Writer writer = writerRepository.findById(writerId).orElse(null);
        return writer != null ? writer.getMagazines() : null;
    }
}
