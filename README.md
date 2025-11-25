📌 Design Patterns Utilizados no Projeto
1. Singleton (via Spring Beans)

O Spring gerencia automaticamente as classes anotadas com @Service, @Repository e @Controller como Singletons.
Isso garante que exista apenas uma instância de cada componente durante toda a aplicação, reduzindo consumo de memória e evitando estados inconsistentes.

→ Exemplo no projeto: ProductService, ProductRepository, ProductController.

2. Repository Pattern (Spring Data JPA)

Abstrai o acesso ao banco de dados, evitando SQL explícito na camada de serviço.
O ProductRepository herda de JpaRepository, ganhando métodos prontos como save(), findAll(), deleteById() etc.

→ Facilita manutenção, testes e desacoplamento.

3. Feign Client (Client Pattern / Declarative HTTP Client)

O Feign cria automaticamente um cliente HTTP baseado em interface.
Assim, fazemos chamadas REST externas como se fosse um método comum.

→ Exemplo: ExternalProductClient faz requisições para API externa retornando produtos.

4. DTO Pattern (Data Transfer Object)

Utilizado para transportar dados entre camadas e evitar expor entidades diretamente.
O ExternalProductDTO converte a resposta da API externa para o formato usado internamente.

→ Melhora segurança e desacoplamento entre sistemas.

5. Controller Pattern (MVC)

O Controller funciona como a camada responsável por receber requisições HTTP e retornar respostas.
Não contém regra de negócio — apenas delega ao service.

→ Exemplo: ProductController.

6. Service Layer Pattern

Centraliza a regra de negócio.
Evita que o Controller ou Repository fiquem “inteligentes demais”.

→ Exemplo: ProductService.
