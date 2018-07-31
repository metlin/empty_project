 CREATE TABLE IF NOT EXISTS Office (
    id         	BIGINT  PRIMARY KEY AUTO_INCREMENT,
    name 	   	VARCHAR(50) NOT NULL,
    active     	TINYINT(1)  NOT NULL,
    address		VARCHAR(100) NOT NULL,
    phone		VARCHAR(50) NOT NULL,
    org_id		BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS Organization (
    id         	BIGINT  PRIMARY KEY AUTO_INCREMENT,
   	name 	 	VARCHAR(100) NOT NULL,
    full_name 	VARCHAR(100) NOT NULL,
    active     	TINYINT(1)  NOT NULL,
    address		VARCHAR(100) NOT NULL,
    phone		VARCHAR(50) NOT NULL,
    inn 		BIGINT NOT NULL,
    kpp	 		BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS Document (
    user_id     BIGINT  	NOT NULL,
    name 	   	VARCHAR(250) NOT NULL,
    code		VARCHAR(10) NOT NULL
);




