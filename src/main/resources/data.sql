-- This will create some database objects as well some data on server init,
-- Springboot will execute all DML/DDL commands it gets on data.sql
-- more: https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html (78.3 Initialize a database)

--Clean all objects
DROP ALL OBJECTS;

CREATE TABLE conta (
  id   Long AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(30),
  valororiginal DECIMAL(2,17),
  datavencimento Date,
  datapagamento Date,
  valorcorrigido DECIMAL(2,17),
  quantdddiasatraso Long,
  last_modification TIMESTAMP
);


INSERT INTO conta(id, nome, valororiginal, datavencimento, datapagamento, valorcorrigido, quantdddiasatraso, last_modification)
VALUES (1, 'Mauricio',500.28, '2020-01-08', null , null, null, CURRENT_TIMESTAMP);




