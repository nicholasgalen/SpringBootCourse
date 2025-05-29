package com.ng.aula.controllers;

import com.ng.aula.exception.UnsuportedMathOperationException;
import com.ng.aula.math.SimpleMath;
import com.ng.aula.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math") // aplica em todos os componentes dentro do math controller
public class MathController {

    // bad & confusing code structure, use DI and other strategies to make it cleaner
    private SimpleMath math = new SimpleMath();

    // math/sum
    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception{
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsuportedMathOperationException("Please set a numeric value.");
        return math.sum(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // math/subtraction
    @RequestMapping("/subtraction/{num1}/{num2}")
    public Double subtraction(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception{
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsuportedMathOperationException("Please set a numeric value.");
        return math.subtraction(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }


    // math/division
    @RequestMapping("/division/{num1}/{num2}")
    public Double division(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception{
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsuportedMathOperationException("Please set a numeric value.");
        return math.division(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // math/multiplication
    @RequestMapping("/multiplication/{num1}/{num2}")
    public Double multiplication(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception{
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsuportedMathOperationException("Please set a numeric value.");
        return math.multiplication(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // math/mean
    @RequestMapping("/mean/{num1}/{num2}")
    public Double mean(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception{
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsuportedMathOperationException("Please set a numeric value.");
        return math.mean(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // math/square
    @RequestMapping("/squareroot/{num1}")
    public Double square(
            @PathVariable("num1") String num1
    ) throws Exception{
        if (!NumberConverter.isNumeric(num1)) throw new UnsuportedMathOperationException("Please set a numeric value.");
        return math.squareroot(NumberConverter.convertToDouble(num1));
    }
}
