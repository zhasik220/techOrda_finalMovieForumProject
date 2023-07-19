INSERT INTO t_permission (role)
VALUES ('ROLE_ADMIN'),
       ('ROLE_MODERATOR'),
       ('ROLE_USER');


INSERT INTO t_user (email, password, full_name, is_blocked)
    VALUE
    ('zhasik220@gmail.com',
     '$2y$10$3rbeYn4LvwNZIR/ObLHhbutnMDt7IqxWo/1cEPh68oTA0UT.JvBgm',
     'Tleubay Zhasulan', false),
    ('arnibek@gmail.com',
     '$2a$10$KS7N9j4pveFLgPk8uPQLeudey13OWGbA3WPMPpKJvcJYcxj5am6ma',
     'Nusupbekov Arnibek ', false),
    ('madara@gmail.com',
     '$2a$10$4iXoyIfJrssqj98nuXzCfOhjAIxaUETTiAbDpktsp4jzNVdi9oyza',
     'Ayan Serikov', false),
    ('aruNur@gmail.com',
     '$2a$10$rIPAX3jfB9O5qDb3q5u2OeMScF9ZhLFeGx4YSqx.ovM1ussHTlzg2',
     'Nurzhan Aruzhan', false),
    ('ansarik@gmail.com',
     '$2a$10$tberUnS2Rx9Nyj78cgh.reU9Kn2K4A.Vit2D0Smmxbpssom0ivF62',
     'Ansar Berikov', false),
    ('almas199@gmail.com',
     '$2a$10$dS1AIc.f7rC2V3MXI.OevOtvcX3Mivovoz4khXdFfIbb1bD1s8Ezi',
     'Almas Bekzatov', false),
    ('aigerim210@gmail.com',
     '$2a$10$.M8jXWNJabSWDLFH6Z2Y1uvgC.MTytKkSEmvzZQ43DQgbZI8KdXZa',
     'Aigerim Nurzhanova', false),
    ('nurik@gmail.com',
     '$2a$10$Qj2KNjEe.uLzzfvWEoD4fen9CZmsWu54f0/OVCYrM6jeyebEwX7Ay',
     'Nurlan Qazhim', false),
    ('gulnaz@gmail.com',
     '$2a$10$g6wI7kiTb0Icwc68/zpTBeIHa/CZL.2VdLOcTXdUyR1gfWI7MWAuO',
     'Gulnaz Abdilda', false),
    ('askar@gmail.com',
     '$2a$10$W/N5jOFRZCSvAkjsH1B4OOMWjJ4IoaGhJPGQWPpAn0BFdYHL3juJi',
     'Askar Meirbek', false),
    ('dina@gmail.com',
     '$2a$10$uM1B/tEjxfpMkZ7KIAphtu3cPFgZIhW.gC0O5wXT0HpIe5gj5c3aO',
     'Dina Saule', false),
    ('bakhyt@gmail.com',
     '$2a$10$RJn7MxWiPcWnNprdowW15.x3GXXEUzi2HFUSExkUkg/7sbSx1Hb5C',
     'Bakhyt Adil', false);


INSERT INTO t_user_permissions (user_id, permissions_id)
VALUES (1, 1),  -- Admin User
       (2, 2),  -- Moderator User
       (3, 3),  -- Uchiha Madara
       (4, 3),  -- Nurzhan Aruzhan
       (5, 3),  -- Ansar Berikov
       (6, 3),  -- Almas Bekzatov
       (7, 3),  -- Aigerim Nurzhanova
       (8, 3),  -- Nurlan Qazhim
       (9, 3),  -- Gulnaz Abdilda
       (10, 3), -- Askar Meirbek
       (11, 3), -- Dina Saule
       (12, 3); -- Bakhyt Adil


INSERT INTO t_genre (name)
VALUES ('Action'),
       ('Comedy'),
       ('Drama'),
       ('Thriller'),
       ('Romance'),
       ('Horror'),
       ('Sci-Fi'),
       ('Fantasy'),
       ('Adventure'),
       ('Mystery'),
       ('Animation'),
       ('Crime'),
       ('Family'),
       ('History'),
       ('Documentary');



