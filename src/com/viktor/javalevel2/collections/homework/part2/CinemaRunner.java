package com.viktor.javalevel2.collections.homework.part2;

import java.time.Month;
import java.util.List;
import java.util.Set;

public class CinemaRunner {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(
                new Film(1, 2009, Month.JANUARY, FilmGenre.ACTION, 9.5),
                new Film(2, 2009, Month.MAY, FilmGenre.COMEDY, 8.1),
                new Film(3, 2012, Month.DECEMBER, FilmGenre.ACTION, 1.1),
                new Film(4, 2011, Month.NOVEMBER, FilmGenre.ACTION, 8.0),
                new Film(5, 2008, Month.FEBRUARY, FilmGenre.HISTORICAL, 4.5),
                new Film(6, 2009, Month.JANUARY, FilmGenre.DETECTIVE, 7.1),
                new Film(7, 2013, Month.DECEMBER, FilmGenre.ACTION, 1.2),
                new Film(8, 2008, Month.MARCH, FilmGenre.ACTION, 5.5));

        System.out.println(cinema);
        System.out.println();

        Set<Film> filmsByYearOfPublishing = cinema.getFilmsByYearOfPublishing(2009);
        System.out.println(filmsByYearOfPublishing);
        System.out.println();
        Set<Film> filmsByYearAndMonth = cinema.getFilmsByYearAndMonthOfPublishing(2009, Month.JANUARY);
        System.out.println(filmsByYearAndMonth);
        System.out.println();
        List<Film> filmsAction = cinema.getFilmsByGenre(FilmGenre.ACTION);
        System.out.println(filmsAction);
        System.out.println();
        List<Film> topFilms = cinema.getTopTenFilms();
        System.out.println(topFilms);
    }
}


