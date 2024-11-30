package Calculator;

public class IncorrectOperationSymbol extends ArithmeticException{
    public IncorrectOperationSymbol(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "Некорректный ввод символа";
    }
}
