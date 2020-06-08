
--Insert values in USERS table
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, dob, role, contactnumber)
    	VALUES (1025,'database_uuid','database_firstname','database_lastname','database_username','database_email','database_password','database_salt', 'database_country' , 'database_dob' , 'admin' , 'database_contactnumber' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, dob, role, contactnumber)
     VALUES (1026,'database_uuid1','database_firstname1','database_lastname1','database_username1','database_email1','database_password1','database_salt1', 'database_country1' ,'database_dob1' , 'nonadmin' , 'database_contactnumber1' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, dob, role, contactnumber)
    VALUES (1027,'database_uuid2','database_firstname2','database_lastname2','database_username2','database_email2','database_password2','database_salt2', 'database_country2'  ,'database_dob2' , 'nonadmin' , 'database_contactnumber2' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country,  dob, role, contactnumber)
    VALUES (1028,'database_uuid3','database_firstname3','database_lastname3','database_username3','database_email3','database_password3','database_salt3', 'database_country3'  ,'database_dob3' , 'nonadmin' , 'database_contactnumber3' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country,  dob, role, contactnumber)
    VALUES (1029,'database_uuid4','database_firstname4','database_lastname4','database_username4','database_email4','database_password4','database_salt4', 'database_country4'  ,'database_dob4' , 'nonadmin' , 'database_contactnumber4' );


--Insert values in USER_AUTH table
insert into user_auth (id , uuid , user_id , access_token , expires_at , login_at, logout_at) values(1024 , 'database_uuid' , 1025 , 'database_accesstoken' , '2018-09-17 21:07:02.07' , '2018-09-17 13:07:02.07' , null);
insert into user_auth (id , uuid , user_id , access_token , expires_at , login_at , logout_at) values(1025 , 'database_uuid1' , 1026 , 'database_accesstoken1' , '2018-09-17 21:07:02.07' , '2018-09-17 13:07:02.07' , null );
insert into user_auth (id , uuid , user_id , access_token , expires_at , login_at , logout_at) values(1026 , 'database_uuid2' , 1027 , 'database_accesstoken2' , '2018-09-17 21:07:02.07' , '2018-09-17 13:07:02.07' , null );
insert into user_auth (id , uuid , user_id , access_token , expires_at , login_at , logout_at) values(1027 , 'database_uuid3' , 1028 , 'database_accesstoken3' , '2018-09-17 21:07:02.07' , '2018-09-17 13:07:02.07' , '2018-09-17 15:07:02.07' );

--Insert values in category table
insert into category (id,uuid,category,user_id) values(1024,'database_category_uuid','database_category_type',1026);


--insert values into items

insert into items(id,uuid,image,iname,specs,price,categoryuuid,user_id,category_id) values (1024,'database_item_uuid','my_image','name','specs','price','database_category_uuid',1026,1024);
