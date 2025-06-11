package com.ng.aula.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

// Nesse caso não usamos record porque iremos fazer
// POST, enquanto records só permitem GET
@Entity // Declara pelo JPA e o jakarta que isso é uma entidade (modelo) e portanto terá atributos do mesmo e sera usada assim
// (da mesma forma que declaramos RestController etc)
@Table(name = "person") // Aqui declaramos que essa entity é uma tabela, o name declara o nome da tabela (se deixar vazio
// o nome vai ser igual o nome da classe "Person" nesse caso.
public class Person implements Serializable {

    // @Serial identifica o ID de versão para serialização.
    // Útil para garantir compatibilidade ao salvar e ler objetos.
    // Eg. Quando você salva uma lista de pessoas em arquivo .ser e quer garantir que consiga ler depois, mesmo após mudanças na classe.
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aqui ele declara que Long id é um ID e que vai ser gerado
    // como IDENTITY (ou seja, que incrementa de 1 a 1)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 80) // aqui declara firstName como uma coluna de nome first_name,
    // que não pode ser nula e tem um tamanho maximo de 80
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 1)
    private Character gender;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    // equals() compara se dois objetos Person são iguais pelo conteúdo dos atributos.
    // Muito útil em testes, listas, e lógica de negócio onde igualdade por valor importa.
    // Verificar se duas pessoas no sistema têm os mesmos dados antes de salvar duplicado. (verificar se email já existe por exemplo)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getGender(), person.getGender());
    }

    // hashCode() gera um código numérico baseado nos atributos.
    // Útil para armazenar a pessoa em coleções como HashSet ou HashMap corretamente.
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
    }
}
