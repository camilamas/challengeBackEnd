create table video(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    descricao varchar(255) not null,
    url varchar(255) not null,

    primary key(id)

);