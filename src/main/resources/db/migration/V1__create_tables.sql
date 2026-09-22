create table if not exists roles (
                                     id bigserial primary key,
                                     name varchar(50) not null unique
    );

create table if not exists users (
                                     id bigserial primary key,
                                     username varchar(100) not null unique,
    password varchar(255) not null,
    email varchar(150) not null,
    first_name varchar(100),
    last_name varchar(100),
    role_id bigint not null references roles(id),
    active boolean default true,
    created_at timestamp default current_timestamp
    );

create table if not exists courses (
                                       id bigserial primary key,
                                       title varchar(200) not null,
    description text,
    author_id bigint references users(id),
    mandatory boolean default false,
    order_index integer,
    created_at timestamp default current_timestamp
    );

create table if not exists modules (
                                       id bigserial primary key,
                                       course_id bigint not null references courses(id) on delete cascade,
    title varchar(200) not null,
    order_index integer not null
    );

create table if not exists lessons (
                                       id bigserial primary key,
                                       module_id bigint not null references modules(id) on delete cascade,
    title varchar(200) not null,
    content text,
    video_url varchar(500),
    order_index integer not null
    );

create table if not exists progress (
                                        id bigserial primary key,
                                        user_id bigint not null references users(id) on delete cascade,
    course_id bigint not null references courses(id) on delete cascade,
    status varchar(50) not null,
    completed_percent integer default 0,
    started_at timestamp,
    completed_at timestamp,
    unique (user_id, course_id)
    );

create table if not exists tests (
                                     id bigserial primary key,
                                     module_id bigint not null references modules(id) on delete cascade,
    title varchar(200) not null,
    passing_score integer default 80
    );

create table if not exists results (
                                       id bigserial primary key,
                                       user_id bigint not null references users(id) on delete cascade,
    test_id bigint not null references tests(id) on delete cascade,
    score integer not null,
    passed boolean not null,
    taken_at timestamp default current_timestamp
    );

create index idx_users_role on users (role_id);
create index idx_modules_course on modules (course_id);
create index idx_lessons_module on lessons (module_id);
create index idx_progress_user on progress (user_id);
create index idx_results_user on results (user_id);