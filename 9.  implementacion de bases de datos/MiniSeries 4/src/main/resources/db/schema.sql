
DROP TABLE IF EXISTS mini_serie;
CREATE TABLE mini_serie (
                            id BIGINT AUTO_INCREMENT,
                            nombre VARCHAR(255),
                            rating DECIMAL(3,1),
                            amount_of_awards INT,
                            PRIMARY KEY (id)
);