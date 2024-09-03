CREATE TABLE IF NOT EXISTS Client(

    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    photo VARCHAR(255) NOT NULL,
    version INT,
    PRIMARY KEY(id)

)