package com.ng.aula.repository;

// repository é o pacote onde ficam as interfaces de acesso a dados (DAO – Data Access Object), elas são usadas por
// Injeção de Dependência (DI) no Spring. Para aplica-las basta fazer uma Injeção via Construtor no Service. (Nesse caso
// no PersonServices).

import com.ng.aula.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interface é responsável por acessar os dados da entidade Person no banco de dados.
// O Spring Boot detecta automaticamente essa interface e cria uma implementação em tempo de execução.
// Ou seja, você não precisa escrever implementações de métodos básicos como salvar, buscar, deletar, etc.

// Ao estender JpaRepository, você ganha uma série de métodos prontos, como:
// - findAll()          → busca todas as entidades
// - findById(id)       → busca por ID
// - save(entity)       → insere ou atualiza
// - delete(entity)     → remove
// - count()            → conta total de registros
// E muito mais, sem precisar escrever código manual

// A interface é usada com Injeção de Dependência (DI):
// Você pode injetá-la em um service com @Autowired ou no construtor,
// e usar diretamente os métodos herdados de JpaRepository.

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Person → entidade que será gerenciada
    // Long   → tipo da chave primária (ID) da entidade
}
