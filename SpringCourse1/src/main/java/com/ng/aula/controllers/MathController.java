package com.ng.aula.controllers;

import com.ng.aula.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math") // aplica em todos os componentes dentro do math controller
public class MathController {
    // math/sum
    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception{
        if (!isNumeric(num1) || !isNumeric(num2)) throw new UnsuportedMathOperationException("Please set a numeric value.");
        return convertToDouble(num1) + convertToDouble(num2);
    }

    private Double convertToDouble(String strNum) {
        // Mesma validação do isNumeric
        if (strNum == null || strNum.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value.");
        String number = strNum.replace(",", ".");

        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNum) {
        // Verifica se o numero é null ou empty
        if (strNum == null || strNum.isEmpty()) return false;

        // Substitui a virgula por ponto (no brasil usa-se virgula para dinheiro ou decilmal
        // eg. R$ 3,54 enquanto a convenção é ponto, eg. USD 3.54
        String number = strNum.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }


    // math/subtraction
    // math/division
    // math/multiplication
}
