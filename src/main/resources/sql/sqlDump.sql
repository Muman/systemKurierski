
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
 
CREATE TABLE user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
 
INSERT INTO users_info(
            id, address, city, iscompany, companyname, email, firstname, 
            lastname, phonenumber, postalcode)
            VALUES(
            1, 'Akademicka 2', 'Rzeszów', 'true', 'Context', 'context@com.pl', 'Jan', 
            'Kowalski', '789765678', '35-084');

            INSERT INTO users_info(
            id, address, city, iscompany, companyname, email, firstname, 
            lastname, phonenumber, postalcode)
            VALUES(
            2, 'Piastów 3', 'Rzeszów', 'true', 'Comarch', 'comarch@comarch.pl', 'Janusz', 
            'Filipiak', '345897771', '35-024');
/**
Dodaj uzytkownikow
**/
INSERT INTO users(username,password,enabled)
VALUES ('admin','$2a$06$xYTm9Xf5expg9p39V6kVEuHCgT5kPAMXAIVoWjFyOvhq0BYdAlEDW', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('user','$2a$06$mAUzj1DmcxQniMTJ7wNFWeKobyEorZkxeD1TwZVc.om0PvPAW2152', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('guest','$2a$06$o2Jj9uUlv1dwm7DmzfJVjOUuuu3C8.MgAu.7S00SjiwCW5gsyi4qa', TRUE);
INSERT INTO users(username,password,enabled,user_info_id)
VALUES ('jank','$2a$12$RAaQ1PLiODjC41bEJpIQd.K5rjkHQzbhN2GDFUk5BZUNjk2ehdmSS', TRUE,1);
INSERT INTO users(username,password,enabled,user_info_id)
VALUES ('filip','$2a$12$hCjr3HtF3W8C4LmIjyznHOX/RABCWj4tYOL2UaoLwdcscR.XMT.O6', TRUE,2);
/**
Dodaj detale uzytwkonikow
**/

/**
Dodanie ról u¿ytkownika	
**/

INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, ROLE)
VALUES ('user', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('guest', 'ROLE_GUEST');
INSERT INTO user_roles (username, ROLE)
VALUES ('jank', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('filip', 'ROLE_USER');
/**
Dodanie opcji paczki	
**/

INSERT INTO package_options(
            id, description, name, price)
    VALUES (1, 'Paczka kurierska o wadze do 5 kilogramów', 'Paczka do 5 kg', 10.00);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (2, 'Paczka kurierska o wadze do 3 kilogramów', 'Paczka do 3 kg', 7.50);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (3, 'List/Koperta do 2 kg', 'List o wadze do 2kg', 5.00);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (4, 'Paczka kurierska o wadze do 10 kilogramów', 'Paczka do 10 kg', 15.00);
    INSERT INTO package_options(
            id, description, name, price)
    VALUES (5, 'Paczka kurierska o wadze do 15 kilogramów', 'Paczka do 15 kg', 25.00);
    INSERT INTO package_options(
            id, description, name, price)
    VALUES (6, 'Paczka kurierska o wadze do 25 kilogramów', 'Paczka do 25 kg', 50.00);
    INSERT INTO package_options(
            id, description, name, price)
    VALUES (7, 'Paleta do 25 kg', 'Paleta do 25 kg', 80.00);

    INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (1, 'Genera³a Stanis³awa Maczka 6', 'Rzeszów', 'Oddzia³ 2 Rzeszów', '34-586');


    INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (2, 'Wielkopolska 5', 'Rzeszów', 'Sortownia G³ówna Rzeszów', '34-586');

    
    INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (3, 'Targowa 21', 'Rzeszów', 'Oddzia³ 3 Rzeszów', '34-522');

  INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (4, 'POLSKA', 'POLSKA', 'POLSKA', '00-000');    