package com.ng.aula.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

// Nesse caso não usamos record porque iremos fazer
// POST, enquanto records só permitem GET
public class Person implements Serializable {

    // @Serial identifica o ID de versão para serialização.
    // Útil para garantir compatibilidade ao salvar e ler objetos.
    // Eg. Quando você salva uma lista de pessoas em arquivo .ser e quer garantir que consiga ler depois, mesmo após mudanças na classe.
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
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
