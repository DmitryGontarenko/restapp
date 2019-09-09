drop table if exists author_book, author, book;

create table author (
    id serial not null primary key,
    first_name varchar (50),
    last_name varchar (50)
);

create table book (
    id serial not null primary key,
    title varchar (100)
);

create table author_book (
    author_id int not null,
    book_id int not null,

    primary key (author_id, book_id),
    constraint fk_ab_author foreign key (author_id) references author (id)
        on update cascade on delete cascade,
    constraint fk_ab_book foreign key (book_id) references book (id)
);

insert into author (first_name, last_name) values
    ('Katya', 'Sierra'),
    ('Bert', 'Bates'),
    ('John', 'Show');

insert into book (title) values
    ('Gone with the Wind'),
    ('The Catcher in the Rye'),
    ('The Shining');

insert into author_book values
    (1, 1),
    (1, 3),
    (2, 1);