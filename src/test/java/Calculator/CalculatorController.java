package Calculator;

import Calculator.controller.CalculatorController;
import Calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    private CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        // Инициализация сервисов и контроллера перед каждым тестом
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        calculatorController = new CalculatorController(calculatorService);
    }

    @Test
    void testAdded() {
        // Проверка сложения
        String result1 = calculatorController.added(10, 3);
        String result2 = calculatorController.added(10, 20);

        assertEquals("10 + 3 = 13", result1);
        assertEquals("10 + 20 = 30", result2);
    }

    @Test
    void testMinus() {
        // Проверка вычитания
        String result1 = calculatorController.minus(8, 3);
        String result2 = calculatorController.minus(15, 7);

        assertEquals("8 - 3 = 5", result1);
        assertEquals("15 - 7 = 8", result2);
    }

    @Test
    void testMultiply() {
        // Проверка умножения
        String result1 = calculatorController.multiply(2, 3);
        String result2 = calculatorController.multiply(4, 5);

        assertEquals("2 * 3 = 6", result1);
        assertEquals("4 * 5 = 20", result2);
    }

    @Test
    void testDivide() {
        // Проверка деления
        try {
            String result1 = calculatorController.divide(6, 2);
            String result2 = calculatorController.divide(10, 2);

            assertEquals("6 % 2 = 3", result1);
            assertEquals("10 % 2 = 5", result2);
        } catch (IllegalAccessException e) {
            fail("Не должно быть исключения: " + e.getMessage());
        }
    }

    @Test
    void testDivideByZero() {
        // Проверка деления на ноль
        try {
            calculatorController.divide(6, 0);
            fail("Ожидалось исключение IllegalAccessException");
        } catch (IllegalAccessException e) {
            assertEquals("Делить на 0 нельзя", e.getMessage());
        }
    }
}
