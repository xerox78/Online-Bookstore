-- insert initial default roles
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO users (email, password, username) VALUES ('test@gmail.com', '$2a$10$pBoAjsuK/JAvpye44Cb.yOVRlEdCUkn9bWcVwKn9E7hPRnENPNliO', 'test');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);