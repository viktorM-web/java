package com.viktor.javalevel2.collections.homework.part2;

import java.time.Month;
import java.util.Objects;

public class Film {
    private final int id;
    private final int yearOfPublishing;
    private final Month monthOfPublishing;
    private final FilmGenre genre;
    private final double rating;

    public Film(int id, int yearOfPublishing, Month monthOfPublishing, FilmGenre genre, double rating) {
        this.id = id;
        this.yearOfPublishing = yearOfPublishing;
        this.monthOfPublishing = monthOfPublishing;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", yearOfPublishing=" + yearOfPublishing +
                ", monthOfPublishing=" + monthOfPublishing +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public Month getMonthOfPublishing() {
        return monthOfPublishing;
    }

    public FilmGenre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && yearOfPublishing == film.yearOfPublishing && Double.compare(film.rating, rating) == 0 &&
                monthOfPublishing == film.monthOfPublishing && genre == film.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yearOfPublishing, monthOfPublishing, genre, rating);
    }
}
