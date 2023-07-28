create table if not exists groceryItem
(
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    calories INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    image INTEGER NOT NULL
);