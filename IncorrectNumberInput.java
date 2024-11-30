package Calculator;

public class IncorrectNumberInput extends ArithmeticException{
    public IncorrectNumberInput(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "Некорректный ввод числа";
    }
}
