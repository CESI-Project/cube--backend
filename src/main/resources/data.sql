INSERT INTO roles(name)
VALUES ('ROLE_USER');
INSERT INTO roles(name)
VALUES ('ROLE_MODERATOR');
INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');
INSERT INTO roles(name)
VALUES ('ROLE_SUPERADMIN');
INSERT INTO users (id, user_name, email, age, password)
VALUES (1, 'userTest', 'usertest@gmail.com', 52,
        '$2a$10$nEytsdN4Zk/cmbfA6rodE.aP8xkUdzS6E0JL/iSPaHfZqGAQA4QV6');
INSERT INTO users (id, user_name, email, age, password)
VALUES (2, 'userTest2', 'usertest2@gmail.com', 25,
        '$2a$10$nEytsdN4Zk/cmbfA6rodE.aP8xkUdzS6E0JL/iSPaHfZqGAQA4QV6');
INSERT INTO topic (id, text, title, view, picture)
VALUES (1, 'Je suis le test de macron', 'Macron président', 400,
        'http://localhost:8080/api/v1/filesController/files/macron.jpg');
INSERT INTO topic (id, text, title, view, picture)
VALUES (2, 'Bonjour Blo, blobloblo oui blobloblo', 'Soupe le 14 Mars', 230,
        'http://localhost:8080/api/v1/filesController/files/soap.jpg');
INSERT INTO comment (id, text, created_at, topic_id, user_id)
VALUES (1, 'je suis le premier commentaire', CAST('2022-03-15' AS TIMESTAMP), 1, 1);
INSERT INTO comment (id, text, created_at, topic_id, user_id)
VALUES (2, 'je suis le second commentaire', CAST('2022-03-15' AS TIMESTAMP), 1, 2);
INSERT INTO comment (id, text, created_at, topic_id, user_id)
VALUES (3, 'je suis le troisème commentaire', CAST('2022-03-15' AS TIMESTAMP), 2, 1);
INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (1, 'je suis la premiere reponse de commentaire', CAST('2022-03-15' AS TIMESTAMP), 1, 1);
INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (2, 'je suis la seconde reponse de ce commentaire', CAST('2022-03-15' AS TIMESTAMP), 1, 2);
INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (3, 'je suis cool', CAST('2022-03-15' AS TIMESTAMP), 2, 1);
INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (4, 'je suis content', CAST('2022-03-15' AS TIMESTAMP), 2, 2);
INSERT INTO family_tag (id, name_en, name_fr)
VALUES (1, 'Relation', 'Relation');
INSERT INTO family_tag (id, name_en, name_fr)
VALUES (2, 'Health', 'Santé');
INSERT INTO family_tag (id, name_en, name_fr)
VALUES (3, 'Social security', 'Sécurité sociale');
INSERT INTO family_tag (id, name_en, name_fr)
VALUES (4, 'Ecology and solidarity', 'Ecologie et sécurité');
INSERT INTO family_tag (id, name_en, name_fr)
VALUES (5, 'Fight against poverty', 'Lutte contre la pauvreté');
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (1, 'Childhood', 'Enfance', 1);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (2, 'Family', 'Famille', 1);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (3, 'Seniors', 'Personnes agées', 1);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (4, 'Care', 'Soins', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (5, 'Medical professions', 'Professions médicales', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (6, 'Addiction', 'Toxicomanie', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (7, 'Health innovation', 'Innovation santé', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (8, 'Social security organization', 'Organisme sécurtié social', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (9, 'Complementary organization', 'Organisme complémentaire', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (10, 'Old age pension', 'Assurance vieillesse', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (11, 'Family benefits', 'Prestations familiales', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (12, 'Health and maternity insurance', 'Assurance maladie et maternité', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (13, 'Work accident and occupational disease', 'Accident du travail et maladie professionnelles', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (14, 'Economic integration', 'Insertion économique', 5);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (15, 'Social innovation', 'Innovation sociale', 5);
INSERT INTO tag (id, name_en, name_fr, family_tag_id)
VALUES (16, 'Fight against social exclusion', 'Lutte contre l exclusions sociale', 5);