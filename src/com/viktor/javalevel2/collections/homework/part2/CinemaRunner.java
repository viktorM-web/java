package com.viktor.javalevel2.collections.homework.part2;

import java.time.Month;
import java.util.List;

public class CinemaRunner {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.addFilm(new Film(1, 2009, Month.JANUARY, FilmGenre.Action, 9.5));
        cinema.addFilm(new Film(2, 2009, Month.MAY, FilmGenre.Comedy, 8.1));
        cinema.addFilm(new Film(3, 2012, Month.DECEMBER, FilmGenre.Action, 1.1));
        cinema.addFilm(new Film(4, 2011, Month.NOVEMBER, FilmGenre.Action, 8.0));
        cinema.addFilm(new Film(5, 2008, Month.FEBRUARY, FilmGenre.Historical, 4.5));
        cinema.addFilm(new Film(6, 2009, Month.JANUARY, FilmGenre.Detective, 7.1));
        cinema.addFilm(new Film(7, 2013, Month.DECEMBER, FilmGenre.Action, 1.2));
        cinema.addFilm(new Film(8, 2008, Month.MARCH, FilmGenre.Action, 5.5));

        System.out.println(cinema);
        System.out.println();

        List<Film> filmsByYearOfPublishing = cinema.getFilmsByYearOfPublishing(2009);
        System.out.println(filmsByYearOfPublishing);
        System.out.println();
        List<Film> filmsByYearAndMonth = cinema.getFilmsByYearAndMonthOfPublishing(2009, Month.JANUARY);
        System.out.println(filmsByYearAndMonth);
        System.out.println();
        List<Film> filmsAction = cinema.getFilmsByGenre(FilmGenre.Action);
        System.out.println(filmsAction);
        System.out.println();
        List<Film> topFilms = cinema.getTopTenFilms();
        System.out.println(topFilms);
    }
}