INSERT INTO t_actor (name, surname, age)
VALUES ('Tom', 'Hanks', 65),
       ('Leonardo', 'DiCaprio', 47),
       ('Morgan', 'Freeman', 85),
       ('Tim', 'Robbins', 64),
       ('Marlon', 'Brando', 90),
       ('Al', 'Pacino', 83),
       ('John', 'Travolta', 69),
       ('Samuel L.', 'Jackson', 74),
       ('Christian', 'Bale', 49),
       ('Heath', 'Ledger', 44),
       ('Joseph', 'Gordon-Levitt', 42),
       ('Brad', 'Pitt', 58),
       ('Denzel', 'Washington', 66),
       ('Robert', 'Downey Jr.', 56),
       ('Scarlett', 'Johansson', 37),
       ('Chris', 'Evans', 40),
       ('Gal', 'Gadot', 36),
       ('Chris', 'Hemsworth', 38),
       ('Daniel', 'Radcliffe', 32),
       ('Rupert', 'Grint', 33),
       ('Johnny', 'Depp', 58),
       ('Meryl', 'Streep', 72),
       ('Jennifer', 'Lawrence', 31),
       ('Natalie', 'Portman', 40),
       ('Will', 'Smith', 53),
       ('Emma', 'Watson', 31),
       ('Denzel', 'Washington', 67),
       ('Angelina', 'Jolie', 46),
       ('Ryan', 'Reynolds', 45),
       ('Charlize', 'Theron', 45),
       ('Omar', 'Sy', 44),
       ('François', 'Cluzet', 66),
       ('Matthew', 'McConaughey', 52),
       ('Anne', 'Hathaway', 39),
       ('Jessica', 'Chastain', 45),
       ('Tom', 'Hardy', 44),
       ('Nicholas', 'Hoult', 32);



INSERT INTO t_country (name)
VALUES ('USA'),
       ('United Kingdom'),
       ('Canada'),
       ('Australia'),
       ('France'),
       ('Germany'),
       ('Spain'),
       ('Italy'),
       ('Japan'),
       ('South Korea'),
       ('India'),
       ('China'),
       ('Brazil'),
       ('Argentina'),
       ('Mexico');


INSERT INTO t_producer (name, surname, age)
VALUES ('Frank', 'Darabont', 62),
       ('Francis', 'Ford', 82),
       ('Quentin', 'Tarantino', 58),
       ('Christopher', 'Nolan', 51),
       ('Olivier', 'Nakache', 48),
       ('George', 'Miller', 78);



