package Calculator;

public class Division extends Operation{
    public double perform(double num1, char symbol, double num2) throws DivideByZeroException {
        if (num2 == 0){
        }
        return num1/num2;
    }
}
