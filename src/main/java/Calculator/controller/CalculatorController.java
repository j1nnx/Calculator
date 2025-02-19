package Calculator.controller;

import Calculator.service.CalculatorService;
import Calculator.exception.DivisionByZeroException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String sayHello() {
        return calculatorService.hello();
    }

    @GetMapping("/plus")
    public String add(@RequestParam Integer num1, @RequestParam Integer num2) {
        return calculatorService.addNumber(num1, num2);
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam Integer num1, @RequestParam Integer num2) {
        return calculatorService.subtract(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        return calculatorService.divide(num1, num2);
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public String handleDivisionByZero(DivisionByZeroException e) {
        return e.getMessage();
    }
}
