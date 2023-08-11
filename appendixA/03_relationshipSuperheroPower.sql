-- Create a linking table (SuperheroPower) in order to setup the Superhero-power relationship 

CREATE TABLE SuperheroPower (
    SuperheroId INT,
    PowerId INT,
    PRIMARY KEY (SuperheroId, PowerId),
    FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id),
    FOREIGN KEY (PowerId) REFERENCES Power(Id)
);