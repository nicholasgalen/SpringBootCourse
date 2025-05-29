package com.ng.aula.request.converters;

import com.ng.aula.exception.UnsuportedMathOperationException;

public class NumberConverter {
    public static Double convertToDouble(String strNum) {
        // Mesma validação do isNumeric
        if (strNum == null || strNum.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value.");
        String number = strNum.replace(",", ".");

        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNum) {
        // Verifica se o numero é null ou empty
        if (strNum == null || strNum.isEmpty()) return false;

        // Substitui a virgula por ponto (no brasil usa-se virgula para dinheiro ou decilmal
        // eg. R$ 3,54 enquanto a convenção é ponto, eg. USD 3.54
        String number = strNum.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
