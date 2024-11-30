package Calculator;
abstract class ArithmeticException extends  Exception {
    public ArithmeticException(String message){
        super(message);
    }
    public abstract String getMessage();
}
