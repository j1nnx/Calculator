package Calculator;

import Calculator.exception.DivisionByZeroException;
import Calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    void testAddition() {
        assertEquals("5 + 5 = 10", calculatorService.addNumber(5, 5));
    }

    @Test
    void testSubtraction() {
        assertEquals("5 - 5 = 0", calculatorService.subtract(5, 5));
    }

    @Test
    void testMultiplication() {
        assertEquals("5 * 5 = 25", calculatorService.multiply(5, 5));
    }

    @Test
    void testDivision() {
        assertEquals("5 / 5 = 1", calculatorService.divide(5, 5));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(5, 0));
        assertEquals("Ошибка: деление на 0 запрещено!", exception.getMessage());
    }
}
