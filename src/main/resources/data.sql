-- This will create some database objects as well some data on server init,
-- Springboot will execute all DML/DDL commands it gets on data.sql
-- more: https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html (78.3 Initialize a database)

--Clean all objects
DROP ALL OBJECTS;

CREATE TABLE conta (
  id   Long AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255),
  valororiginal DECIMAL,
  datavencimento Date,
  datapagamento Date,
  valorcorrigido DECIMAL,
  quantdddiasatraso Long
);


INSERT INTO conta(id, nome, valororiginal, datavencimento, datapagamento, valorcorrigido, quantdddiasatraso)
VALUES (1, 'Mauricio',500.28, '2020-01-08', null , null, null);




