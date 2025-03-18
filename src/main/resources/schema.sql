create table if not exists students
(
    student_id   serial primary key,
    student_name varchar(50) not null,
    email        varchar(50) not null unique,
    phone_number varchar(20) not null
);

create table if not exists instructors
(
    instructor_id   serial primary key,
    instructor_name varchar(50),
    email           varchar(50) unique
);
CREATE TABLE courses
(
    course_id          serial primary key,
    course_name        varchar(50) not null,
    course_description varchar(255),
    instructor_id      int         not null,
    constraint fk_course foreign key (instructor_id) references instructors (instructor_id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS student_course
(
    id         serial primary key,
    student_id int not null,
    course_id  int not null,
    constraint fk_student foreign key (student_id) references students (student_id) ON UPDATE CASCADE ON DELETE CASCADE,
    constraint fk_course foreign key (course_id) references courses (course_id) ON UPDATE CASCADE ON DELETE CASCADE
);

