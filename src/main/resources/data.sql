INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_SUPERADMIN');
INSERT INTO users (id, user_name, email, birth_date, password) VALUES (1, 'userTest', 'usertest@gmail.com', CAST('1909-09-10' AS DATE), '$2a$10$nEytsdN4Zk/cmbfA6rodE.aP8xkUdzS6E0JL/iSPaHfZqGAQA4QV6');
INSERT INTO users (id, user_name, email, birth_date, password) VALUES (2, 'userTest2', 'usertest2@gmail.com', CAST('2000-10-10' AS DATE), '$2a$10$nEytsdN4Zk/cmbfA6rodE.aP8xkUdzS6E0JL/iSPaHfZqGAQA4QV6');
INSERT INTO topic (id, text, title, view, picture, user_id) VALUES (1,'Je suis le test de macron', 'Macron président', 400, 'http://localhost:8080/api/v1/filesController/files/macron.jpg', 1);
INSERT INTO topic (id, text, title, view, picture, type, user_id) VALUES (2, 'Bonjour Blo, blobloblo oui blobloblo', 'Soupe le 14 Mars', 230,'http://localhost:8080/api/v1/filesController/files/soap.jpg', 'Partagées', 2 );
INSERT INTO comment (id, text, created_at, topic_id, user_id) VALUES (1, 'je suis le premier commentaire', CAST('2022-03-15' AS DATE), 1, 1);
INSERT INTO comment (id, text, created_at, topic_id, user_id) VALUES (2, 'je suis le second commentaire', CAST('2022-03-15' AS DATE), 2, 1);
INSERT INTO family_tag (id, name_en, name_fr) VALUES (1, 'Relation', 'Relation');
INSERT INTO family_tag (id, name_en, name_fr) VALUES (2, 'Health', 'Santé');
INSERT INTO family_tag (id, name_en, name_fr) VALUES (3, 'Social security', 'sécurité sociale');
INSERT INTO family_tag (id, name_en, name_fr) VALUES (4, 'Ecology and solidarity', 'Ecologie et sécurité');
INSERT INTO family_tag (id, name_en, name_fr) VALUES (5, 'Fight against poverty', 'Lutte contre la pauvreté');
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (1, 'Family', 'Famille', 1);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (2, 'Childhood', 'Enfance', 1);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (3, 'Family', 'Famille', 1);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (4, 'seniors', 'Personnes agées', 1);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (5, 'Care', 'Soins', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (6, 'Medical professions', 'Professions médicales', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (7, 'Addiction', 'Toxicomanie', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (8, 'Health innovation', 'Innovation santé', 2);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (9, 'Social security organization', 'Organisme sécurtié social', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (10, 'Complementary organization', 'Organisme complémentaire', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (11, 'Old age pension', 'Assurance vieillesse', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (12, 'Family benefits', 'Prestations familiales', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (13, 'Health and maternity insurance', 'Assurance maladie et maternité', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (14, 'Work accident and occupational disease', 'Accident du travail et maladie professionnelles', 3);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (15, 'Economic integration', 'Insertion économique', 5);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (16, 'Social innovation', 'Innovation sociale', 5);
INSERT INTO tag (id, name_en, name_fr, family_tag_id) VALUES (17, 'Fight against social exclusion', 'Lutte l exclusions sociale', 5);