# Mars Walker
Projeto para o desafio de lógica da conta azul para disponibilizar uma interface
rest para movimentação de um robo na superfice de marte.

## Execução
O projeto pode ser executado com o comando abaixo:  
```shell
mvn clean install spring-boot:run
```

### Exemplo de chamadas da API  

```shell
curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
```  
Saída esperada: *(2, 0, S)*

```shell
curl -s --request POST http://localhost:8080/rest/mars/MML
```  
Saída esperada: *(0, 2, W)*

```shell
curl -s --request POST http://localhost:8080/rest/mars/AAA
```
Saída esperada: *400 Bad Request*

```shell
curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
```
Saída esperada: *400 Bad Request*
