package Calculator;

public class DivideByZeroException extends ArithmeticException{
    public DivideByZeroException(String message){
        super(message);
    }
    @Override
    public String getMessage() {
        return "Деление на ноль";
    }
}
