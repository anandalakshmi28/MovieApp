CREATE DATABASE movie_booking;

CREATE TABLE movie (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    language VARCHAR(100),
    genre VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE theatre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(150) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE show (
    id BIGSERIAL PRIMARY KEY,
    movie_id BIGINT NOT NULL,
    theatre_id BIGINT NOT NULL,
    show_date DATE NOT NULL,
    show_time TIME NOT NULL,
    price NUMERIC(10,2) NOT NULL,

    CONSTRAINT fk_show_movie
        FOREIGN KEY (movie_id)
        REFERENCES movie(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_show_theatre
        FOREIGN KEY (theatre_id)
        REFERENCES theatre(id)
        ON DELETE CASCADE
);


CREATE TABLE seat (
    id BIGSERIAL PRIMARY KEY,
    seat_number VARCHAR(10) NOT NULL,
    show_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE',
    version INTEGER DEFAULT 0,

    CONSTRAINT fk_seat_show
        FOREIGN KEY (show_id)
        REFERENCES show(id)
        ON DELETE CASCADE,

    CONSTRAINT chk_seat_status
        CHECK (status IN ('AVAILABLE', 'BOOKED'))
);

CREATE TABLE booking (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    show_id BIGINT NOT NULL,
    total_amount NUMERIC(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_booking_show
        FOREIGN KEY (show_id)
        REFERENCES show(id)
        ON DELETE CASCADE,

    CONSTRAINT chk_booking_status
        CHECK (status IN ('CONFIRMED', 'CANCELLED'))
);

// Sample data
INSERT INTO movie (title, language, genre)
VALUES ('Inception', 'English', 'Sci-Fi');

INSERT INTO theatre (name, city)
VALUES ('PVR', 'Bangalore');

INSERT INTO show (movie_id, theatre_id, show_date, show_time, price)
VALUES (1, 1, '2026-03-10', '14:00:00', 250.00);

INSERT INTO movie (title, language, genre)
VALUES ('Inception', 'English', 'Sci-Fi');

INSERT INTO theatre (name, city)
VALUES ('INOX', 'Bangalore');

INSERT INTO show (movie_id, theatre_id, show_date, show_time, price)
VALUES (1, 2, '2026-03-10', '14:00:00', 350.00);

INSERT INTO movie (title, language, genre)
VALUES ('Inception', 'English', 'Sci-Fi');

INSERT INTO theatre (name, city)
VALUES ('PVR', 'Bangalore');

INSERT INTO show (movie_id, theatre_id, show_date, show_time, price)
VALUES (1, 1, '2026-03-10', '08:00:00', 250.00);

INSERT INTO seat (seat_number, show_id, status)
VALUES
('A1', 1, 'AVAILABLE'),
('A2', 1, 'AVAILABLE'),
('A3', 1, 'AVAILABLE'),
('A4', 1, 'AVAILABLE');



