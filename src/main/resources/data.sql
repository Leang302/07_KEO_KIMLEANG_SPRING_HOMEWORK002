-- Insert students
INSERT INTO students (student_name, email, phone_number)
VALUES ('John Doe', 'johndoe@example.com', '123-456-7890'),
       ('Jane Smith', 'janesmith@example.com', '234-567-8901'),
       ('Michael Johnson', 'michaelj@example.com', '345-678-9012'),
       ('Emily Davis', 'emilyd@example.com', '456-789-0123'),
       ('Chris Brown', 'chrisb@example.com', '567-890-1234');

-- Insert instructors
INSERT INTO instructors (instructor_name, email)
VALUES ('Alice Johnson', 'alice@example.com'),
       ('Bob Smith', 'bob@example.com'),
       ('Charlie Brown', 'charlie@example.com'),
       ('David Wilson', 'david@example.com');

-- Insert courses
INSERT INTO courses (course_name, course_description, instructor_id)
VALUES ('Database Management', 'Learn SQL and database design', 1),
       ('Web Development', 'Build websites using HTML, CSS, and JavaScript', 2),
       ('Data Structures', 'Study algorithms and data structures', 3),
       ('Networking Basics', 'Understand computer networks', 4),
       ('Software Engineering', 'Learn software development methodologies', 1);

-- Enroll students in courses
INSERT INTO student_course (student_id, course_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 3),
       (3, 4),
       (4, 4),
       (4, 5),
       (5, 1),
       (5, 5);
