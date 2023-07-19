CREATE TABLE t_permission (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              role VARCHAR(255) NOT NULL
);


CREATE TABLE t_user (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        full_name VARCHAR(255),
                        is_blocked TINYINT(1) NOT NULL DEFAULT 0
);

CREATE TABLE t_producer (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            surname VARCHAR(255) NOT NULL,
                            age INT
);



CREATE TABLE t_genre (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE t_country (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL
);


CREATE TABLE t_actor (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         surname VARCHAR(255) NOT NULL,
                         age INT
);


CREATE TABLE t_movie (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         movie_name VARCHAR(255) NOT NULL,
                         year INT,
                         description TEXT,
                         country_id INT,
                         duration_in_minutes INT,
                         producer_id INT,
                         FOREIGN KEY (country_id) REFERENCES t_country (id),
                         FOREIGN KEY (producer_id) REFERENCES t_producer (id)
);



CREATE TABLE t_comment (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           text TEXT,
                           time DATETIME,
                           user_id INT,
                           movie_id INT,
                           edited TINYINT(1) NOT NULL DEFAULT 0,
                           FOREIGN KEY (user_id) REFERENCES t_user (id),
                           FOREIGN KEY (movie_id) REFERENCES t_movie (id)
);


CREATE TABLE t_user_permissions (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    user_id INT,
                                    permissions_id INT,
                                    FOREIGN KEY (user_id) REFERENCES t_user (id),
                                    FOREIGN KEY (permissions_id) REFERENCES t_permission (id)
);


CREATE TABLE t_movie_actors (
                                movie_id INT,
                                actors_id INT,
                                PRIMARY KEY (movie_id, actors_id),
                                FOREIGN KEY (movie_id) REFERENCES t_movie (id),
                                FOREIGN KEY (actors_id) REFERENCES t_actor (id)
);

-- Создание таблицы t_movie_genres
CREATE TABLE t_movie_genres (
                                movie_id INT,
                                genres_id INT,
                                PRIMARY KEY (movie_id, genres_id),
                                FOREIGN KEY (movie_id) REFERENCES t_movie (id),
                                FOREIGN KEY (genres_id) REFERENCES t_genre (id)
);