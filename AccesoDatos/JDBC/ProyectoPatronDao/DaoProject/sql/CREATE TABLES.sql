
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
ALTER TABLE videogames
    ADD CONSTRAINT fk_estudio
    FOREIGN KEY (estudio)
    REFERENCES studios(nombre);
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

DROP TABLE studios;
CREATE TABLE studios (
    name VARCHAR(255) NOT NULL,
    dateCreation DATE NOT NULL,
    headquarters VARCHAR(255) NOT NULL,
    numberWorkers INT(11) NOT NULL,
    PRIMARY KEY (nombre)
);

INSERT INTO studios (nombre, dateCreation, headquarters, numberWorkers)
VALUES
("Nintendo", "1889-09-23", "Kyoto, Japan", 8700),
("Rockstar Games", "1998-05-22", "New York City, USA", 1000),
("Santa Monica Studio", "1999-01-01", "Santa Monica, USA", 250),
("CD Projekt RED", "2002-05-11", "Warsaw, Poland", 600),
("Rockstar North", "1998-05-22", "Edinburgh, Scotland", 400),
("Maddy Makes Games", "2011-01-01", "Seattle, USA", 20),
("Blizzard Entertainment", "1991-02-08", "Irvine, USA", 9100),
("Valve Corporation", "1996-08-24", "Bellevue, USA", 500),
("FromSoftware", "1986-11-01", "Tokyo, Japan", 200),
("Naughty Dog", "1984-10-01", "Santa Monica, USA", 250),
("Insomniac Games", "1994-09-01", "Burlingame, USA", 150),
("id Software", "1991-05-01", "Richardson, USA", 120),
("Bungie", "1991-05-01", "Bellevue, USA", 300)

use videogames;
select * from studios;