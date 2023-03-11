drop database ecommerce;

create database ecommerce;

use ecommerce;

create table ecommerce.user
(
    id           bigint       not null primary key auto_increment,
    email        varchar(255) not null unique,
    `password`   varchar(255) not null,
    `name`       varchar(255) not null,
    avatar       text,
    phone_number varchar(255) not null,
    created_at   datetime default CURRENT_TIMESTAMP,
    updated_at   datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table ecommerce.role
(
    id   bigint      not null primary key auto_increment,
    type varchar(50) not null unique
);

create table ecommerce.account_role
(
    id      bigint not null primary key auto_increment,
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) references user (id),
    foreign key (role_id) references role (id)
);

create table ecommerce.sales_register
(
    id                    bigint       not null primary key auto_increment,
    user_id               bigint       not null,
    email                 varchar(255) not null,
    phone_number          varchar(255) not null,
    shop_name             varchar(255) not null,
    warehouse_region_name varchar(255) not null,
    city                  varchar(50),
    district              varchar(50),
    wards                 varchar(50),
    address_detail        varchar(100),
    is_delete             boolean      not null default false,
    is_approved           boolean      not null default false,
    approved_at           datetime,
    created_at            datetime              default CURRENT_TIMESTAMP,
    updated_at            datetime              default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references user (id)
);

create table ecommerce.user_address
(
    id             bigint       not null primary key auto_increment,
    user_id        bigint       not null,
    phone_number   varchar(10)  not null,
    customer_name  varchar(100) not null,
    email          varchar(50)  null,
    city           varchar(50)  not null,
    district       varchar(50)  not null,
    wards          varchar(50)  not null,
    address_detail varchar(100) not null,
    is_deleted     boolean      not null default false,
    created_at     datetime     null     default CURRENT_TIMESTAMP,
    updated_at     datetime     null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references user (id)
);

create table ecommerce.rating_info
(
    id    bigint not null primary key auto_increment,
    star1 bigint default 0,
    star2 bigint default 0,
    star3 bigint default 0,
    star4 bigint default 0,
    star5 bigint default 0
);

create table ecommerce.shop
(
    id                    bigint       not null primary key auto_increment,
    user_id               bigint       not null unique,
    rating_id             bigint       not null unique,
    shop_name             varchar(255) not null,
    slug                  varchar(255) unique,
    email                 varchar(255) not null,
    phone_number          varchar(10)  not null,
    warehouse_region_name varchar(255) not null,
    shop_slogan           varchar(255),
    shop_logo             text,
    shop_background       text,
    city                  varchar(50),
    district              varchar(50),
    wards                 varchar(50),
    address_detail        varchar(100),
    product_total         bigint       not null default 0,
    response_time         varchar(255) not null default 'Đang cập nhật',
    time_prepare_product  varchar(255) not null default 'Đang cập nhật',
    is_official_shop      boolean      not null default false,
    is_deleted            boolean      not null default false,
    created_at            datetime              default CURRENT_TIMESTAMP,
    updated_at            datetime              default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references `user` (id),
    foreign key (rating_id) references rating_info (id)
);

