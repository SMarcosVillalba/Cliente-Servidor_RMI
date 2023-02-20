CREATE DATABASE VIDEOJUEGOS;

USE VIDEOJUEGOS;

CREATE TABLE videojuegos (
  id INT PRIMARY KEY,
  nombre VARCHAR(255),
  ano_lanzamiento INT,
  desarrollador VARCHAR(255),
  plataforma VARCHAR(255),
  genero VARCHAR(255),
  puntuacion FLOAT
);

INSERT INTO videojuegos (id, nombre, ano_lanzamiento, desarrollador, plataforma, genero, puntuacion)
VALUES
  (1, 'The Last of Us Part II', 2020, 'Naughty Dog', 'PlayStation 4', 'Acción, Aventura', 9.5),
  (2, 'Red Dead Redemption 2', 2018, 'Rockstar Games', 'PlayStation 4, Xbox One', 'Acción, Aventura', 9.0),
  (3, 'Final Fantasy VII Remake', 2020, 'Square Enix', 'PlayStation 4', 'RPG', 8.5),
  (4, 'God of War', 2018, 'Santa Monica Studio', 'PlayStation 4', 'Acción, Aventura', 9.0),
  (5, 'Super Mario Odyssey', 2017, 'Nintendo EPD', 'Nintendo Switch', 'Plataformas', 9.0),
  (6, 'Halo 5: Guardians', 2015, '343 Industries', 'Xbox One', 'Acción, Disparos en primera persona', 8.0),
  (7, 'Overwatch', 2016, 'Blizzard Entertainment', 'PlayStation 4, Xbox One, PC', 'Shooter multijugador', 8.5),
  (8, 'Minecraft', 2011, 'Mojang Studios', 'Multiplatforma', 'Sandbox, Aventura', 9.0),
  (9, 'The Witcher 3: Wild Hunt', 2015, 'CD Projekt RED', 'PlayStation 4, Xbox One, PC', 'RPG', 9.0),
  (10, 'Grand Theft Auto V', 2013, 'Rockstar North', 'PlayStation 4, Xbox One, PC', 'Acción, Aventura', 9.0);
