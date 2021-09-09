CREATE TABLE NEWS_SUBS_FREQ(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(200) NOT NULL,
	DESCRIPTION VARCHAR(200) NOT NULL);
INSERT INTO NEWS_SUBS_FREQ (NAME, DESCRIPTION) VALUES
('Weekly', 'Subscribed to a newsletter to receive weekly news.'),
('Monthly', 'Subscribed to a newsletter to receive monthly news.'),
('Quarterly', 'Subscribed to a newsletter to receive quarterly news.');


CREATE TABLE NEWS_SUBS_TECH(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(200) NOT NULL,
	DESCRIPTION VARCHAR(200) NOT NULL);
INSERT INTO NEWS_SUBS_TECH (NAME, DESCRIPTION) VALUES
('Javascript', 'Javascript programming tech'),
('Java', 'Java programming tech'),
('.NET', '.NET programming tech'),
('Angular', 'Angular programming tech'),
('MySQL', 'MySQL database tech'),
('Mongo', 'Mongo database tech');


CREATE TABLE NEWS_SUBS(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(200) NOT NULL,
	SURNAME VARCHAR(200) NOT NULL,
	BIRTHDAY DATE,
	ID_NEWS_SUBS_FREQ INT NOT NULL,
	FOREIGN KEY(ID_NEWS_SUBS_FREQ) REFERENCES NEWS_SUBS_FREQ(ID));
INSERT INTO NEWS_SUBS (NAME, SURNAME, BIRTHDAY, ID_NEWS_SUBS_FREQ) VALUES
('Juan Manuel', 'Fernández', SYSDATE(), 1),
('Marta', 'Díaz', SYSDATE(), 2),
('Antonio', 'González', SYSDATE(), 3);


CREATE TABLE NEWS_SUBS_TAGS(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ID_NEWS_SUBS INT NOT NULL,
	FOREIGN KEY(ID_NEWS_SUBS) REFERENCES NEWS_SUBS(ID),
	ID_NEWS_SUBS_TECH INT NOT NULL,
	FOREIGN KEY(ID_NEWS_SUBS_TECH) REFERENCES NEWS_SUBS_TECH(ID),
	UNIQUE(ID_NEWS_SUBS, ID_NEWS_SUBS_TECH));
INSERT INTO NEWS_SUBS_TAGS (ID_NEWS_SUBS, ID_NEWS_SUBS_TECH) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 1),
(3, 2),
(3, 4),
(3, 6);