 CREATE TABLE IF NOT EXISTS Organization (
    org_id      BIGINT  PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    full_name   VARCHAR(100) NOT NULL,
    active      TINYINT(1)  NOT NULL,
    address     VARCHAR(100) NOT NULL,
    phone       VARCHAR(50) NOT NULL,
    inn         BIGINT NOT NULL,
    kpp         BIGINT NOT NULL
);

 CREATE TABLE IF NOT EXISTS Office (
    office_id   BIGINT  PRIMARY KEY AUTO_INCREMENT,
    name 	   	VARCHAR(50) NOT NULL,
    active     	TINYINT(1)  NOT NULL,
    address		VARCHAR(100) NOT NULL,
    phone		VARCHAR(50) NOT NULL,
    org_id		BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS User (
    user_id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR(50) NOT NULL,
    second_name     VARCHAR(50) NULL,
    middle_name     VARCHAR(100)  NULL,
    phone           VARCHAR(20)  NULL,
    position        VARCHAR(100)  NOT NULL,
    identified      TINYINT(1)  NOT NULL,
    doc_number      VARCHAR(20) NOT NULL,
    doc_date        DATE NOT NULL DEFAULT '2018-01-01',
    office_id       BIGINT NOT NULL,
    doc_id          BIGINT NOT NULL,
    country_id      BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS Document (
    doc_id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    doc_name 	VARCHAR(50) NOT NULL,
    doc_code    VARCHAR(5) NOT NULL
);

CREATE TABLE IF NOT EXISTS Country (
    country_id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    country_code  VARCHAR(5) NOT NULL,
    country_name  VARCHAR(50) NOT NULL
);

CREATE INDEX Office_Org_id ON Office(org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(org_id);

CREATE INDEX User_Office_id ON User(office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(office_id);

CREATE INDEX Doc_User_id ON Document(doc_id);
ALTER TABLE User ADD FOREIGN KEY (doc_id) REFERENCES Document(doc_id);

CREATE INDEX Country_User_id ON Country(country_id);
ALTER TABLE User ADD FOREIGN KEY (country_id) REFERENCES Country(country_id);

