# Descrição Geral do Produto

As listas abaixo representam o resultado da elicitação realizada no levantamento de requisitos da aplicação proposta.

## Requisitos Funcionais 💾

|Código|Funcionalidade|Descrição|Necessidade|
|---|---|---|---|
|RF001|Encurtar URL|A URL indicada deve ser encurtada e retornada para o usuário|Obrigatório|
|RF002|Redirecionar URL Curta|O usuário ao inserir a versão curta da URL deve ser redirecionada para a original|Obrigatório|
|RF003|Contador de Cliques|O usuário deve poder acessar a contagem de acessos a determinada URL encurtada|Desejável|

## Requisitos Não-Funcionais 🚫

|Código|Restrição|Descrição|
|---|---|---|
|RNF001|Implementação|O sistema deverá ser todo desenvolvido com o Spring Framework.|
|RNF002|Arquitetura|O produto final deve ser uma API RESTful.|
|RNF003|Usabilidade|A documentação da API deve ser feita com Swagger para facilitar o acesso e compreensão.|
|RNF004|Implementação|Os dados devem ser persistidos no PostgreSQL.|
|RNF005|Confiabilidade|Testes unitários, feitos com JUnit, devem cobrir todos os endpoints da aplicação.|
|RNF006|Desempenho|Requests devem ser respondidas em até 3 segundos.|
