create table reservation(
      id int not null primary key,
      coursId varchar_ignorecase(50) not null,
      status varchar_ignorecase(50) not null);