
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

INSERT INTO users_info(
            id, address, city, iscompany, companyname, email, firstname, 
            lastname, phonenumber, postalcode)
            VALUES(
            3, 'Krakowskie Przedmieœcie 1', 'Warszawa', 'true', 'MobileSoft', 'comarch@comarch.pl', 'Bronek', 
            'Bronek', '345897771', '35-024');

INSERT INTO users(username,password,enabled,user_info_id,active)
VALUES ('admin','$2a$06$xYTm9Xf5expg9p39V6kVEuHCgT5kPAMXAIVoWjFyOvhq0BYdAlEDW', TRUE,3,true);
INSERT INTO users(username,password,enabled,active)
VALUES ('user','$2a$06$mAUzj1DmcxQniMTJ7wNFWeKobyEorZkxeD1TwZVc.om0PvPAW2152', TRUE,true);
INSERT INTO users(username,password,enabled,active)
VALUES ('guest','$2a$06$o2Jj9uUlv1dwm7DmzfJVjOUuuu3C8.MgAu.7S00SjiwCW5gsyi4qa', TRUE,true);
INSERT INTO users(username,password,enabled,user_info_id,active)
VALUES ('jank','$2a$12$RAaQ1PLiODjC41bEJpIQd.K5rjkHQzbhN2GDFUk5BZUNjk2ehdmSS', TRUE,1,true);
INSERT INTO users(username,password,enabled,user_info_id,active)
VALUES ('filip','$2a$12$hCjr3HtF3W8C4LmIjyznHOX/RABCWj4tYOL2UaoLwdcscR.XMT.O6', TRUE,2,true);

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

INSERT INTO package_options(
            id, description, name, price,active)
    VALUES (1, 'Paczka kurierska o wadze do 5 kilogramów', 'Paczka do 5 kg', 10.00,true);
INSERT INTO package_options(
            id, description, name, price,active)
    VALUES (2, 'Paczka kurierska o wadze do 3 kilogramów', 'Paczka do 3 kg', 7.50,true);
INSERT INTO package_options(
            id, description, name, price,active)
    VALUES (3, 'List/Koperta do 2 kg', 'List o wadze do 2kg', 5.00,true);
INSERT INTO package_options(
            id, description, name, price,active)
    VALUES (4, 'Paczka kurierska o wadze do 10 kilogramów', 'Paczka do 10 kg', 15.00,true);
INSERT INTO package_options(
            id, description, name, price,active)
    VALUES (5, 'Paczka kurierska o wadze do 15 kilogramów', 'Paczka do 15 kg', 25.00,true);
INSERT INTO package_options(
            id, description, name, price,active)
    VALUES (6, 'Paczka kurierska o wadze do 25 kilogramów', 'Paczka do 25 kg', 50.00,true);
INSERT INTO package_options(
            id, description, name, price,active)
    VALUES (7, 'Paleta do 25 kg', 'Paleta do 25 kg', 80.00,true);

INSERT INTO locations(
            id, address, city, name, postal_code,active)
    VALUES (1, 'Genera³a Stanis³awa Maczka 6', 'Rzeszów', 'Oddzia³ 2 Rzeszów', '34-586',true);


INSERT INTO locations(
            id, address, city, name, postal_code,active)
VALUES (2, 'Akademicka 2', 'Rzeszów', 'Sortownia G³ówna Rzeszów', '34-586',true);

INSERT INTO locations(
            id, address, city, name, postal_code,active)
VALUES (3, 'Targowa 21', 'Rzeszów', 'Oddzia³ 3 Rzeszów', '34-522',true);

INSERT INTO locations(
            id, address, city, name, postal_code,active)
