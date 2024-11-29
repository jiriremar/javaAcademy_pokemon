# Vytvor JDBC CRUD aplikáciu, v ktorej budeš pracovať s pokémonmi a trénermi

---
### Čo treba spraviť:
- CRUD nad pokémonmi
- CRUD nad trénermi
- Jeden pokémon patrí práve jednému, alebo žiadnemu trénerovi
- Jeden tréner môže mať viacero pokémonov

### Špeciálne funkcionalitky, ktoré tvoja aplikácia ponúka
- Vypísať pokémonov, ktoré patria danému trénerovi
- Vypísať trénerov, ktorí sú zoradení podľa toho, kto má koľko pokémonov
- Vypísať pokémonov, ktorí nie sú chytení (nikomu nepatria)
- Chytiť pokémona (zvolíš trénera, ktorý chytá, ďalej pokémona, ktorý nikomu nepatrí)

---
# Poznámky:
## Tabulky
### pokemon
- id_pokemon - int + PK
- id_trainer - int (id trenera)
- pokemon_name - String
- id_type_pokemon - int (water, grass ...)
- attack - int
- deffence - int


### trainer
- id_trainer - int + PK
- trainer_name - String + Unique
- id_speciality - String ( speciliazed to: water, grass ...) 

### pokemon_type
- id_type - int PK
- type_name - String Unique

### trainer_type_speciality
- id_speciality - int PK
- speciality_name - String Unique

```` MYSQL
CREATE DATABASE pokemons;
USE pokemons;

CREATE TABLE trainer_type_speciality (
id_speciality INT PRIMARY KEY AUTO_INCREMENT,
speciality_name VARCHAR(50) trainerNOT NULL UNIQUE
);

CREATE TABLE pokemon_type (
id_type INT PRIMARY KEY AUTO_INCREMENT,
type_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE trainer (
id_trainer INT PRIMARY KEY AUTO_INCREMENT,
trainer_name VARCHAR(50) NOT NULL UNIQUE,
id_speciality INT NOT NULL,
FOREIGN KEY(id_speciality) REFERENCES trainer_type_speciality(id_speciality)
);

CREATE TABLE pokemon (
id_pokemon INT PRIMARY KEY AUTO_INCREMENT,
id_trainer INT,
pokemon_name VARCHAR(50) NOT NULL UNIQUE,
id_type_pokemon INT NOT NULL,
attack INT NOT NULL,
defence INT NOT NULL,
FOREIGN KEY(id_trainer) REFERENCES trainer(id_trainer),
FOREIGN KEY(id_type_pokemon) REFERENCES pokemon_type(id_type)
);

INSERT INTO pokemon_type (type_name) 
VALUES 
('normal'),
('fighting'),
('flying'),
('poison'),
('ground'),
('rock'),
('bug'),
('ghosts'),
('steel'),
('fire'),
('water'),
('grass'),
('electric'),
('ice'),
('dragon'),
('dark'),
('fairy'),
('stellar'),
('unknown');

INSERT INTO trainer_type_speciality (speciality_name) 
VALUES 
('Catch flying pokemon'),
('Catch ground pokemon'),
('Catch small pokemon'),
('Catch big pokemon');

INSERT INTO trainer (trainer_name, id_speciality) VALUES ("Ash Ketchum", 1);

INSERT INTO pokemon (id_trainer, pokemon_name, id_type_pokemon, attack, defence) VALUES (1, 'Bulbasaur', 12, 22, 5);
INSERT INTO pokemon (id_trainer, pokemon_name, id_type_pokemon, attack, defence) VALUES (NULL, 'Charmander', 10, 50, 13);

````