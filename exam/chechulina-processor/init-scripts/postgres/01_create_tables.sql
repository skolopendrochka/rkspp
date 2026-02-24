CREATE TABLE IF NOT EXISTS сырые_события_студентов (
    идентификатор SERIAL PRIMARY KEY,
    фамилия VARCHAR(255) NOT NULL,
    имя VARCHAR(255) NOT NULL,
    группа VARCHAR(50),
    дата_события TIMESTAMP NOT NULL,
    время_получения TIMESTAMP NOT NULL
);