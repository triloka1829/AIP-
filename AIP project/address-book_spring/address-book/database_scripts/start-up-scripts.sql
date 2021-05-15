show databases;

CREATE database address_book;

use address_book;
show tables
CREATE TABLE IF NOT EXISTS t_person (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    person_name VARCHAR(255) NOT NULL,
    person_phone VARCHAR(255),
    person_company VARCHAR(255) NOT NULL,
    soft_detele BOOL,
    regesration_id INT
) 

select * from t_person