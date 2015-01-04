
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
 
INSERT INTO users(username,password,enabled)
VALUES ('admin','$2a$06$xYTm9Xf5expg9p39V6kVEuHCgT5kPAMXAIVoWjFyOvhq0BYdAlEDW', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('user','$2a$06$mAUzj1DmcxQniMTJ7wNFWeKobyEorZkxeD1TwZVc.om0PvPAW2152', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('guest','$2a$06$o2Jj9uUlv1dwm7DmzfJVjOUuuu3C8.MgAu.7S00SjiwCW5gsyi4qa', TRUE);
 
INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, ROLE)
VALUES ('user', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('guest', 'ROLE_GUEST');

