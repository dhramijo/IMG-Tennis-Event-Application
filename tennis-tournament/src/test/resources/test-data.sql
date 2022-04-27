CREATE TABLE if not exists customer (id INT NOT NULL, name VARCHAR(50) NOT NULL);
CREATE TABLE if not exists license (id INT NOT NULL, license_type VARCHAR(50) NOT NULL);
CREATE TABLE if not exists tournament (id INT NOT NULL, name VARCHAR(50) NOT NULL);
CREATE TABLE if not exists match (
  id INT NOT NULL,
  playera VARCHAR(50) NOT NULL,
  playerb VARCHAR(50) NOT NULL,
  start_date VARCHAR(50) NOT NULL,
  summary VARCHAR(50),
  tournament_id INT NOT NULL
);

CREATE TABLE if not exists customer_match (customer_fk INT NOT NULL, match_fk INT NOT NULL);

CREATE TABLE if not exists customer_license (customer_fk INT NOT NULL, license_fk INT NOT NULL);

INSERT INTO customer (id, name) VALUES (1, 'Joni');

INSERT INTO license (id, license_type) VALUES (1, 'MATCH');

INSERT INTO tournament (id, name) VALUES (1,'US OPEN');

INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (1, 'Roger Federer','Andy Murray', '2022-04-28T12:00:00' , 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (2, 'Andy Murray','Rafa Nadal','2022-04-28T13:00:00', 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (3, 'Rafa Nadal','Nole Djokovic','2022-04-29T12:00:00', 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (4, 'Nole Djokovic','Roger Federer','2022-04-28T12:00:00', 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (5, 'Rafa Nadal','Roger Federer','2022-05-31T12:00:00', 1);


INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,1);
INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,2);
INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,3);
INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,4);

INSERT INTO customer_license (customer_fk, license_fk) VALUES (1,1);