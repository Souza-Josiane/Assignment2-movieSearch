package org.example.moviesearch;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.json.JSONObject;

import java.io.IOException;

public class MovieController {
    @FXML
    private TextField movieTextField;

    @FXML
    private Button searchButton;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label ratedLabel;

    @FXML
    private Label runtimeLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label directorLabel;

    @FXML
    private Label plotLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private void initialize() {
        // Add an EventHandler to capture the keypress event in the TextField
        movieTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // Checks if the key pressed was the Enter key
                if (event.getCode().equals(KeyCode.ENTER)) {
                    searchMovie();
                }
            }
        });
    }

    @FXML
    private void searchMovie() {
        String apiKey = "57e53664";
        // Gets the title of the movie entered by the user
        String movieTitle = movieTextField.getText().trim();

        if (!movieTitle.isEmpty()) {
            String apiUrl = "https://www.omdbapi.com/?apikey=" + apiKey + "&t=" + movieTitle;

            try {
                String jsonResponse = MovieApi.fetchDataFromAPI(apiUrl);
                JSONObject jsonObject = new JSONObject(jsonResponse);

                // Checks if the movie was found based on the JSON returned
                if (jsonObject.has("Error")) {
                    // If the "Error" key is present, it means the movie was not found
                    String errorMessage = jsonObject.getString("Error");
                    titleLabel.setText("Movie not found");

                    // Call the method clearMovieDetails
                    clearMovieDetails();
                    movieTextField.clear();
                    movieTextField.requestFocus();
                    return;
                }

                // Parse the JSON and create an instance of MovieDetails
                MovieDetails movieDetails = new MovieDetails(jsonObject);

                titleLabel.setText(movieDetails.getTitle());
                yearLabel.setText(movieDetails.getYear());
                ratedLabel.setText("Rate: " + movieDetails.getRated());
                runtimeLabel.setText(movieDetails.getRuntime());
                genreLabel.setText(movieDetails.getGenre());
                directorLabel.setText("Director: " + movieDetails.getDirector());
                plotLabel.setText(movieDetails.getPlot());

                String posterUrl = movieDetails.getPoster();
                Image posterImage = new Image(posterUrl);
                posterImageView.setImage(posterImage);

                // Clear TextField after successful fetch
                movieTextField.clear();
                // Set focus back on TextField
                movieTextField.requestFocus();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearMovieDetails() {
        yearLabel.setText("");
        ratedLabel.setText("");
        runtimeLabel.setText("");
        genreLabel.setText("");
        directorLabel.setText("");
        plotLabel.setText("");
        posterImageView.setImage(null);
    }
}