INSERT INTO t_movie (movie_name, year, description, country_id, duration_in_minutes, producer_id)
VALUES ('The Shawshank Redemption', 1994,
        'Accountant Andy Dufresne is accused of killing his wife and her lover. Once in a prison called Shawshank, he is faced with cruelty and lawlessness that reigns on both sides of the bars. Everyone who enters these walls becomes their slave for the rest of their lives. But Andy, who has a lively mind and a kind soul, finds an approach to both prisoners and guards, seeking their special disposition.',
        1, 142, 1),
       ('The Godfather', 1972,
        'Crime drama directed by Francis Ford Coppola based on the novel of the same name by Mario Puzo. The film stars Marlon Brando, Al Pacino, Robert Duvall, John Cazale and Diane Keaton.
        The action of the picture takes place in America in 1945-1955. In the house of mafia boss Vito Corleone (Marlon Brando), it''s a celebration - his daughter Connie (Talia Shire) marries Carlo Rizzi (Giani Russo). Among the invited guests, many want to see the "godfather" Corleone, knowing that in this joyful moment he cannot refuse a single request. Together with personal lawyer Tom Hagen (Robert Duvall), Vito listens to his petitioners and makes important decisions.',
        1, 175, 2),
       ('Pulp Fiction', 1994,
        'Two gangsters Vincent Vega and Jules Winfield have philosophical conversations in between showdowns and solving problems with the debtors of crime boss Marcellus Wallace.
        In the first story, Vincent spends an unforgettable evening with Marsellus'' wife Mia. The second tells about the boxer Butch Coolidge, bought by Wallace to pass the fight. In the third story, Vincent and Jules accidentally get into trouble.',
        1, 154, 3),
       ('The Dark Knight', 2008,
        'Batman is upping the ante in his war on crime. With the help of Lieutenant Jim Gordon and prosecutor Harvey Dent, he intends to clean up the streets of Gotham from crime. The collaboration proves effective, but they soon find themselves in the midst of chaos unleashed by a rising criminal mastermind known to the terrified townspeople as the Joker.',
        1, 152, 4),
       ('Inception', 2010, 'Cobb is a talented thief, the best of the best in the dangerous art of extraction: he steals valuable secrets from the depths of the subconscious during sleep, when the human mind is at its most vulnerable. Cobb''s rare abilities have made him a valuable player in the treacherous world of industrial espionage, but they''ve also made him a fugitive and robbed of everything he''s ever loved.
        And now Cobb has a chance to correct mistakes. His last act can bring everything back, but for this he needs to do the impossible - initiation. Instead of a perfect theft, Cobb and his team of specialists will have to pull off the opposite. Now their task is not to steal the idea, but to implement it. If they succeed, it will be the perfect crime.',
        1, 148, 4),
       ('The Intouchables', 2011,
        '1+1 is an incredibly touching and inspiring story about friendship, love and overcoming hardships. Director Olivier Nakache and Eric Toledano created a real masterpiece that could win the hearts of millions of viewers around the world.
        The film tells about two completely different people - a wealthy aristocrat Philip and his new personal assistant, a paralyzed poor man named Driss. Philip was injured in an accident and completely paralyzed, while Driss was imprisoned and never had a chance to work in such a high position. But despite all the differences, they become best friends and mutually help each other.',
        7, 112, 5),
       ('Interstellar', 2014,
        'Accountant Andy Dufresne is accused of killing his wife and her lover. Once in a prison called Shawshank, he is faced with cruelty and lawlessness that reigns on both sides of the bars. Everyone who enters these walls becomes their slave for the rest of their lives. But Andy, who has a lively mind and a kind soul, finds an approach to both prisoners and guards, seeking their special disposition.',
        1, 169, 4),
       ('Mad Max: Fury Road', 2015,
        'Haunted by the ghosts of a troubled past, Max is convinced that the best way to survive is to wander alone. Despite this, he joins the rebels running across the desert on a combat wagon, led by the desperate Furiosa.
        They escaped from the Citadel, suffering from the tyranny of the Immortal Joe, and took something very valuable from him. The enraged dictator throws all his strength into the pursuit of the rebels, stepping on the warpath - the road of rage.',
        1, 120, 6);


-- Связи между фильмом "The Shawshank Redemption" и актерами (movie_id = 1)
INSERT INTO t_movie_actors (movie_id, actors_id)
VALUES (1, 3),  -- 1 - ID фильма "The Shawshank Redemption", 3 - ID актера Morgan Freeman
       (1, 4),-- 1 - ID фильма "The Shawshank Redemption", 4 - ID актера Tim Robbins
       (2, 5),  -- 2 - ID фильма "The Godfather", 5 - ID актера Marlon Brando
       (2, 6),  -- 2 - ID фильма "The Godfather", 6 - ID актера Al Pacino
       (3, 7),  -- 3 - ID фильма "Pulp Fiction", 7 - ID актера John Travolta
       (3, 8),  -- 3 - ID фильма "Pulp Fiction", 8 - ID актера Samuel L. Jackson
       (4, 9),  -- 4 - ID фильма "The Dark Knight", 9 - ID актера Christian Bale
       (4, 10), -- 4 - ID фильма "The Dark Knight", 10 - ID актера Heath Ledger
       (5, 2),  -- 5 - ID фильма "Inception", 2 - ID актера Leonardo DiCaprio
       (5, 11), -- 5 - ID фильма "Inception", 11 - ID актера Joseph Gordon-Levitt
       (6, 31), -- 6 - ID фильма "The Intouchables", 31 - ID актера Omar Sy
       (6, 32), -- 6 - ID фильма "The Intouchables", 32 - ID актера François Cluzet
       (7, 33), -- 7 - ID фильма "The Interstellar", 33 - ID актера Matthew Hathaway
       (7, 34), -- 7 - ID фильма "The Interstellar", 34 - ID актера Anne Hathaway
       (7, 35), -- 7 - ID фильма "The Interstellar", 35 - ID актера Jessica Chastain
       (8, 36), -- 7 - ID фильма "Mad Max: Fury Road", 36 - ID актера Matthew Hathaway
       (8, 37), -- 7 - ID фильма "Mad Max: Fury Road", 37 - ID актера Anne Hathaway
       (8, 30); -- 7 - ID фильма "Mad Max: Fury Road", 30 - ID актера Jessica Chastain