VALUES (4, 'POLSKA', 'POLSKA', 'POLSKA', '00-000',true);

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (1, 'Cienista 12', 'Rzeszów', 'Karol Karolak', '456789123', '56-456');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (2, 'Matuszczaka 20', 'Rzeszów', 'Karol Iwiñski', '456712123', '56-436');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (3, 'Piastów 5', 'Rzeszów', 'Adam Witek', '459989123', '56-256');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (4, 'Wielkopolska 5', 'Rzeszów', 'Urszula Ungeheuer', '459989123', '56-256');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (5, 'Kwiatkowskiego 12', 'Rzeszów', 'Bernard Wais', '459989123', '56-256');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (6, 'Lwowska 12', 'Rzeszów', 'Ryszard Model', '459989123', '56-256');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (7, 'Hanasiewicza 12', 'Rzeszów', 'Stacy Petrovschi', '456789123', '56-456');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (8, 'Przemys³owa 20', 'Rzeszów', 'Karol Kruk', '456712123', '56-436');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (9, 'Architektów 5', 'Rzeszów', 'Adam Damon', '459989123', '56-256');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (10, 'Lubelska 12', 'Rzeszów', 'David Cooperfield', '459989123', '56-256');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (11, 'Warszawska 10', 'Rzeszów', 'Janusz Korwin-Mikke', '459989123', '56-256');

    INSERT INTO recipient(
            id, address, city, name, phonenumber, postalcode)
    VALUES (12, 'Bardowskiego 4', 'Rzeszów', 'Ryszard Krauze', '459989123', '56-256');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
VALUES (1, '2015-02-02', 7, 1, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
VALUES (2, '2015-02-01', 4, 2, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (3, '2015-02-01', 2, 3, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (4, '2015-02-02', 7, 4, 'filip');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (5, '2015-02-01', 4, 5, 'filip');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (6, '2015-02-01', 2, 6, 'filip');

/***/

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
VALUES (7, '2015-02-02', 7, 7, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
VALUES (8, '2015-02-01', 4, 8, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (9, '2015-02-01', 2, 9, 'jank');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (10, '2015-02-02', 7, 10, 'filip');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (11, '2015-02-01', 4, 11, 'filip');

INSERT INTO shipment(
            id, register_date, packageoption_id, recipient_id, username)
    VALUES (12, '2015-02-01', 2, 12, 'filip');

/****/

INSERT INTO couriers(
            id, dismiss_date, email, hire_date, name, pesel, surname, location_id,login,password,active)
    VALUES (1, '2015-04-23','d.davids@kurierx.pl', '2012-04-23', 'David', '87898787876', 'Davids', 2,'d.davids','qaz',true);

INSERT INTO couriers(
            id, dismiss_date, email, hire_date, name, pesel, surname, location_id,login,password,active)
    VALUES (2, '2016-04-23','p.jhonson@kurierx.pl', '2011-04-23', 'Piotr', '84898737876', 'Jhonson', 2,'p.jhonson','qaz',true);

INSERT INTO couriers(
            id, dismiss_date, email, hire_date, name, pesel, surname, location_id,login,password,active)
    VALUES (3, '2015-07-23','j.fergusson@kurierx.pl', '2013-04-23', 'Jan', '83898787876', 'Fergusson', 2,'j.fergusson','qaz',true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (1, 'Oczekuje na odbiór przez KurierX','2015-02-02', 1, 2, 1,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (2, 'Oczekuje na odbiór przez KurierX','2015-02-02', 1, 2, 2,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (3, 'Oczekuje na odbiór przez KurierX','2015-02-02', 1, 2, 3,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (4, 'Nadejscie przesy³ki','2015-02-02', 1, 2, 4,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (5, 'Nadejscie przesy³ki','2015-02-02', 1, 2, 5,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (6, 'Oczekuje na odbiór przez KurierX','2015-02-02', 1, 2, 6,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (7, 'Oczekuje na odbiór przez KurierX','2015-02-02', 1, 2, 7,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (8, 'Oczekuje na odbiór przez KurierX','2015-02-02', 1, 2, 8,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (9, 'Oczekuje na odbiór przez KurierX','2015-02-02', 1, 2, 9,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
    VALUES (10, 'Nadejscie przesy³ki','2015-02-02', 1, 2, 10,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (11, 'Nadejscie przesy³ki','2015-02-02', 1, 2, 11,true);

INSERT INTO package_status(
            id, name, status_date, courier_id, location_id, shipment_id,active)
VALUES (12, 'Nadejscie przesy³ki','2015-02-02', 1, 2, 12,true);