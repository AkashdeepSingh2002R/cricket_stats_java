package org.example.cricket_stats_java;

// Class to represent a player's data over multiple years
public class PlayerData {
    private final String name;  // Name of the player
    private final int[] runs;  // Array of runs scored by the player each year
    private final String[] years;  // Array of years corresponding to the runs

    // Constructor to initialize all fields
    public PlayerData(String name, int[] runs, String[] years) {
        this.name = name;
        this.runs = runs;
        this.years = years;
    }

    // Getter method for the player's name
    public String getName() {
        return name;
    }

    // Getter method for the runs array
    public int[] getRuns() {
        return runs;
    }

    // Getter method for the years array
    public String[] getYears() {
        return years;
    }
}
