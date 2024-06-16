package org.example.cricket_stats_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {

    // Entry point for JavaFX application
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file that defines the user interface
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/cricket_stats_java/MainView.fxml")));

        // Set the application icon
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/icon.png"))));

        // Create the scene using the loaded FXML
        Scene scene = new Scene(root);

        // Apply the stylesheet to the scene
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/styles.css")).toExternalForm());

        // Set the scene on the primary stage and give it a title
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cricket Stats");

        // Display the stage
        primaryStage.show();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
