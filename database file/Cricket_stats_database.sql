-- Drop the existing database
DROP DATABASE IF EXISTS cricket_stats_new;

-- Create a new database
CREATE DATABASE cricket_stats_new;

-- Use the new database
USE cricket_stats_new;

-- Create the player_stats table
CREATE TABLE player_stats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    year VARCHAR(4) NOT NULL,
    runs INT NOT NULL,
    average DOUBLE NOT NULL,
    strike_rate DOUBLE NOT NULL,
    fifties INT NOT NULL,
    hundreds INT NOT NULL
);

-- Insert sample data into player_stats table
INSERT INTO player_stats (name, year, runs, average, strike_rate, fifties, hundreds)
VALUES
('Virat Kohli', '2019', 1340, 53.60, 93.65, 6, 5),
('Virat Kohli', '2020', 878, 43.90, 85.32, 4, 3),
('Virat Kohli', '2021', 1102, 47.52, 88.44, 5, 4),
('Virat Kohli', '2022', 1234, 49.75, 91.20, 7, 3),
('Virat Kohli', '2023', 1450, 57.80, 95.50, 8, 6),
('Steve Smith', '2019', 1284, 52.34, 82.13, 7, 4),
('Steve Smith', '2020', 934, 47.30, 76.45, 3, 2),
('Steve Smith', '2021', 1176, 50.20, 80.15, 6, 4),
('Steve Smith', '2022', 1123, 48.90, 78.00, 4, 3),
('Steve Smith', '2023', 1325, 55.10, 83.25, 6, 5),
('Kane Williamson', '2019', 1420, 55.45, 84.50, 5, 6),
('Kane Williamson', '2020', 1201, 53.00, 82.10, 5, 4),
('Kane Williamson', '2021', 1065, 51.80, 79.30, 3, 3),
('Kane Williamson', '2022', 1320, 54.35, 81.20, 4, 5),
('Kane Williamson', '2023', 1478, 58.75, 86.10, 7, 6),
('Joe Root', '2019', 1187, 49.45, 85.75, 5, 3),
('Joe Root', '2020', 965, 46.10, 80.50, 4, 2),
('Joe Root', '2021', 1298, 52.65, 83.60, 6, 4),
('Joe Root', '2022', 1244, 50.45, 82.00, 5, 3),
('Joe Root', '2023', 1356, 54.30, 87.20, 6, 4),
('Babar Azam', '2019', 1278, 51.35, 86.75, 4, 5),
('Babar Azam', '2020', 1123, 48.90, 83.45, 4, 3),
('Babar Azam', '2021', 1350, 56.30, 89.25, 7, 5),
('Babar Azam', '2022', 1285, 52.75, 87.10, 5, 4),
('Babar Azam', '2023', 1425, 55.80, 90.45, 6, 5);
