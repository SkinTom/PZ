INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Yakov Fain, Anton Moiseev","978-83-283-5666-5","polski",2,551,"Helion","Angular - Programowanie z użyciem języka TypeScript");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Stefanie Stahl","978-83-8135-058-7","polski",1,320,"Otwarte","Jak myśleć o sobie dobrze? O sztuce akceptacji i życiu bez lęku");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Viktor E. Frankl","978-83-8143-356-3","polski",1,224,"Wydawnictwo Czarna Owca","Człowiek w poszukiwaniu sensu");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Melody Beattie","978-83-85594-58-1","polski",1,283,"Media Rodzina","Koniec współuzależnienia");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Peter A. Levine","978-83-8015-346-2","polski",1,208,"Terapia Traumy","Trauma i pamięć. Mózg i ciało w poszukiwaniu autentycznej przeszłości");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Joanna Miniszewska","978-83-8142-277-2","polski",1,275,"Wydawnictwo Uniwersytetu Łudzkiego","Bycie z chorobą. Przystowowanie do wybranych przewlekłuch chorób somatycznych z perspektywy psychologii pozytywnej i koncepcji poznawczych");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Bessel van der Kolk","978-83-8015-800-9","polski",1,496,"Wydawnictwo Czarna Owca","Strach ucieleśniony. Mózg, umysł i cało w terapii traumy");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Maciej Dębski, Anna Michalska","978-83-933855-2-2","polski",1,343,"Pomorskie Forum na Rzecz Wychodzenia z Bezdomności","Podręcznik streetworkera bezdomności");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Judtih Herman","978-83-8143-140-8","polski",1,367,"Wydawnictwo Czarna Owca","Trauma. Od przemocy domowej do terroru politycznego");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Krzysztof Gąsior, Mirosław Jamrożek","978-83-926435-5-5","polski",1,261,"Kaligraf","Zagrożona młodzież i rodzina w środowisku lokalnym");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Antoni Kępiński","83-200-0895-6","polski",1,340,"Państwowy Zakład Wydawnictw Lekarskich","Psychopatologia nerwic");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Elisabeth Kübler-Ross","8385594-68-X","polski",1,275,"Media Rodzina of Poznań","Rozmowy o śmierciu i umieraniu");
INSERT INTO item(author, isbn, language, number, page, publisher, title) VALUES ("Beata Maria Pawlik","978-83-7930-557-5","polski",1,240,"Difin","Bezdomność. Modele pracy socjalnej. Wsparcie Psychologiczne");

INSERT INTO user_role(role, description) VALUES ("ROLE_USER", "Użytkownik");
INSERT INTO user_role(role, description) VALUES ("ROLE_EMPLOYEE", "Pracownik");
INSERT INTO user_role(role, description) VALUES ("ROLE_ADMIN", "Administrator");

INSERT INTO user(first_name, last_name, date_of_birth, pesel, city, street, home_number, flat_number, postal_code, province, salary, email, password) VALUES ("Jan", "Nowak", "22-10-1994", "12312312312", "Kraków", "Mikołaja Kopernika", "12", "", "31-034", "Małopolskie", 4000.00, "jn@wp.pl", "{bcrypt}$2a$04$E9tJ6uxycePCX541gGL8YeCqn.cJaQp43rYmnL8.HcpD8hsCpkhDK");
INSERT INTO user_roles VALUES(1, 1);
INSERT INTO user_roles VALUES(1, 2);
INSERT INTO user_roles VALUES(1, 3);

INSERT INTO user(first_name, last_name, date_of_birth, pesel, city, street, home_number, flat_number, postal_code, province, salary, email, password) VALUES ("Adam", "Kowalski", "05-02-1980", "32312512312", "Warszawa", "Bajkowa", "3", "21", "04-861", "Mazowieckie", 6500.00, "ak@gmail.com", "{bcrypt}$2a$04$E9tJ6uxycePCX541gGL8YeCqn.cJaQp43rYmnL8.HcpD8hsCpkhDK");
INSERT INTO user_roles VALUES(2, 1);
INSERT INTO user_roles VALUES(2, 2);

INSERT INTO user(first_name, last_name, date_of_birth, pesel, city, street, home_number, flat_number, postal_code, province, salary, email, password) VALUES ("Wiktor", "Kot", "12-08-1991", "99912512312", "Warszawa", "Bajkowa", "7", "8", "04-861", "Mazowieckie", 0, "wk@wp.pl", "{bcrypt}$2a$04$E9tJ6uxycePCX541gGL8YeCqn.cJaQp43rYmnL8.HcpD8hsCpkhDK");
INSERT INTO user_roles VALUES(3, 1);

INSERT INTO user(first_name, last_name, date_of_birth, pesel, city, street, home_number, flat_number, postal_code, province, salary, email, password) VALUES ("Daniel", "Norman", "13-03-19946", "98750528661", "Wrocław", "Laskowa", "7", "", "17-372", "Dolnośląskie", 2499.00, "dn@wp.pl", "{bcrypt}$2a$04$E9tJ6uxycePCX541gGL8YeCqn.cJaQp43rYmnL8.HcpD8hsCpkhDK");
INSERT INTO user_roles VALUES(4, 1);
INSERT INTO user_roles VALUES(4, 2);
INSERT INTO user_roles VALUES(4, 3);

INSERT INTO user(first_name, last_name, date_of_birth, pesel, city, street, home_number, flat_number, postal_code, province, salary, email, password) VALUES ("Dariusz", "Kołolski", "01-01-2001", "12345678910", "Radom", "Radomska", "69", "8", "25-050", "Mazowieckie", 2890.50, "dk@gmail.pl", "{bcrypt}$2a$04$E9tJ6uxycePCX541gGL8YeCqn.cJaQp43rYmnL8.HcpD8hsCpkhDK");
INSERT INTO user_roles VALUES(5, 1);
INSERT INTO user_roles VALUES(5, 2);

INSERT INTO user(first_name, last_name, date_of_birth, pesel, city, street, home_number, flat_number, postal_code, province, salary, email, password) VALUES ("Pietroy", "Sikorsky", "05-02-1969", "09876543210", "Zabłocie", "Zielona", "4", "20", "25-171", "Podlaskie", 3000.00, "ps@gmail.pl", "{bcrypt}$2a$04$E9tJ6uxycePCX541gGL8YeCqn.cJaQp43rYmnL8.HcpD8hsCpkhDK");
INSERT INTO user_roles VALUES(6, 1);
INSERT INTO user_roles VALUES(6, 2);

INSERT INTO user(first_name, last_name, date_of_birth, pesel, city, street, home_number, flat_number, postal_code, province, salary, email, password) VALUES ("Adam", "Obrębowicz", "30-12-2002", "22222222222", "Białystok", "Szkolna", "1", "7", "66-888", "Podkarpackie", 2600.00, "ao@gmail.pl", "{bcrypt}$2a$04$E9tJ6uxycePCX541gGL8YeCqn.cJaQp43rYmnL8.HcpD8hsCpkhDK");
INSERT INTO user_roles VALUES(7, 1);
INSERT INTO user_roles VALUES(7, 2);