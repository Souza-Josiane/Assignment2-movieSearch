module org.example.moviesearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens org.example.moviesearch to javafx.fxml;
    exports org.example.moviesearch;
}