INSERT INTO t_movie_genres (movie_id, genres_id)
VALUES (1, 3),  -- 1 - ID фильма "The Shawshank Redemption", 3 - ID жанра "Drama"
       (1, 12),-- 1 - ID фильма "The Shawshank Redemption", 12 - ID жанра "Crime"
       (2, 12), -- 2 - ID фильма "The Godfather", 12 - ID жанра "Crime"
       (2, 3),-- 2 - ID фильма "The Godfather", 3 - ID жанра "Drama"
       (3, 12), -- 3 - ID фильма "Pulp Fiction", 12 - ID жанра "Crime"
       (3, 3),  -- 3 - ID фильма "Pulp Fiction", 3 - ID жанра "Drama"
       (3, 4),-- 3 - ID фильма "Pulp Fiction", 4 - ID жанра "Thriller"
       (4, 1),  -- 4 - ID фильма "The Dark Knight", 1 - ID жанра "Action"
       (4, 12), -- 4 - ID фильма "The Dark Knight", 12 - ID жанра "Crime"
       (4, 3),-- 4 - ID фильма "The Dark Knight", 3 - ID жанра "Drama"
       (5, 1),  -- 5 - ID фильма "Inception", 1 - ID жанра "Action"
       (5, 9),  -- 5 - ID фильма "Inception", 9 - ID жанра "Adventure"
       (5, 7),-- 5 - ID фильма "Inception", 7 - ID жанра "Sci-Fi"
       (6, 15), -- 6 - ID фильма "The Intouchables", 8 - ID жанра "Documentary"
       (6, 2),  -- 6 - ID фильма "The Intouchables", 2 - ID жанра "Comedy"
       (7, 7),  -- Interstellar: 7 - ID фильма, 7 - ID жанра "Sci-Fi"
       (7, 8),  -- Interstellar: 7 - ID фильма, 8 - ID жанра "Fantasy"
       (7, 9),  -- Interstellar: 7 - ID фильма, 9 - ID жанра "Приключения"
       (8, 1),  -- Mad Max: Fury Road: 8 - ID фильма, 1 - ID жанра "Action"
       (8, 7),  -- Mad Max: Fury Road: 8 - ID фильма, 7 - ID жанра "Sci-Fi"
       (8, 9);
-- Mad Max: Fury Road: 8 - ID фильма, 9 - ID жанра "Adventure"


-- Комментарии для фильма "The Shawshank Redemption" (movie_id = 1)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('Great movie, highly recommended!', NOW(), 3, 1, false),
       ('One of my all-time favorites.', NOW(), 4, 1, false),
       ('The ending left me speechless.', NOW(), 5, 1, false),
       ('A masterpiece in storytelling!', NOW(), 2, 1, false),
       ('Incredible performances by the cast.', NOW(), 1, 1, false),
       ('I couldn\'t stop watching it!', NOW(), 6, 1, false),
       ('Such an emotional rollercoaster!', NOW(), 7, 1, false);

-- Комментарии для фильма "The Godfather" (movie_id = 2)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('Classic film that never gets old.', NOW(), 2, 2, false),
       ('Marlon Brando\'s performance was legendary.', NOW(), 5, 2, false),
       ('One of the greatest movies ever made.', NOW(), 4, 2, false),
       ('The Godfather changed cinema forever.', NOW(), 10, 2, false),
       ('An epic tale of power and family.', NOW(), 2, 2, false),
       ('I could watch this movie over and over.', NOW(), 9, 2, false),
       ('The Corleone family is iconic.', NOW(), 4, 2, false);

-- Комментарии для фильма "Pulp Fiction" (movie_id = 3)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('Quentin Tarantino at his best!', NOW(), 3, 3, false),
       ('I love the non-linear storytelling.', NOW(), 4, 3, false),
       ('Samuel L. Jackson is brilliant.', NOW(), 7, 3, false),
       ('This movie is so cool and stylish.', NOW(), 5, 3, false),
       ('The soundtrack is fantastic.', NOW(), 8, 3, false),
       ('A modern-day masterpiece.', NOW(), 11, 3, false),
       ('I can\'t get enough of this film.', NOW(), 10, 3, false);

