package com.driver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class MovieRepository {
    private Map<String,Movie> movieMap=new HashMap<>();
    private Map<String,Director> directorMap=new HashMap<>();
    private Map<String, List<String>> directorMovieMap=new HashMap<>();
    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        List<String> mov=new ArrayList<>();
        if(directorMovieMap.containsKey(directorName))
            mov=directorMovieMap.get(directorName);
        mov.add(movieName);
        directorMovieMap.put(directorName,mov);

    }

    public Movie findMovie(String movieName) {
        if(movieMap.containsKey(movieName))
            return movieMap.get(movieName);
        return null;
    }

    public Director findDirector(String directorName) {
        if(directorMap.containsKey(directorName))
            return directorMap.get(directorName);
        return null;
    }

    public List<String> getAllMovieByDirector(String director) {
        return new ArrayList(directorMovieMap.get(director));
    }

    public List<String> getAllMovie() {
        return new ArrayList(movieMap.keySet());
    }

    public void removeDirector(String directorName) {
        directorMovieMap.remove(directorName);
        directorMap.remove(directorName);
    }

    public void removeMovie(String movieToDelete) {
        movieMap.remove(movieToDelete);
    }

    public List<String> getAllDirector() {
        return new ArrayList(directorMap.keySet());
    }
}
