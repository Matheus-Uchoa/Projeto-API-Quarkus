-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
 --insert into product ('nome', 'descrição') values(nextval('hibernate_sequence'), 'field-1');





insert into brand ( name, industry, yearfounded) values( 'Asus', 'Technology','1989');
insert into brand ( name, industry, yearfounded) values( 'Dell', 'Technology',1984);
insert into brand ( name, industry, yearfounded) values( 'Acer', 'TIC',1976);
insert into brand ( name, industry, yearfounded) values('Casio', 'Eletronics',1957);
insert into brand ( name, industry, yearfounded) values('TecToy', 'Brinquedo',1912);



insert into product ( name, description, category, model, price, id_brand) values('Asus ROG Strix', 'Notebook Gamer', 'Notebook', 'Rog Strix', '15.000',1);
insert into product ( name, description, category, model, price, id_brand) values('Acer', 'Notebook Gamer', 'Notebook', 'Nitro 5', '5.000',3);
insert into product ( name, description, category, model, price, id_brand) values('Dell', 'Notebook Gamer', 'Notebook', 'G15', '10.000',2);
insert into product ( name, description, category, model, price, id_brand) values('Piano Digital', 'Piano bem bom', 'Instrumento', 'Casio', '4.000',4);
insert into product ( name, description, category, model, price, id_brand) values('Asus M515', 'Notebook Simples', 'Notebook', 'Asus', 3000,1);