INSERT INTO customer (id, name) VALUES (1, 'Joni');

INSERT INTO license (id, license_type) VALUES (1, 'MATCH');

INSERT INTO tournament (id, name) VALUES (1,'US OPEN');

INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (1, 'Roger Federer','Andy Murray', CURRENT_TIME , 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (2, 'Andy Murray','Rafa Nadal',DATEADD(HOUR, 1, CURRENT_TIME), 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (3, 'Rafa Nadal','Nole Djokovic',DATEADD(HOUR, -1, CURRENT_TIME), 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (4, 'Nole Djokovic','Roger Federer','2022-04-28T12:00:00', 1);
INSERT INTO match (id, playera, playerb, start_date, tournament_id) VALUES (5, 'Rafa Nadal','Roger Federer','2022-05-31T12:00:00', 1);

INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,1);
INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,2);
INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,3);
INSERT INTO customer_match (customer_fk, match_fk) VALUES (1,4);

INSERT INTO customer_license (customer_fk, license_fk) VALUES (1,1);