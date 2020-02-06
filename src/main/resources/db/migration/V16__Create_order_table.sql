create table `order`
(
    id varchar(36)  primary key not null,
    buyerId varchar(36),
    providerId varchar(36),
    questionId bigint,
    description LONGTEXT,
    number int,
    createTime date ,
    del_flag varchar(10)
);