create table ecommerce.return_policy
(
    id              bigint       not null primary key auto_increment,
    title           varchar(255) not null,
    tooltip_title   text         not null,
    tooltip_content text         not null,
    created_at      datetime     null default CURRENT_TIMESTAMP,
    updated_at      datetime     null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table ecommerce.discount
(
    id          bigint   not null primary key auto_increment,
    price       double   not null,
    final_price double   not null,
    percent     double   not null,
    is_running  boolean  not null default false,
    start_time  datetime null     default CURRENT_TIMESTAMP,
    end_time    datetime null,
    is_deleted  boolean  not null default false,
    created_at  datetime null     default CURRENT_TIMESTAMP,
    updated_at  datetime null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


create table ecommerce.category
(
    id    bigint       not null primary key auto_increment,
    title varchar(255) not null,
    slug  varchar(255) unique,
    icon  text
);

create table ecommerce.sub_category
(
    id          bigint       not null primary key auto_increment,
    category_id bigint       not null,
    title       varchar(255) not null,
    slug        varchar(255) unique,
    icon        text,
    foreign key (category_id) references category (id)
);

create table ecommerce.product
(
    id                bigint       not null primary key auto_increment,
    shop_id           bigint       not null,
    category_id       bigint       not null,
    sub_category_id   bigint       not null,
    discount__id      bigint       null,
    rating_id         bigint       not null unique,
    `name`            varchar(255) not null,
    slug              varchar(255) unique,
    price             double       not null,
    `description`     text         null,
    short_description text         null,
    quantity          bigint       not null default 0,
    order_count       int          not null default 0,
    keywords          varchar(255) null,
    is_public         boolean      not null default true,
    is_deleted        boolean      not null default false,
    created_at        datetime     null     default CURRENT_TIMESTAMP,
    updated_at        datetime     null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (shop_id) references shop (id),
    foreign key (category_id) references category (id),
    foreign key (sub_category_id) references sub_category (id),
    foreign key (rating_id) references rating_info (id)
);

create table ecommerce.product_image
(
    id         bigint not null primary key auto_increment,
    product_id bigint not null,
    url        text   not null,
    foreign key (product_id) references product (id)
);

create table ecommerce.product_return_policy
(
    id         bigint   not null primary key auto_increment,
    product_id bigint   not null,
    policy_id  bigint   not null,
    created_at datetime null default CURRENT_TIMESTAMP,
    updated_at datetime null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (product_id) references product (id),
    foreign key (policy_id) references return_policy (id)
);

create table ecommerce.attribute
(
    id         bigint      not null primary key auto_increment,
    product_id bigint      not null,
    `name`     varchar(50) not null,
    is_deleted boolean     not null default false,
    created_at datetime    null     default CURRENT_TIMESTAMP,
    updated_at datetime    null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (product_id) references product (id)
);

create table ecommerce.attribute_option
(
    id           bigint       not null primary key auto_increment,
    attribute_id bigint       not null,
    `name`       varchar(100) not null,
    `value`      varchar(100) not null,
    image        text         null,
    is_deleted   boolean      not null default false,
    created_at   datetime     null     default CURRENT_TIMESTAMP,
    updated_at   datetime     null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (attribute_id) references attribute (id)
);

create table ecommerce.variant
(
    id             bigint       not null primary key auto_increment,
    product_id bigint      not null,
    discount_id    bigint,
    attribute_hash varchar(255) not null,
    sku_user       varchar(100) not null,
    price          double       not null,
    quantity       int          not null default 0,
    is_deleted     boolean      not null default false,
    created_at     datetime     null     default CURRENT_TIMESTAMP,
    updated_at     datetime     null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (discount_id) references discount (id),
    foreign key (product_id) references product (id)
);

create table ecommerce.variant_option
(
    id         bigint not null primary key auto_increment,
    variant_id bigint not null,
    option_id  bigint not null,
    foreign key (variant_id) references variant (id),
    foreign key (option_id) references attribute_option (id)
);

# Table of cart function

create table ecommerce.cart
(
    id          bigint   not null primary key auto_increment,
    user_id     bigint   not null,
    total_price double   not null,
    created_at  datetime null default CURRENT_TIMESTAMP,
    updated_at  datetime null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references user (id)
);

create table ecommerce.cart_item
(
    id         bigint not null primary key auto_increment,
    cart_id    bigint not null,
    product_id bigint not null,
    variant_id bigint null,
    foreign key (cart_id) references cart (id),
    foreign key (product_id) references product (id),
    foreign key (variant_id) references variant (id)
);

# Table of order function

create table ecommerce.order_status
(
    id          bigint       not null primary key auto_increment,
    title       varchar(255) not null,
    description varchar(255) not null,
    created_at  datetime     null default CURRENT_TIMESTAMP,
    updated_at  datetime     null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table ecommerce.order
(
    id             bigint       not null primary key auto_increment,
    user_id        bigint       not null,
    shop_id        bigint       not null,
    status_id      bigint       not null,
    total          double       not null,
    phone_number   varchar(10)  not null,
    customer_name  varchar(100) not null,
    email          varchar(50)  null,
    note           varchar(255) null,
    city           varchar(50)  not null,
    district       varchar(50)  not null,
    wards          varchar(50)  not null,
    address_detail varchar(100) not null,
    is_deleted     boolean      not null default false,
    created_at     datetime     null     default CURRENT_TIMESTAMP,
    updated_at     datetime     null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references `user` (id),
    foreign key (shop_id) references shop (id),
    foreign key (status_id) references order_status (id)
);

create table ecommerce.order_item
(
    id               bigint   not null primary key auto_increment,
    order_id         bigint   not null,
    product_id       bigint   not null,
    variant_id       bigint   null,
    price            double   not null,
    final_price      double   not null,
    discount_percent double   not null,
    quantity         int      not null,
    created_at       datetime null default CURRENT_TIMESTAMP,
    updated_at       datetime null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (order_id) references `order` (id),
    foreign key (product_id) references product (id),
    foreign key (variant_id) references variant (id)
);

# Table of reviews function

create table ecommerce.product_reviews
(
    id         bigint     not null primary key auto_increment,
    user_id    bigint     not null,
    product_id bigint     not null,
    content    varchar(255),
    rating     tinyint(5) not null default 5,
    created_at datetime   null     default CURRENT_TIMESTAMP,
    updated_at datetime   null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references `user` (id),
    foreign key (product_id) references product (id)
);

create table ecommerce.shop_reviews
(
    id         bigint     not null primary key auto_increment,
    user_id    bigint     not null,
    shop_id    bigint     not null,
    content    varchar(255),
    rating     tinyint(5) not null default 5,
    created_at datetime   null     default CURRENT_TIMESTAMP,
    updated_at datetime   null     default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references `user` (id),
    foreign key (shop_id) references shop (id)
);

