
DROP TABLE IF EXISTS Superhero;
-- Create Superhero table
CREATE TABLE Superhero (
    Id serial PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Alias VARCHAR(255) NOT NULL,
    Origin VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS Assistant;
-- Create Assistant table
CREATE TABLE Assistant (
    Id serial PRIMARY KEY,
    Name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS Power;
-- Create Power table
CREATE TABLE Power (
    Id serial PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Description VARCHAR(255) NOT NULL
);