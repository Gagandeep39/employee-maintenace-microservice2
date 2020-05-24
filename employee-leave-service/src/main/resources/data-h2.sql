-- DUMMY data for Department - dept_id, dept_name
INSERT INTO department_table (dept_id, dept_name) VALUES (100000, 'HR');
INSERT INTO department_table (dept_id, dept_name) VALUES (100001, 'Operations');
INSERT INTO department_table (dept_id, dept_name) VALUES (100002, 'Marketing');
INSERT INTO department_table (dept_id, dept_name) VALUES (100003, 'Development');
INSERT INTO department_table (dept_id, dept_name) VALUES (100004, 'Testing');
INSERT INTO department_table (dept_id, dept_name) VALUES (100005, 'Training and Development');
INSERT INTO department_table (dept_id, dept_name) VALUES (100006, 'Recreation');
INSERT INTO department_table (dept_id, dept_name) VALUES (100007, 'Taxation');
-- UPDATE dept_id_sequence SET next_val = 100008;
ALTER sequence dept_id_sequence restart with 100008;

-- 	GRADE_DESC, GRADE_MAX_SAL, GRADE_MIN_SAL, grade_desc
INSERT INTO grade_table (grade_code, grade_min_sal, grade_max_sal, grade_desc) VALUES ('M1', 25000, 100000, 'Trainee');
INSERT INTO grade_table (grade_code, grade_min_sal, grade_max_sal, grade_desc) VALUES ('M2', 100001, 250000, 'Junior Employee');
INSERT INTO grade_table (grade_code, grade_min_sal, grade_max_sal, grade_desc) VALUES ('M3', 250001, 500000, 'Senior Employee');
INSERT INTO grade_table (grade_code, grade_min_sal, grade_max_sal, grade_desc) VALUES ('M4', 500000, 1000000, 'Team Leader');
INSERT INTO grade_table (grade_code, grade_min_sal, grade_max_sal, grade_desc) VALUES ('M5', 1000001, 2000000, 'Department Head');
INSERT INTO grade_table (grade_code, grade_min_sal, grade_max_sal, grade_desc) VALUES ('M6', 2000001, 3000000, 'Vice Presidents');
INSERT INTO grade_table (grade_code, grade_min_sal, grade_max_sal, grade_desc) VALUES ('M7', 3000001, 4000000, 'Board Members');
-- UPDATE grade_code_sequence SET next_val = 100008;
ALTER sequence grade_code_sequence restart with 100008;


-- Rol table
INSERT INTO role_table (role_id, role_name) VALUES (100001, 'ROLE_ADMIN');
INSERT INTO role_table (role_id, role_name) VALUES (100002, 'ROLE_MANAGER');
INSERT INTO role_table (role_id, role_name) VALUES (100003, 'ROLE_EMPLOYEE');

-- User master table
INSERT INTO user_master (user_id, password, role_id, username) VALUES (100001,'123456',100001,'gagan');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100001,'1999-05-14','2020-05-06','Developer','test@mail.com',
'Gagandeep','M','Singh',100001,'Single','8419969059',100003, 40000, 'M1');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100001,'Adams Drive','Houston','77002','Texas');

INSERT INTO user_master (user_id, password, role_id, username) VALUES (100002,'123456',100002,'pranav');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100002,'1998-03-31','2020-05-06','Developer','pranav@mail.com',
'Pranav','M','Karmarkar',100002,'Single','9763916892',100004, 120000, 'M2');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100002,'Illinois Avenue','Tigard','97223','Oregon');