-- Комментарии для фильма "The Dark Knight" (movie_id = 4)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('Heath Ledger\'s Joker is unforgettable.', NOW(), 1, 4, false),
       ('Christian Bale is the perfect Batman.', NOW(), 2, 4, false),
       ('The action sequences are mind-blowing.', NOW(), 3, 4, false),
       ('A superhero movie like no other.', NOW(), 8, 4, false),
       ('I\'m still in awe of this film.', NOW(), 10, 4, false),
       ('Christopher Nolan\'s direction is top-notch.', NOW(), 7, 4, false),
       ('The Dark Knight is a cinematic triumph.', NOW(), 8, 4, false);

-- Комментарии для фильма "Inception" (movie_id = 5)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('Mind-bending and thought-provoking.', NOW(), 10, 5, false),
       ('Leonardo DiCaprio is amazing as always.', NOW(), 3, 5, false),
       ('The visual effects are mind-blowing.', NOW(), 4, 5, false),
       ('I was on the edge of my seat the whole time.', NOW(), 2, 5, false),
       ('Inception is a masterpiece of sci-fi.', NOW(), 3, 5, false),
       ('One of the most original films I\'ve seen.', NOW(), 4, 5, false),
       ('It keeps you guessing till the end.', NOW(), 5, 5, false);

-- Комментарии для фильма "The Intouchables" (movie_id = 6)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('Heartwarming and beautiful.', NOW(), 1, 6, false),
       ('The chemistry between the actors is fantastic.', NOW(), 2, 6, false),
       ('An emotional journey with laughter and tears.', NOW(), 3, 6, false),
       ('The performances are top-notch.', NOW(), 4, 6, false),
       ('The Intouchables is a must-watch!', NOW(), 5, 6, false),
       ('I fell in love with the characters.', NOW(), 6, 6, false),
       ('A story that stays with you.', NOW(), 7, 6, false);


-- Comments for the movie "Interstellar" (movie_id = 7)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('A mind-blowing sci-fi epic with stunning visual effects!', NOW(), 3, 7, false),
       ('An enthralling journey through space and time.', NOW(), 4, 7, false),
       ('Excellent performances, especially by Matthew McConaughey and Anne Hathaway.', NOW(), 5, 7, false),
       ('The plot is filled with unexpected twists and emotional moments.', NOW(), 2, 7, false),
       ('This film leaves plenty of room for contemplation.', NOW(), 1, 7, false),
       ('One of the most impressive sci-fi movies I have ever seen.', NOW(), 6, 7, false),
       ('Interstellar`s exploration of scientific concepts and human emotions is truly thought-provoking.', NOW(), 7, 7,
        false),
       ('I was on the edge of my seat throughout the entire film!', NOW(), 8, 7, false),
       ('Christopher Nolan`s direction elevates the movie to a cinematic masterpiece.', NOW(), 9, 7, false),
       ('Interstellar is a mesmerizing and intellectually stimulating experience.', NOW(), 10, 7, false);


-- Comments for the movie "Mad Max: Fury Road" (movie_id = 8)
INSERT INTO t_comment (text, time, user_id, movie_id, edited)
VALUES ('A thrilling action-packed spectacle with captivating races and relentless action!', NOW(), 3, 8, false),
       ('The original and dark setting keeps you hooked.', NOW(), 4, 8, false),
       ('Tom Hardy nails the role of Mad Max.', NOW(), 5, 8, false),
       ('Stunning special effects and the post-apocalyptic world are impressive.', NOW(), 2, 8, false),
       ('This film literally keeps you on the edge of your seat.', NOW(), 1, 8, false),
       ('Mad Max: Fury Road is a true cinematic masterpiece.', NOW(), 6, 8, false),
       ('The film`s relentless energy and non-stop action are its standout features.', NOW(), 7, 8, false),
       ('The dystopian world-building adds depth to the thrilling storyline.', NOW(), 8, 8, false),
       ('George Miller`s direction brings a unique vision to the action genre.', NOW(), 9, 8, false),
       ('Mad Max: Fury Road is an adrenaline-pumping ride from start to finish.', NOW(), 10, 8, false);

