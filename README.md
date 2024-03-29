# Fitness API

Seja bem-vindo ao repositório do projeto Fitness API!

Este projeto é um estudo prático envolvendo Java e Spring. Foi implementado uma API REST utilizando o Spring, aplicando conceitos importantes como camada de serviço, DTOs, record e anotações para mapeamento de rotas.

# Objetivo

O objetivo desta aplicação é fornecer uma API REST que gerencia informações sobre treinos fitness. A API permite que os usuários realizem várias operações, incluindo a obtenção de informações sobre um treino específico, a criação de novos treinos, a atualização de treinos existentes e a exclusão de treinos. Além disso, a API também pode retornar uma lista de todos os treinos disponíveis.
<br>
Vale ressaltar que, no momento, a aplicação não está conectada a um banco de dados real. Em vez disso, ela usa a classe chamada FakeFitnessDatabase para imitar o comportamento de um banco de dados e gerenciar as informações.

<details>
<summary><strong>🎛 Checkstyle</strong></summary>

Para assegurar a qualidade do código, utilizamos o Checkstyle neste projeto. Isso garante que o código esteja alinhado com as boas práticas de desenvolvimento, tornando-o mais legível e fácil de manter! Para executar o Checkstyle:

```bash
mvn checkstyle:check
```

</details>

<details>
<summary><strong>🛠 Testes</strong></summary>

Para executar todos os testes basta rodar o comando:
```bash
mvn test
```

Para executar apenas uma classe de testes:
```bash
mvn test -Dtest="TestClassName"
```

</details>

## Rotas da API

Depois de garantir que você está no diretório do projeto, execute o comando mvn spring-boot:run para iniciar a aplicação

1 - GET/fitness: 

Esta rota retornará uma mensagem. Para acessá-la, você pode usar um navegador ou uma ferramenta como o curl ou Postman. 
Exemplo:
http://localhost:8080/fitness

2 - GET/fitness/workouts/{id}:

Esta rota retornará os dados do treino correspondente ao ID fornecido. Substitua {id} pelo ID do treino que você deseja acessar. 
Exemplo:
curl http://localhost:8080/fitness/workouts/1

3 - POST/fitness/workouts:

Esta rota receberá dados de um novo treino pelo corpo da requisição e salvará esses dados. Os dados devem ser do tipo WorkoutCreationDto. Após salvar os dados, a rota retornará o novo objeto que foi salvo com o status code 201 (“created”). Exemplo:

{"name":"Novo Treino", "repetitions":10, "secretTechnique":"Nova Técnica"}

4 - GET/fitness/workouts: 

Esta rota retornará uma lista de todos os treinos disponíveis. Exemplo:
http://localhost:8080/fitness/workouts

5 - PUT/fitness/workouts/{id}

http://localhost:8080/fitness/workouts/1

Esta rota permite que você atualize um treino existente.

{"name":"Novo Treino","repetitions":10,"secretTechnique":"Nova Técnica"}

6 - DELETE /fitness/workouts/{id}

Esta rota permite que você delete um treino existente.

http://localhost:8080/fitness/workouts/1




