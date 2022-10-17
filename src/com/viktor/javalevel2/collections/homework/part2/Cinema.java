package com.viktor.javalevel2.collections.homework.part2;

import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {
    private final Map<Integer, Set<Film>> films = new TreeMap<>();

    public Cinema() {
    }

    public Cinema(Film... movies) {
        for (Film movie : movies) {
            addFilm(movie);
        }
    }

    public void addFilm(Film film) {
        int yearOfPublishing = film.yearOfPublishing();
        Set<Film> setFilms = films.getOrDefault(yearOfPublishing, new LinkedHashSet<>());
        setFilms.add(film);
        films.put(yearOfPublishing, setFilms);
    }

    public Set<Film> getFilmsByYearOfPublishing(int yearOfPublishing) {
        return films.getOrDefault(yearOfPublishing, new LinkedHashSet<>());
    }

    public Set<Film> getFilmsByYearAndMonthOfPublishing(int year, Month month) {
        Set<Film> films = new LinkedHashSet<>();
        for (Film film : getFilmsByYearOfPublishing(year)) {
            if (film.monthOfPublishing().equals(month)) {
                films.add(film);
            }
        }
        return films;
    }

    public List<Film> getFilmsByGenre(FilmGenre genre) {
        List<Film> result = new ArrayList<>();
        for (Set<Film> setFilms : films.values()) {
            for (Film film : setFilms) {
                if (film.genre().equals(genre)) {
                    result.add(film);
                }
            }
        }
        return result;
    }

    public List<Film> getTopTenFilms() {
        List<Film> resultFilms = new ArrayList<>();
        for (Set<Film> films : films.values()) {
            resultFilms.addAll(films);
        }
        resultFilms.sort(Collections.reverseOrder(Comparator.comparingDouble(Film::rating)));
        int lastIndex = resultFilms.size() < 10 ? resultFilms.size() - 1 : 10;
        resultFilms.subList(0, lastIndex);
        return resultFilms;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "films=" + films +
                '}';
    }
}

record Film(int id, int yearOfPublishing, Month monthOfPublishing, FilmGenre genre, double rating) {
}