insert into course(id, name, created_date, last_updated_date) values(10001,'JPA in 50 Steps', sysdate() , sysdate());
insert into course(id, name, created_date, last_updated_date) values(10002,'Soffr in 50 Steps', sysdate() , sysdate());
insert into course(id, name, created_date, last_updated_date) values(10003,'sodie in 50 Steps', sysdate() , sysdate());

insert into passport(id, number) values(40001,'12345566');
insert into passport(id, number) values(40002,'1235677');
insert into passport(id, number) values(40003,'12');

insert into student(id, name, passport_id) values(10003,'Amar', 40001);
insert into student(id, name, passport_id) values(10004,'Deecfe',40002);
insert into student(id, name, passport_id) values(10005,'Doe',40003);


insert into review(id, rating, description, course_id) values(10045,'5', 'Review1',10001);
insert into review(id, rating, description, course_id) values(10043,'6', 'Review2',10002);
insert into review(id, rating, description, course_id) values(10013,'7', 'Review3',10002);

insert into dog(id, name) values(10004,'Deecfe');
insert into owner(id, name, doggy_id) values(10003,'Amar', 10004);

insert into student_course (student_id, course_id)
	values (10003, 10002);
insert into student_course (student_id, course_id)
	values (10003, 10003);
insert into student_course (student_id, course_id)
	values (10005, 10003);
