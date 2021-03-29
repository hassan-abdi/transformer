DROP TABLE IF EXISTS transformer;
CREATE TABLE transformer (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    strength INT NOT NULL,
    intelligence INT NOT NULL,
    speed INT NOT NULL,
    endurance INT NOT NULL,
    rank INT NOT NULL,
    courage INT NOT NULL,
    firepower INT NOT NULL,
    skill INT NOT NULL
);