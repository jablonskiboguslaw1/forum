--liquibase formatted sql
-- changeset  bogu:4
CREATE TABLE users (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE ,
  password VARCHAR(100) NOT NULL,
  enabled boolean NOT NULL
);
-- changeset  bogu:5
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
 CONSTRAINT  fk_authorities_users FOREIGN KEY (username) REFERENCES users(username),
UNIQUE KEY username_authority (username, authority)
);

-- changeset  bogu:6
INSERT  INTO users(id,username, password, enabled) values (1,'bogu','$2a$10$20Yk/pqxxenncFbJoQoby.WPW9RhtWx3rvI5tnQmWFTDEqKmzPMsK',true);
INSERT  INTO  authorities(username, authority) values ('bogu', 'USER');