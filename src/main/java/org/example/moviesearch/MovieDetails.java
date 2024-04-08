package org.example.moviesearch;

import org.json.JSONObject;

public class MovieDetails {
    private String title;
    private String year;
    private String rated;
    private String runtime;
    private String genre;
    private String director;
    private String plot;
    private String poster;

    public MovieDetails(JSONObject json) {
        this.title = json.getString("Title");
        this.year = json.getString("Year");
        this.rated = json.getString("Rated");
        this.runtime = json.getString("Runtime");
        this.genre = json.getString("Genre");
        this.director = json.getString("Director");
        this.plot = json.getString("Plot");
        this.poster = json.getString("Poster");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
