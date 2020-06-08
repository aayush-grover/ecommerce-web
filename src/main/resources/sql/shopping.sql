--USERS table is created to store the details of all the users
DROP TABLE IF EXISTS USERS CASCADE;
CREATE TABLE IF NOT EXISTS USERS(id SERIAL, uuid VARCHAR(200) NOT NULL ,firstName VARCHAR(30) NOT NULL , lastName VARCHAR(30) NOT NULL ,userName VARCHAR(30) UNIQUE NOT NULL,  email VARCHAR(50) UNIQUE NOT NULL ,password VARCHAR(255) NOT NULL, salt VARCHAR(200) NOT NULL ,country VARCHAR(30) , dob VARCHAR(30), role VARCHAR(30),contactNumber VARCHAR(30), PRIMARY KEY (id));
INSERT INTO users(
	id, uuid, firstname, lastname, username, email, password, salt, country, dob, role, contactnumber)
	VALUES (1024,'rdtrdtdyt','Aayush','Grover','aayush-grover','a@gmail.com','507FF5FED1CAC746','8Xt6jxoCI3MWsVaKY/1ySAp2qzlb2Z7P89+vDrb1o6U=', 'India' ,'22-10-1995' , 'admin' , '1222333333' );
--USER_AUTH table is created to store the login information of all the users
DROP TABLE IF EXISTS USER_AUTH CASCADE;
CREATE TABLE IF NOT EXISTS USER_AUTH(
	ID BIGSERIAL PRIMARY KEY,
	uuid VARCHAR(200) NOT NULL,
	USER_ID INTEGER NOT NULL,
	ACCESS_TOKEN VARCHAR(500) NOT NULL,
	EXPIRES_AT TIMESTAMP NOT NULL,
	LOGIN_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	LOGOUT_AT TIMESTAMP NULL
);
ALTER TABLE USER_AUTH ADD CONSTRAINT FK_USER_AUTH_USER_ID FOREIGN KEY(USER_ID) REFERENCES USERS(ID) ON DELETE CASCADE ;

--category table for the type of item
DROP TABLE IF EXISTS CATEGORY CASCADE;
CREATE TABLE IF NOT EXISTS CATEGORY(id SERIAL,uuid VARCHAR(200) NOT NULL, category VARCHAR(500) NOT NULL, user_id INTEGER NOT NULL, PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE);


--ITEM table is created to store the items related information in contrast to to any Category posted in the Application
DROP TABLE IF EXISTS ITEMS CASCADE;Cart
CREATE TABLE IF NOT EXISTS ITEMS(id SERIAL,uuid VARCHAR(200) , image VARCHAR(255), iname VARCHAR(255) ,specs VARCHAR(255) ,price VARCHAR(255),categoryuuid  VARCHAR(255), user_id INTEGER , category_id INTEGER , PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE, FOREIGN KEY (category_id) REFERENCES CATEGORY(id) ON DELETE CASCADE);

--Cart table contains items of particular userwhich are added to cart
DROP TABLE IF EXISTS CART CASCADE;
CREATE TABLE IF NOT EXISTS CART(id SERIAL,uuid VARCHAR(200) , image VARCHAR(255), iname VARCHAR(255) ,specs VARCHAR(255) ,price VARCHAR(255),username  VARCHAR(255), PRIMARY KEY(id))
