# ContasAPagar
 Projeto é uma  API Rest de Contas a Pagar, o banco de dados utilizado é o H2 em memória.

  Requisitos:
     Intellij,
     jdk 11,
     maven.
 
  Testar a aplicação:
     usar swagger, postman
         
   Funcionamento
   Ao Iniciar o servidor
    1- Deve-se acessar o endereço http://localhost:8080/swagger-ui.html;

   A aplicação é uma Api Rest desenvolvida com Spring boot.

   Lista Contas a pagar
   URL:GET/contas/v1
   Retorna lista de contas a pagar corrigidos

   Cadastro de contas a pagar
   URL:POST/contas/v1

  Código implementado:
  Divisão de responsabilidades das classes onde o controlador fica responsável por aceitar e devolver a requisição,
  camada service responsável pelas regras de negócio, a factory para facilitar reutilização de código das regras de negócio 
  e o repository responsável pela conexão com banco de dados. DTOs  recebem e devolvem os dados necessários.

  Melhorias no código:
  Faltou implementação de testes unitários, flyway por falta de tempo.
