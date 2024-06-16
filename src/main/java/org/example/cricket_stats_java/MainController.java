package org.example.cricket_stats_java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MainController {

    @FXML
    private VBox barChartView;

    @FXML
    private VBox comparisonView;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TableView<PlayerComparison> comparisonTable;

    @FXML
    private TableColumn<PlayerComparison, String> nameColumn;

    @FXML
    private TableColumn<PlayerComparison, Integer> runsColumn;

    @FXML
    private TableColumn<PlayerComparison, Double> averageColumn;

    @FXML
    private TableColumn<PlayerComparison, Double> strikeRateColumn;

    @FXML
    private TableColumn<PlayerComparison, Integer> fiftiesColumn;

    @FXML
    private TableColumn<PlayerComparison, Integer> hundredsColumn;

    @FXML
    private ImageView playerImage;

    @FXML
    private Label playerNameLabel;

    private int currentIndex = 0;
    private final String[] playerNames = {"Virat Kohli", "Steve Smith", "Joe Root", "Kane Williamson", "Babar Azam"};

    // Map to store player names and their corresponding image paths
    private final Map<String, String> playerImageMap = new HashMap<>() {{
        put("Virat Kohli", "/images/Virat_Kohli.png");
        put("Steve Smith", "/images/Steve_Smith.png");
        put("Joe Root", "/images/Joe_Root.png");
        put("Kane Williamson", "/images/Kane_Williamson.png");
        put("Babar Azam", "/images/Babar_Azam.png");
    }};

    // Method called upon controller initialization
    @FXML
    public void initialize() {
        showBarChart(playerNames[currentIndex]);  // Show bar chart for the first player
        setupComparisonTable();  // Setup the comparison table
    }

    // Method to display bar chart for the given player
    private void showBarChart(String playerName) {
        barChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(playerName);

        // SQL query to fetch player's yearly runs
        String query = "SELECT year, runs FROM player_stats WHERE name = '" + playerName + "' ORDER BY year";
        try (Connection connection = new org.example.cricket_stats_java.DatabaseConnector().connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                series.getData().add(new XYChart.Data<>(resultSet.getString("year"), resultSet.getInt("runs")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        barChart.getData().add(series);

        // Set player image and name
        String imagePath = playerImageMap.get(playerName);
        if (imagePath != null) {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            playerImage.setImage(image);
        }
        playerNameLabel.setText(playerName);
    }

    // Handler for the "Previous Player" button click
    @FXML
    private void onPreviousPlayerClick() {
        currentIndex = (currentIndex - 1 + playerNames.length) % playerNames.length;
        showBarChart(playerNames[currentIndex]);
    }

    // Handler for the "Next Player" button click
    @FXML
    private void onNextPlayerClick() {
        currentIndex = (currentIndex + 1) % playerNames.length;
        showBarChart(playerNames[currentIndex]);
    }

    // Handler for the "Compare Players" button click
    @FXML
    private void onComparePlayersClick() {
        barChartView.setVisible(false);  // Hide bar chart view
        comparisonView.setVisible(true);  // Show comparison view
    }

    // Handler for the "Back to Bar Chart" button click
    @FXML
    private void onBackToBarChartClick() {
        comparisonView.setVisible(false);  // Hide comparison view
        barChartView.setVisible(true);  // Show bar chart view
    }

    // Method to setup the comparison table
    private void setupComparisonTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        runsColumn.setCellValueFactory(new PropertyValueFactory<>("totalRuns"));
        averageColumn.setCellValueFactory(new PropertyValueFactory<>("average"));
        strikeRateColumn.setCellValueFactory(new PropertyValueFactory<>("strikeRate"));
        fiftiesColumn.setCellValueFactory(new PropertyValueFactory<>("fifties"));
        hundredsColumn.setCellValueFactory(new PropertyValueFactory<>("hundreds"));

        // Fetch and set comparison data in the table
        ObservableList<PlayerComparison> data = fetchComparisonData();
        comparisonTable.setItems(data);
    }

    // Method to fetch comparison data from the database
    private ObservableList<PlayerComparison> fetchComparisonData() {
        ObservableList<PlayerComparison> data = FXCollections.observableArrayList();

        // SQL query to fetch player comparison stats
        String query = "SELECT name, SUM(runs) AS total_runs, " +
                "AVG(average) AS average, AVG(strike_rate) AS strike_rate, " +
                "SUM(fifties) AS fifties, SUM(hundreds) AS hundreds " +
                "FROM player_stats GROUP BY name";

        try (Connection connection = new org.example.cricket_stats_java.DatabaseConnector().connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                PlayerComparison playerComparison = new PlayerComparison(
                        resultSet.getString("name"),
                        resultSet.getInt("total_runs"),
                        resultSet.getDouble("average"),
                        resultSet.getDouble("strike_rate"),
                        resultSet.getInt("fifties"),
                        resultSet.getInt("hundreds")
                );
                data.add(playerComparison);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
