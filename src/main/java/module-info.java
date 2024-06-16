module org.example.cricket_stats_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.cricket_stats_java to javafx.fxml;
    exports org.example.cricket_stats_java;
}