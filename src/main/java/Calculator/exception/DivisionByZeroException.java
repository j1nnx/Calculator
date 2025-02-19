package Calculator.exception;

public class DivisionByZeroException extends RuntimeException {
  public DivisionByZeroException() {
    super("Ошибка: деление на 0 запрещено!");
  }
}
