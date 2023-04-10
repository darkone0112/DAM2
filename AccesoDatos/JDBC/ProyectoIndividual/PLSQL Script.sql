CREATE TABLE videogames (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    estudio VARCHAR(255) NOT NULL,
    fechaSalida DATE NOT NULL,
    nota INT(11) NOT NULL,
    peso DOUBLE NOT NULL,
    PRIMARY KEY (id)
);
/* Inserting */
INSERT INTO videogames (titulo, genero, estudio, fechaSalida, nota, peso)
VALUES
("The Legend of Zelda: Breath of the Wild", "Action-Adventure", "Nintendo", "2017-03-03", 9, 13.4),
("Super Mario Odyssey", "Platformer", "Nintendo", "2017-10-27", 9, 12.1),
("Red Dead Redemption 2", "Action-Adventure", "Rockstar Games", "2018-10-26", 9, 99.1),
("God of War", "Action-Adventure", "Santa Monica Studio", "2018-04-20", 9, 39.7),
("The Witcher 3: Wild Hunt", "Action RPG", "CD Projekt RED", "2015-05-19", 9, 35.3),
("Grand Theft Auto V", "Action-Adventure", "Rockstar North", "2013-09-17", 9, 78.1),
("Celeste", "Platformer", "Maddy Makes Games", "2018-01-25", 9, 1.2),
("Overwatch", "First-person shooter", "Blizzard Entertainment", "2016-05-24", 8, 12.8),
("Portal 2", "Puzzle-platformer", "Valve Corporation", "2011-04-19", 9, 14.5),
("Dark Souls III", "Action RPG", "FromSoftware", "2016-03-24", 9, 15.2),
("The Last of Us", "Action-adventure survival horror", "Naughty Dog", "2013-06-14", 9, 21.9),
("Uncharted 4: A Thief's End", "Action-adventure", "Naughty Dog", "2016-05-10", 9, 23.5),
("Spider-Man", "Action-adventure", "Insomniac Games", "2018-09-07", 9, 39.4),
("DOOM (2016)", "First-person shooter", "id Software", "2016-05-13", 9, 22.8),
("Halo: Combat Evolved", "First-person shooter", "Bungie", "2001-11-15", 9, 11.2)