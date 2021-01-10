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
insert into users (id, username, password, enabled)
values (1, 'test', '{bcrypt}$2a$10$upzXFsFUOClFRR69OMKF8eajGMRs0vhcSHqvNDKy9yfW45w7o9z6O', true);
insert into authorities (username, authority) values ('test','USER');