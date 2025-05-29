package com.ng.aula.math;

import com.ng.aula.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class SimpleMath {

    // sum
    public Double sum(Double n1, Double n2) {
        return n1 + n2;
    }

    // subtraction
    public Double subtraction(Double n1, Double n2) {
        return n1 - n2;
    }

    // division
    public Double division(Double n1, Double n2) {
        return n1 / n2;
    }

    // multiplication
    public Double multiplication(Double n1, Double n2) {
        return n1 * n2;
    }

    // mean
    public Double mean(Double n1, Double n2) {
        return (n1 + n2) / 2;
    }

    // squareroot
    public Double squareroot(Double n1) {
        return Math.sqrt(n1);
    }
}
