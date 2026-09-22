insert into roles (name) values ('ADMIN'), ('HR'), ('MENTOR'), ('STUDENT');

insert into users (username, password, email, first_name, last_name, role_id)
values
    ('admin', '$2a$10$placeholder', 'admin@vels.com', 'admin', 'adminov', 1),
    ('hr1', '$2a$10$placeholder', 'hr@vels.com', 'anna', 'hr', 2),
    ('mentor1', '$2a$10$placeholder', 'mentor@vels.com', 'petr', 'mentorov', 3),
    ('student1', '$2a$10$placeholder', 'student@vels.com', 'ivan', 'studentov', 4);

insert into courses (title, description, author_id, mandatory, order_index)
values
    ('welcome to vels', 'introduction to the company', 2, true, 1),
    ('sales basics', 'fundamentals of car sales', 2, true, 2),
    ('customer service', 'how to work with clients', 2, false, 3);

-- модули для курса 1
insert into modules (course_id, title, order_index)
values
    (1, 'company overview', 1),
    (1, 'our values', 2);

-- уроки для модуля 1
insert into lessons (module_id, title, content, order_index)
values
    (1, 'history of vels', 'vels was founded in 2021...', 1),
    (1, 'mission and vision', 'our mission is to help employees onboard faster...', 2);

-- тест для модуля 1
insert into tests (module_id, title, passing_score)
values
    (1, 'final test: welcome to vels', 80);