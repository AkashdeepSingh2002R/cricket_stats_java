package org.example.cricket_stats_java;

// Class to represent the comparison data for a player
public class PlayerComparison {
    private String name;  // Name of the player
    private int totalRuns;  // Total runs scored by the player
    private double average;  // Batting average of the player
    private double strikeRate;  // Strike rate of the player
    private int fifties;  // Number of half-centuries scored by the player
    private int hundreds;  // Number of centuries scored by the player

    // Constructor to initialize all fields
    public PlayerComparison(String name, int totalRuns, double average, double strikeRate, int fifties, int hundreds) {
        this.name = name;
        this.totalRuns = totalRuns;
        this.average = average;
        this.strikeRate = strikeRate;
        this.fifties = fifties;
        this.hundreds = hundreds;
    }

    // Getter method for the player's name
    public String getName() {
        return name;
    }

    // Getter method for the total runs
    public int getTotalRuns() {
        return totalRuns;
    }

    // Getter method for the batting average
    public double getAverage() {
        return average;
    }

    // Getter method for the strike rate
    public double getStrikeRate() {
        return strikeRate;
    }

    // Getter method for the number of half-centuries
    public int getFifties() {
        return fifties;
    }

    // Getter method for the number of centuries
    public int getHundreds() {
        return hundreds;
    }
}
