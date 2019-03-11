DROP TABLE IF EXISTS user_candidate;
CREATE TABLE user_candidate (
    id INT AUTO_INCREMENT,
    login VARCHAR(45) NOT NULL,
    password VARCHAR(30) NOT NULL,
    confirm_code VARCHAR(255) NOT NULL ,
    email VARCHAR(45) NOT NULL,
    phone VARCHAR(45) NOT NULL,
    registration_date DATE NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id INT AUTO_INCREMENT,
    login VARCHAR(45) NOT NULL,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(45) NOT NULL,
    phone VARCHAR(45) NOT NULL,
    registration_date DATE NOT NULL,
    status SMALLINT NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    id INT AUTO_INCREMENT,
    sum double NOT NULL,
    customer_first_name VARCHAR(255) NOT NULL,
    customer_last_name VARCHAR(255) NOT NULL,
    customer_address VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    user_id INT,
    comment TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY user_id(user_id)
    REFERENCES user(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS order_product;
CREATE TABLE order_product (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (order_id, product_id),

    FOREIGN KEY(order_id)
    REFERENCES orders(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

    FOREIGN KEY(product_id)
    REFERENCES product(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

);



