create table if not exists couriers
(
    id bigserial primary key,
    phone varchar(12) not null,
    status varchar(115) not null,
    address varchar(170) not null
);
create table if not exists customers
(
    id bigserial primary key,
    phone varchar(12) not null,
    email varchar(115) not null,
    address varchar(170) not null
);
create table if not exists restaurants
(
    id bigserial primary key,
    status varchar(115) not null,
    address varchar(170) not null
);
create table if not exists restaurant_menu_items
(
    id bigserial primary key,
    restaurant_id integer REFERENCES restaurants(id),
    name varchar(112) not null,
    price integer not null,
    image varchar not null,
    description varchar(200) not null
);
create table if not exists orders
(
    id bigserial primary key,
    customer_id integer REFERENCES customers(id),
    restaurant_id integer REFERENCES restaurants(id),
    status varchar(115) not null,
    courier_id integer REFERENCES couriers(id),
    timestamp timestamp
);
create table if not exists order_items
(
    id bigserial primary key,
    order_id integer REFERENCES orders(id),
    restaurant_menu_item_id integer REFERENCES restaurant_menu_items(id),
    price integer not null,
    quantity integer not null
);
select * from couriers;
select * from customers;
select * from restaurants;
select * from orders;
select * from order_items;
select * from restaurant_menu_items;
