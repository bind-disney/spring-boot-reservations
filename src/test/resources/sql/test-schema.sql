CREATE SEQUENCE IF NOT EXISTS rooms_id_seq;
CREATE SEQUENCE IF NOT EXISTS guests_id_seq;
CREATE SEQUENCE IF NOT EXISTS reservations_id_seq;

CREATE TABLE IF NOT EXISTS rooms(
    id SERIAL NOT NULL DEFAULT rooms_id_seq.nextval PRIMARY KEY,
    "name" VARCHAR(16) NOT NULL,
    room_number CHAR(2) NOT NULL UNIQUE,
    bed_info CHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS guests(
    id SERIAL NOT NULL DEFAULT guests_id_seq.nextval PRIMARY KEY,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    country VARCHAR(32) NOT NULL,
    state VARCHAR(12),
    phone_number VARCHAR(24)
);

CREATE TABLE IF NOT EXISTS reservations(
    id SERIAL NOT NULL DEFAULT reservations_id_seq.nextval PRIMARY KEY,
    room_id INT NOT NULL REFERENCES rooms(id),
    guest_id INT NOT NULL REFERENCES guests(id),
    reservation_date DATE NOT NULL
);

CREATE INDEX IF NOT EXISTS fk_reservations_room_id ON reservations(room_id);
CREATE INDEX IF NOT EXISTS fk_reservations_guest_id ON reservations(room_id);