INSERT INTO user_master (user_id, password, role_id, username) VALUES (100003,'123456',100003,'axl');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100003,'1986-07-17','2011-06-06','DataScientist','axl@mail.com',
'Axl','M','Roy',100002,'Married','7555238332',100005, 280000, 'M3');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100003,'Hog Camp Road','La Grange','60525','Illinois');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100004,'123456',100003,'jazmine');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100004,'1993-11-10','2011-01-15','Tester','jazmine@mail.com',
'Jazmine','F','Mcconnell',100002,'Single','7555296682',100006,150000, 'M2');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100004,'Union Street','Seattle','98106','Washington');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100005,'123456',100003,'samah');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100005,'2000-07-17','2019-12-06','Developer','samah@mail.com',
'Samah','F','Forrest',100002,'Single','9255511013',100005, 80000,'M1');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100005,'Pine Street','Portland','97205','Pennsylvania');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100006,'123456',100002,'ethel');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100006,'1966-03-03','1996-11-24','SeniorDeveloper','ethel@mail.com',
'Ethel','M','Bonner',100002,'Divorced','8555984269',100002,1500000,'M5');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100006,'Stonepot Road','Newark','07102','New Jersey');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100007,'123456',100003,'klaudia');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100007,'1981-05-28','2006-09-10','SeniorDeveloper','klaudia@mail.com',
'Klaudia','F','Dunn',100006,'Married','8555282780',100006,700000,'M4');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100007,'Coffman Alley','Elizabethtown','42701','Kentucky');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100008,'123456',100003,'cem');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100008,'1991-08-30','2018-12-31','DataScientist','cem@mail.com',
'Cem','M','Riggs',100006,'Single','7555361368',100006,220000,'M2');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100008,'West Fork Drive','CLEVELAND','44113','Ohio');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100009,'123456',100003,'hareem');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100009,'1968-10-30','1984-11-26','AssistantDeveloper','hareem@mail.com',
'Hareem','M','Dunkley',100002,'Single','7555590931',100005,3600000,'M7');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100009,'Thompson Drive','Oakland','94612','California');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100010,'123456',100002,'anna');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100010,'1999-01-24','2019-02-07','Tester','anna@mail.com',
'Anna','F','Williams',100006,'Single','8555929298',100007, 90000,'M1');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100010,'Polk Street','Tucson','85710','Arizona');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100011,'123456',100003,'elinor');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100011,'1972-01-21','1998-07-25','AssistantDeveloper','elinor@mail.com',
'Elinor','M','Murillo',100010,'Married','8555004999',100001, 1600000,'M5');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100011,'Vernon Street','Carlsbad','92008','California');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100012,'123456',100003,'syzmon');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100012,'1992-09-04','2016-08-15','AssistantDeveloper','syzmon@mail.com',
'Szymon','M','Blake',100010,'Married','7555691056',100001, 300000,'M3');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100012,'Carson Street','Danville','40422','Kentucky');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100013,'123456',100003,'luca');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100013,'1981-11-03','2007-04-09','DataScientist','luca@mail.com',
'Luca','F','Hogan',100006,'Married','7555260794',100002, 530000,'M4');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100013,'Turkey Pen Lane','Montgomery','36117','Alabama');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100014,'123456',100002,'ellesse');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100014,'1992-05-04','2013-11-22','SeniorDeveloper','ellesse@mail.com',
'Ellesse','F','Mckay',100006,'Single','7555097247',100001, 320000,'M3');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100014,'New Creek Road','Fort Wayne','46802','Indiana');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100015,'123456',100001,'cai');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100015,'2001-09-27','2019-12-08','Tester','cai@mail.com',
'Cai','F','Nelson',100014,'Single','9955526265',100005,210000,'M2');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100015,'Vineyard Drive','Cleveland','44115','Ohio');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100016,'123456',100003,'maxwell');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100016,'1994-04-28','2013-02-17','AssistantDeveloper','maxwell@mail.com',
'Maxwell','M','Pope',100014,'Single','9755583023',100001,60000,'M1');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100016,'Small Street','TERRELL','75161','Texas');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100017,'123456',100003,'natalya');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100017,'1977-01-22','2009-01-09','DataScientist','natalya@mail.com',
'Natalya','F','Holt',100010,'Widowed','9055521516',100002, 1400000,'M4');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100017,'Cunningham Court','Farmington Hills','48335','Michigan');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100018,'123456',100002,'arlo');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100018,'1985-02-14','2011-09-11','SeniorDeveloper','arlo@mail.com',
'Arlo','M','Rodriguez',100006,'Married','8555967267',100005,350000,'M3');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100018,'Clarence Court','Fayetteville','28301','North Carolina');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100019,'123456',100003,'hector');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100019,'1993-02-16','2019-03-14','Tester','hector@mail.com',
'Hector','M','Roberson',100019,'Single','8555915540',100004,110000,'M2');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100019,'Hide A Way Road','Santa Clara','95050','California');


INSERT INTO user_master (user_id, password, role_id, username) VALUES (100020,'123456',100003,'nial');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, marital_status, phoneno, dept_id, emp_basic, emp_grade) VALUES (100020,'1998-04-08','2018-08-04','DataScientist','nial@mail.com',
'Nial','M','Sloan',100020,'Single','7555850539',100001,30000,'M1');
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100020,'Chatham Way','Hagerstown','21740','Maryland');

-- UPDATE user_id_sequence SET next_val = 100021;
ALTER sequence user_id_sequence restart with 100021;

-- Leave Data

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100001,'2020-12-12','2020-12-15',13,'Applied',4,100001);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100002,'2020-09-19','2020-09-23',13,'Applied',5,100002);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100003,'2020-07-09','2020-07-16',13,'Applied',8,100015);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100004,'2020-05-07','2020-05-08',13,'Applied',2,100003);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100005,'2020-12-06','2020-12-16',13,'Applied',11,100008);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100006,'2020-08-03','2020-08-08',13,'Applied',6,100003);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100007,'2020-05-13','2020-05-24',13,'Applied',12,100018);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100008,'2020-12-21','2020-12-30',13,'Applied',10,100011);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100009,'2020-12-10','2020-12-19',13,'Applied',10,100005);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100010,'2020-07-26','2020-07-26',13,'Applied',1,100018);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100011,'2020-11-22','2020-11-22',13,'Applied',1,100007);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100012,'2020-10-07','2020-10-12',13,'Applied',6,100015);

INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100013,'2020-08-16','2020-08-18',13,'Applied',3,100006);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100014,'2020-12-02','2020-12-08',13,'Applied',7,100020);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100015,'2020-09-16','2020-09-18',13,'Applied',3,100014);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100016,'2020-09-05','2020-09-08',13,'Applied',4,100010);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100017,'2020-10-03','2020-10-12',13,'Applied',10,100002);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100018,'2020-08-21','2020-08-29',13,'Applied',9,100018);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100019,'2020-11-22','2020-11-24',13,'Applied',3,100007);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100020,'2020-05-29','2020-05-30',13,'Applied',2,100012);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100021,'2020-12-19','2020-12-23',13,'Applied',5,100003);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100022,'2020-12-12','2020-12-15',13,'Applied',4,100019);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100023,'2020-07-05','2020-07-05',13,'Applied',1,100013);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100024,'2020-07-03','2020-07-07',13,'Applied',5,100002);

  INSERT INTO leave_history (leave_id, date_from, date_to, leave_balance, leave_status, no_of_days_applied, emp_id)
 VALUES (100025,'2020-10-07','2020-10-08',13,'Applied',2,100001);

ALTER sequence leave_id_sequence restart with 100026;


