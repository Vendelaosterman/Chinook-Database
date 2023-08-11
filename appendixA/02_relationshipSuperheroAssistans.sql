
-- Create a FOREIGN KEY constraint on the on the SuperheroId which references to the id of the superhero. 

ALTER TABLE Assistant
ADD COLUMN SuperheroId INT,
ADD CONSTRAINT Assistant_Superhero FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id);