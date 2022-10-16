package com.viktor.javalevel2.collections.homework.part2;

import java.time.Month;
import java.util.*;

public class Cinema {
    private final Map<Integer, Set<Film>> films = new TreeMap<>();

    public Cinema() {
    }

    public void addFilm(Film film) {
        int yearOfPublishing = film.getYearOfPublishing();
        if (films.containsKey(yearOfPublishing)) {
            Set<Film> setFilms = films.get(yearOfPublishing);
            setFilms.add(film);
        } else {
            Set<Film> setFilms = new LinkedHashSet<>();
            setFilms.add(film);
            films.put(yearOfPublishing, setFilms);
        }
    }

    public List<Film> getFilmsByYearOfPublishing(int yearOfPublishing) {
        if (films.containsKey(yearOfPublishing)) {
            return new ArrayList<>(films.get(yearOfPublishing));
        } else {
            System.out.println("no movies with this year of release");
            return null;
        }
    }

    public List<Film> getFilmsByYearAndMonthOfPublishing(int YearOfPublishing, Month MonthOfPublishing) {
        List<Film> films = getFilmsByYearOfPublishing(YearOfPublishing);
        if (films == null) {
            return null;
        } else {
            for (Film film : films) {
                if (!film.getMonthOfPublishing().equals(MonthOfPublishing)) {
                    films.remove(film);
                }
            }
        }
        if (films.isEmpty()) {
            System.out.println("no movies with this month of release");
            return null;
        }
        return films;
    }

    public List<Film> getFilmsByGenre(FilmGenre genre) {
        List<Film> result = new ArrayList<>();
        for (Set<Film> setFilms : films.values()) {
            for (Film film : setFilms) {
                if (film.getGenre().equals(genre)) {
                    result.add(film);
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("no movies with this genre");
            return null;
        }
        return result;
    }

    public List<Film> getTopTenFilms() {
        List<Film> resultFilms = new ArrayList<>();
        Set<Film> setFilms = new TreeSet<>(Collections.reverseOrder(Comparator.comparingDouble(Film::getRating)));
        for (Set<Film> films : films.values()) {
            setFilms.addAll(films);
        }
        for (Film film : setFilms) {
            resultFilms.add(film);
            if (resultFilms.size() == 10) {
                break;
            }
        }
        return resultFilms;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "films=" + films +
                '}';
    }
}
