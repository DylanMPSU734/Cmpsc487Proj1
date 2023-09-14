create table users (
id int,
name varchar(100),
type varchar(10),
active varchar(10),

primary key(id)
);

create table timestamps (
id int,
ts timestamp,

primary key(ts),
foreign key(id) references users
);

--insert into users value(123456789, 'John Admin', 'admin', 'active');
--insert into users value(946671004, 'Dylan Martin', 'student', 'active');
--insert into users value(000000001, 'Joe Smith', 'student', 'inactive');

--insert into timestamps value(946671004, '2023-9-7 13:22:27.567);
--insert into timestamps value(000000001, "2023-9-7 13:23:03.821);