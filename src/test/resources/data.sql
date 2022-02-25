
insert into person(id, name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (1, 'martin', 19, 'A',1991,2,1);
insert into person(id, name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (2, 'jake', 20, 'B',1991,8,12);
insert into person(id, name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (3, 'john', 12, 'AB',1992,5,5);
insert into person(id, name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (4, 'messi', 22, 'A',1996,7,7);
insert into person(id, name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (5, 'honaldo', 24, 'O',1991,8,1);
insert into person(id, name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (6, 'kante', 28, 'B',1992,6,23);

insert into block(id, name) values (1, 'jake');
insert into block(id, name) values (2, 'messi');

update person set block_id = 1 where id = 2;
update person set block_id = 2 where id = 4;