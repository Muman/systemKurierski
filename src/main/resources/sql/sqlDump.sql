
INSERT INTO users_info(
            id, address, city, iscompany, companyname, email, firstname, 
            lastname, phonenumber, postalcode)
            VALUES(
            1, 'Akademicka 2', 'Rzesz�w', 'true', 'Context', 'context@com.pl', 'Jan', 
            'Kowalski', '789765678', '35-084');

INSERT INTO users_info(
            id, address, city, iscompany, companyname, email, firstname, 
            lastname, phonenumber, postalcode)
            VALUES(
            2, 'Piast�w 3', 'Rzesz�w', 'true', 'Comarch', 'comarch@comarch.pl', 'Janusz', 
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
Dodanie r�l u�ytkownika	
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
    VALUES (1, 'Paczka kurierska o wadze do 5 kilogram�w', 'Paczka do 5 kg', 10.00);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (2, 'Paczka kurierska o wadze do 3 kilogram�w', 'Paczka do 3 kg', 7.50);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (3, 'List/Koperta do 2 kg', 'List o wadze do 2kg', 5.00);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (4, 'Paczka kurierska o wadze do 10 kilogram�w', 'Paczka do 10 kg', 15.00);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (5, 'Paczka kurierska o wadze do 15 kilogram�w', 'Paczka do 15 kg', 25.00);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (6, 'Paczka kurierska o wadze do 25 kilogram�w', 'Paczka do 25 kg', 50.00);
INSERT INTO package_options(
            id, description, name, price)
    VALUES (7, 'Paleta do 25 kg', 'Paleta do 25 kg', 80.00);

INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (1, 'Genera�a Stanis�awa Maczka 6', 'Rzesz�w', 'Oddzia� 2 Rzesz�w', '34-586');


INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (2, 'Wielkopolska 5', 'Rzesz�w', 'Sortownia G��wna Rzesz�w', '34-586');

    
INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (3, 'Targowa 21', 'Rzesz�w', 'Oddzia� 3 Rzesz�w', '34-522');

  INSERT INTO locations(
            id, address, city, name, postal_code)
    VALUES (4, 'POLSKA', 'POLSKA', 'POLSKA', '00-000');

INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (1, 'Cienista 12', 'Rzesz�w', 'Karol Karolak', '456789123', '56-456');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (2, 'Matuszczaka 20', 'Rzesz�w', 'Karol Iwi�ski', '456712123', '56-436');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (3, 'Piast�w 5', 'Rzesz�w', 'Adam Witek', '459989123', '56-256');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (1, '2015-02-02', 7, 1, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (2, '2015-02-01', 4, 2, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (3, '2015-02-01', 2, 3, 'jank');

INSERT INTO couriers(
            id, dismiss_date, email, hire_date, name, pesel, surname, location_id)
    VALUES (1, '2015-04-23','d.davids@kurierx.pl', '2012-04-23', 'David', '87898787876', 'Davids', 1);

INSERT INTO couriers(
            id, dismiss_date, email, hire_date, name, pesel, surname, location_id)
    VALUES (2, '2016-04-23','p.jhonson@kurierx.pl', '2011-04-23', 'Piotr', '84898787876', 'Jhonson', 1);


INSERT INTO couriers(
            id, dismiss_date, email, hire_date, name, pesel, surname, location_id)
    VALUES (3, '2015-07-23','j.fergusson@kurierx.pl', '2013-04-23', 'Jan', '83898787876', 'Fergusson', 2);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id)
    VALUES (1, 'Gotowe dla KurierX','2015-02-02', 1, 1, 1);
