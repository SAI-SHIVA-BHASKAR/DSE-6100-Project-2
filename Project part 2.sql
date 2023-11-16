use testdb;

-- Disable foreign key checks for the initial setup
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists User;
drop table  if exists Client;
drop table  if exists Quote_request;
drop table  if exists Quote_response;
drop table  if exists tree;
drop table  if exists orders;
drop table  if exists bill;

CREATE TABLE if not exists User( 
    email VARCHAR(50) NOT NULL, 
    firstName VARCHAR(10) NOT NULL, 
    lastName VARCHAR(10) NOT NULL, 
    password VARCHAR(20) NOT NULL, 
    role VARCHAR(20) NOT NULL,
    PRIMARY KEY (email)); 
   

CREATE TABLE if not exists Client( 
    client_id int(50) NOT NULL, 
    firstName VARCHAR(10) NOT NULL, 
    lastName VARCHAR(10) NOT NULL, 
    address VARCHAR(20) NOT NULL, 
    email varchar(20) unique,
    Phone int(10) NOT NULL,
    credit_card_info varchar(16) NOT NULL,
    PRIMARY KEY (client_id)); 
    
    
CREATE TABLE if not exists Quote_request( 
    quote_id int NOT NULL,
    client_id int NOT NULL,
    propose_date date NOT NULL,
    status varchar(60) NOT NULL,
    note text,
    price float(20),
    start_date date,
    end_date date,
    PRIMARY KEY (quote_id),
    foreign key (client_id) references Client (client_id)); 


CREATE TABLE if not exists Quote_response( 
    id int(50) NOT NULL,
    client_id int(50) NOT NULL,
    quote_id int (50) NOT NULL,
    propose_date date NOT NULL,
    status varchar(60) NOT NULL,
    price float(20),
    start_date date,
    end_date date,
    note text,
    PRIMARY KEY (id),
    foreign key (client_id) REFERENCES Client(client_id),
    foreign key (quote_id) REFERENCES quote_request(quote_id));



CREATE TABLE IF NOT EXISTS tree(
    tree_id int(50) NOT NULL,
    quote_id int (50) NOT NULL,
    size varchar(10),
    height float(10),
    location varchar(50),
    NearHouse BOOLEAN,
    Note TEXT,
    PRIMARY KEY (tree_id),
    Foreign key (quote_id) references quote_request(quote_id) 
);


CREATE TABLE IF NOT EXISTS Orders(
    order_id int(50) PRIMARY KEY,
    client_id int NOT NULL,
    quote_id int NOT NULL,
    start_date date,
    end_date date,
    total_amount float(20),
    FOREIGN KEY (client_id) REFERENCES Client(client_id),
    FOREIGN KEY (quote_id) REFERENCES quote_request(quote_id)
);


CREATE TABLE IF NOT EXISTS Bill(
    bill_id int PRIMARY KEY,
    order_id int(20) NOT NULL,
    total_mount int(20) NOT NULL,
    status varchar(10) NOT NULL,
    note TEXT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);

-- Insert a root user
INSERT INTO user(email, password, firstname, lastname, role) 
VALUES ('root', 'pass1234', 'root', 'root', 'Admin root'),
		('david@gmail.com', 'david ', 'David','Smith','David Smith');

select * from user;


