-- ############### ROLE ###############
INSERT INTO roles(name)
VALUES ('ROLE_USER');
INSERT INTO roles(name)
VALUES ('ROLE_MODERATOR');
INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');
INSERT INTO roles(name)
VALUES ('ROLE_SUPERADMIN');

-- ############### TOPIC ###############
INSERT INTO users (id, user_name, is_activated, email, age, password)
VALUES (1, 'userTest', true, 'usertest@gmail.com', 52, '$2a$10$nEytsdN4Zk/cmbfA6rodE.aP8xkUdzS6E0JL/iSPaHfZqGAQA4QV6');

INSERT INTO users (id, user_name, is_activated, email, age, password)
VALUES (2, 'userTest2', true, 'usertest2@gmail.com', 25, '$2a$10$nEytsdN4Zk/cmbfA6rodE.aP8xkUdzS6E0JL/iSPaHfZqGAQA4QV6');

INSERT INTO users (id, user_name, is_activated, email, age, password)
VALUES (3, 'userTest3', false, 'usertest3@gmail.com', 35, '$2a$10$nEytsdN4Zk/cmbfA6rodE.aP8xkUdzS6E0JL/iSPaHfZqGAQA4QV6');

-- ############### TOPIC ###############
INSERT INTO topic (id, title, text, picture, view, user_id, is_validated)
VALUES (1, 'Macron président',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla id ' ||
        'mattis lorem. Nam blandit nibh massa, feugiat sollicitudin tellus convallis sit amet. Duis in commodo odio. Nunc',
        'http://localhost:8080/api/v1/filesController/files/macron.jpg', 0, 1, true);

INSERT INTO topic (id, title, text, picture, view, user_id, is_validated)
VALUES (2, 'Soupe le 14 Mars',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla id ' ||
        'mattis lorem. Nam blandit nibh massa, feugiat sollicitudin tellus convallis sit amet. Duis in commodo odio. Nunc',
        'http://localhost:8080/api/v1/filesController/files/soap.jpg', 0, 2, true);

INSERT INTO topic (id, title, text, picture, view, user_id, is_validated)
VALUES (3, 'Danse',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla id ' ||
        'mattis lorem. Nam blandit nibh massa, feugiat sollicitudin tellus convallis sit amet. Duis in commodo odio. Nunc',
        'http://localhost:8080/api/v1/filesController/files/danse.jpg', 0, 2, true);

INSERT INTO topic (id, title, text, picture, view, user_id, is_validated)
VALUES (4, 'Cerveau',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla id ' ||
        'mattis lorem. Nam blandit nibh massa, feugiat sollicitudin tellus convallis sit amet. Duis in commodo odio. Nunc',
        'http://localhost:8080/api/v1/filesController/files/cerveau.jpeg', 0, 2, true);

INSERT INTO topic (id, title, text, picture, view, user_id, is_validated)
VALUES (5, 'Violon',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla id ' ||
        'mattis lorem. Nam blandit nibh massa, feugiat sollicitudin tellus convallis sit amet. Duis in commodo odio. Nunc',
        'http://localhost:8080/api/v1/filesController/files/violon.jpeg', 0, 1, true);

INSERT INTO topic (id, title, text, picture, view, user_id, is_validated)
VALUES (6, 'Bière',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla id ' ||
        'mattis lorem. Nam blandit nibh massa, feugiat sollicitudin tellus convallis sit amet. Duis in commodo odio. Nunc',
        'http://localhost:8080/api/v1/filesController/files/biere.jpeg', 0, 2, false);

-- ############### COMMENT ###############
INSERT INTO comment (id, text, created_at, topic_id, user_id)
VALUES (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla',
        CAST('2022-03-15' AS TIMESTAMP), 1, 1);

INSERT INTO comment (id, text, created_at, topic_id, user_id)
VALUES (2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla',
        CAST('2022-03-15' AS TIMESTAMP), 1, 2);

INSERT INTO comment (id, text, created_at, topic_id, user_id)
VALUES (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla',
        CAST('2022-03-15' AS TIMESTAMP), 2, 1);

-- ############### SUB_COMMENT ###############
INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla',
        CAST('2022-03-15' AS TIMESTAMP), 1, 1);

INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla',
        CAST('2022-03-15' AS TIMESTAMP), 1, 2);

INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla',
        CAST('2022-03-15' AS TIMESTAMP), 2, 1);

INSERT INTO response_comment (id, text, created_at, comment_id, user_id)
VALUES (4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper et dolor vitae ultrices. Nulla',
        CAST('2022-03-15' AS TIMESTAMP), 2, 2);

-- ############### FAMILY_TAG ###############
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

-- ############### TAG ###############
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
