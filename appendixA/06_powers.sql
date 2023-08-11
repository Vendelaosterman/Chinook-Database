-- Insert powers into Power table 

INSERT INTO Power (Name, description)
VALUES 
    ('Super Strength', 'Ability to exhibit superhuman strength'),
    ('Telekinesis', 'Ability to move objects with the mind'),
    ('Invisibility', 'Ability to become invisible'),
    ('Time Manipulation', 'Ability to control and manipulate time')

-- Delegate powers to superheroes 

INSERT INTO SuperheroPower (SuperheroId, PowerId)
VALUES 
    (1,1),
    (1,2),
    (2,4),
    (3,4),
    (2,3)