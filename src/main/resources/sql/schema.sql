create or replace table `order`
(
    id      bigint auto_increment,
    status  varchar(255) not null,
    address varchar(500) null,
    item_id bigint       null,
    created_at datetime not null,
    modified_at datetime null,
    deleted_at datetime null,
    constraint order_pk
        primary key (id)
);

create or replace table store
(
    id          bigint auto_increment,
    name        varchar(255) not null,
    description text         null,
    created_at datetime not null,
    modified_at datetime null,
    deleted_at datetime null,
    constraint store_pk
        primary key (id)
);

create or replace table item
(
    id          bigint auto_increment,
    name        varchar(255) not null,
    description text         null,
    price       bigint       null,
    store_id    bigint       not null,
    created_at datetime not null,
    modified_at datetime null,
    deleted_at datetime null,
    constraint item_pk
        primary key (id)
);

create or replace table item_image
(
    id      bigint auto_increment,
    type    varchar(255) not null,
    url     text         null,
    name    varchar(255) null,
    size    bigint       null,
    item_id bigint       not null,
    created_at datetime not null,
    modified_at datetime null,
    deleted_at datetime null,
    constraint item_image_pk
        primary key (id)
);

