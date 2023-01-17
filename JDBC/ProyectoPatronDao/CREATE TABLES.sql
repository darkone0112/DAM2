CREATE TABLE studios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    dateCreation DATE NOT NULL,
    headquarters VARCHAR(255) NOT NULL,
    numberWorkers INT(11) NOT NULL,
    PRIMARY KEY (id)
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