INSERT INTO AUTHOR (ID, BIO, AUTHOR_NAME) VALUES (1, 'Swedish journalist and writer', 'Karl Stig-Erland Larsson');
INSERT INTO AUTHOR (ID, BIO, AUTHOR_NAME) VALUES (2, 'British novelist and screenwriter', 'Joanne Rowling');
INSERT INTO AUTHOR (ID, BIO, AUTHOR_NAME) VALUES (3, 'Marin Preda a fost un scriitor român postbelic și directorul editurii "Cartea Românească"', 'Marin Preda');

INSERT INTO BOOK (ID, TITLE, SHORT_DESCRIPTION, AUTHOR_ID) VALUES (1, 'The Girl with the Dragon Tattoo', 'a psychological thriller novel', 1);
INSERT INTO BOOK (ID, TITLE, SHORT_DESCRIPTION, AUTHOR_ID) VALUES (2, 'The Casual Vacancy', 'class, politics, and social issues such as drugs, prostitution and rape', 2);
INSERT INTO BOOK (ID, TITLE, SHORT_DESCRIPTION, AUTHOR_ID) VALUES (3, 'Cormoran Strike', 'the many cases of private investigator Strike and his assistant Robin Ellacott', 2);
INSERT INTO BOOK (ID, TITLE, SHORT_DESCRIPTION, AUTHOR_ID) VALUES (4, 'Părlitu''', 'o schiță', 3);
INSERT INTO BOOK (ID, TITLE, SHORT_DESCRIPTION, AUTHOR_ID) VALUES (5, 'Moromeții', 'o narațiune perfect obiectivată', 3);
INSERT INTO BOOK (ID, TITLE, SHORT_DESCRIPTION, AUTHOR_ID) VALUES (6, 'Viața ca o pradă', 'cristalizarea conștiinței unui artist', 3);

INSERT INTO LIBRARY (ID, NAME) VALUES (1, 'DevPlant Library');

INSERT INTO LIBRARY_STOCKS (LIBRARY_ID, STOCKS, STOCKS_KEY) VALUES (1, 10, 1);
INSERT INTO LIBRARY_STOCKS (LIBRARY_ID, STOCKS, STOCKS_KEY) VALUES (1, 10, 2);
INSERT INTO LIBRARY_STOCKS (LIBRARY_ID, STOCKS, STOCKS_KEY) VALUES (1, 10, 3);
INSERT INTO LIBRARY_STOCKS (LIBRARY_ID, STOCKS, STOCKS_KEY) VALUES (1, 10, 4);
INSERT INTO LIBRARY_STOCKS (LIBRARY_ID, STOCKS, STOCKS_KEY) VALUES (1, 10, 5);
INSERT INTO LIBRARY_STOCKS (LIBRARY_ID, STOCKS, STOCKS_KEY) VALUES (1, 10, 6);

INSERT INTO LENDING (ID, CLIENT_NAME, DUE_RETURN_DATE, LENDING_TIME, BOOK_ID, LIBRARY_ID) VALUES (2, 'Gogu', '2017-01-01', '2017-01-01 00:00:00', 5, 1);
