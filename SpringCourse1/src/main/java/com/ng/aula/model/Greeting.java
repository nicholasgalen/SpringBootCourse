package com.ng.aula.model;

// a classe do tipo *RECORD* já encapsula e mantém como private os seus valores
// (nesse caso id e content), sem precisar criar modelos, encapsular, fazer
// getters etc
public record Greeting(long id, String content) {
}
