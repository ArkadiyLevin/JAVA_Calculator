package Calculator;

abstract class Operation {
    public abstract double perform(double num1, char symbol, double num2) throws DivideByZeroException;
}
