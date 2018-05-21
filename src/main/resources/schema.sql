create table reservation(
      id int not null primary key,
      courseId varchar_ignorecase(50) not null,
      status varchar_ignorecase(50) not null
);
CREATE TABLE statistic(
      id int NOT NULL PRIMARY KEY ,
      methodName varchar_ignorecase(50) NOT NULL ,
      openTime int NOT NULL
);