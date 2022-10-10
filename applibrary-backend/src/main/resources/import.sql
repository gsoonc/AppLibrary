/* Populate book table */

INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Joyanes Aguilar', '123456789', 'Spanish', 'uribook', 'Prentice Hall', 'Programacion en C++');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Jim Rumbaugh', '123456789', 'English', 'uribook', 'Marcombo', 'Ingenieria del Software');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('C. J. Date', '123456789', 'Spanish', 'uribook', 'Prentice Hall', 'Introduccion a BD');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Alfredo Weitsenfeld', '123456789', 'Spanish', 'uribook', 'Mc Graw Hill', 'Ingenieria del software orientado a objetos');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Ivan Marsic', '123456789', 'English', 'uribook', 'Prentice Hall', 'Software Engineering');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Eric Armstrong', '123456789', 'English', 'uribook', 'Adison Wesley', 'The Java web service Tutorial');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Paul Monday', '123456789', 'English', 'uribook', 'Team Lead', 'Web Service Patterns: Java Edition');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Athman Bouguettaya', '123456789', 'English', 'uribook', 'Springer', 'Advanced web services');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Dieter Fensel', '123456789', 'English', 'uribook', 'Jhon Wiley and sons', 'TOWARDS THE SEMANTIC WEB Ontology-driven Knowledge Management');
INSERT INTO `applibrary`.`book` (`author`, `isbn`, `language`, `pdf_book`, `publisher`, `title`) VALUES ('Sunil Gulabani', '123456789', 'English', 'uribook', 'Pack Publishing', 'Developing RESTFUL web services with jersey');
/*ingresando dos user*/
INSERT INTO `applibrary`.`user` (`email`, `first_name`, `last_name`, `password`) VALUES ('evalencia@unc.edu.pe', 'edwin', 'valencia', '123456');
INSERT INTO `applibrary`.`user` (`email`, `first_name`, `last_name`, `password`) VALUES ('jhondoe@unc.edu.pe', 'jhon', 'doe', '123456');
/*ingresando una request*/
INSERT INTO `applibrary`.`bookrequest` (`request_time`, `response_time`, `status`, `book_id`, `user_id`) VALUES ('0', '0', '1', '9', '1');
/*Ingresando roles para USER y ADMIN*/
INSERT INTO `applibrary`.`role` (`name`) VALUES ('ROLE_USER');
INSERT INTO `applibrary`.`role` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `applibrary`.`user_roles` (`user_id`, `roleid`) VALUES ('1', '2');
INSERT INTO `applibrary`.`user_roles` (`user_id`, `roleid`) VALUES ('2', '1');