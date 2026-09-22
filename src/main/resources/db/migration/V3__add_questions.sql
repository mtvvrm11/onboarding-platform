create table if not exists questions (
                                         id bigserial primary key,
                                         test_id bigint not null references tests(id) on delete cascade,
    question_text text not null,
    order_index integer not null
    );

create table if not exists answers (
                                       id bigserial primary key,
                                       question_id bigint not null references questions(id) on delete cascade,
    answer_text text not null,
    correct boolean default false
    );

create index idx_questions_test on questions (test_id);
create index idx_answers_question on answers (question_id);