-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
 --insert into product ('nome', 'descrição') values(nextval('hibernate_sequence'), 'field-1');
insert into product ( id, name, description, category, model, price) values(nextval('hibernate_sequence'),'Asus ROG Strix', 'Notebook Gamer', 'Notebook', 'Rog Strix', '15.000');
insert into product ( id, name, description, category, model, price) values(nextval('hibernate_sequence'),'Acer', 'Notebook Gamer', 'Notebook', 'Nitro 5', '5.000');
insert into product ( id, name, description, category, model, price) values(nextval('hibernate_sequence'),'Dell', 'Notebook Gamer', 'Notebook', 'G15', '10.000');
insert into product ( id, name, description, category, model, price) values(nextval('hibernate_sequence'),'Piano Digital', 'Piano bem bom', 'Instrumento', 'Casio', '4.000');
insert into product ( id, name, description, category, model, price) values(nextval('hibernate_sequence'),'Asus M515', 'Notebook Simples', 'Notebook', 'Asus', '3000');