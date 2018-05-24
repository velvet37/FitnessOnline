create table reservation(
      id int not null primary key,
      courseid varchar_ignorecase(50) not null,
      status varchar_ignorecase(50) not null
);
CREATE TABLE statistic(
      id int NOT NULL PRIMARY KEY ,
      methodname varchar_ignorecase(50) NOT NULL ,
      opentime int NOT NULL
);