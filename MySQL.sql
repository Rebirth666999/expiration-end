create table if not exists user
(
    id       int auto_increment
        primary key,
    username varchar(50) not null,
    password varchar(50) not null
)
    engine = InnoDB;

create table if not exists product
(
    id           int auto_increment
        primary key,
    user_id      int                                          null,
    product_name varchar(100)                                 null,
    product_type enum ('food', 'medicine', 'daily_necessity') null,
    expiry_date  date                                         null,
    create_time  timestamp default CURRENT_TIMESTAMP          null,
    constraint product_ibfk_1
        foreign key (user_id) references user (id)
)
    engine = InnoDB;

create index user_id
    on product (user_id);

