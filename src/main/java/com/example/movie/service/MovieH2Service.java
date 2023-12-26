/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;
import com.example.movie.repository.MovieRepository;
import com.example.movie.model.Movie;
import com.example.movie.model.MovieRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import javax.validation.OverridesAttribute;
@Service
public class MovieH2Service implements MovieRepository{
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<Song> getAllSongs(){
        return (ArrayList<Song>) db.query("select * from playlist", new SongRowMapper()); 
    }
    public Song getSongById(int songId){
        try{
            return db.queryForObject("select * from playlist where songId=?", new SongRowMapper(),songId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
    public Song addSong(Song song){
        db.update("insert into playlist(songName, lyricist, singer, musicDirector) values(?,?,?,?)",song.getSongName(),song.getLyricist(),song.getSinger(), song.getMusicDirector());
        return db.queryForObject("select * from playlist where songName =? and lyricist =?",new SongRowMapper(),song.getSongName(), song.getLyricist());

    }
    
    public void deleteSong(int songId){
        db.update("delete from playlist where songId = ?", songId);
    }
    @Override
    public Song updateSong(int songId, Song song){
        if(song.getSongName() != null){
            db.update("update playlist set songName =? where songId=?",song.getSongName(), songId);
        }
        if(song.getLyricist() != null){
            db.update("update playlist set lyricist =? where songId=?",song.getLyricist(), songId);
        }
        if(song.getSinger() != null){
            db.update("update playlist set singer =? where songId=?",song.getSinger(), songId);
        }
        if(song.getMusicDirector() != null){
            db.update("update playlist set musicDirector =? where songId=?",song.getMusicDirector(), songId);
        }
        return getSongById(songId);
    }

}