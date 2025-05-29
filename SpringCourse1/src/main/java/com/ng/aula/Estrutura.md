# Models / Entities (1)

1. São as classes que representam os dados, geralmente mapeadas para o banco de dados (ex: com JPA @Entity).
2. Contém atributos + getters/setters.
3. Podem conter anotações de validação (@NotNull, @Size etc.).
4. Exemplo: Person, User, Product.

# DTOs (Data Transfer Objects) (opcional mas recomendado) (2)

1. Objetos usados para transferir dados entre camadas ou via API.
2. Separar DTOs das entidades evita expor diretamente a estrutura do banco.
3. Exemplo: PersonDTO pode ter só alguns campos para o cliente.

# Repositories (3)

1. Interface que faz a camada de acesso a dados (ex: extends JpaRepository).
2. Faz operações CRUD no banco.
3. Exemplo: PersonRepository que manipula Person.

# Services (4)

1. Camada onde fica a lógica de negócio.
2. Aqui você chama Repository, faz validações, regras, etc.
3. É um serviço que pode ser injetado em controllers.
4. Exemplo: PersonService com métodos como findById(), create(), update().

# Controllers (5)

1. Camada que expõe os endpoints REST.
2. Recebe requisições HTTP, chama Services, retorna respostas.
3. Usa anotações como @RestController, @RequestMapping.
4. Exemplo: PersonController com endpoint /person/{id}.

# Configurations (6)

1. Classes para configuração do Spring (ex: CORS, segurança, Swagger).
2. Exemplo: SecurityConfig, SwaggerConfig.

# Exception Handling (7)

1. Tratamento centralizado de erros (ex: @ControllerAdvice).
2. Para padronizar mensagens de erro e status HTTP.

# Security (opcional, mas importante em apps reais) (8)

1. Autenticação, autorização, tokens JWT, OAuth.
2. Exemplo: SecurityConfig, filtros, serviços de autenticação.

# Utilities / Helpers (9)

1. Classes utilitárias, helpers para tarefas comuns (ex: converter datas, validar campos).