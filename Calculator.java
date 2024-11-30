package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private Scanner sc;
    private Operation operation;

    public Calculator() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.print("Введите первое число: ");
            double num1 = 0;
            try {
                num1 = readNumber();
            } catch (ArithmeticException e) {
                throw new RuntimeException(e);
            }

            System.out.print("Введите оператор (+, -, *, /)");
            char operationSymbol = 0;
            try {
                operationSymbol = readOperationSymbol();
            } catch (ArithmeticException e) {
                throw new RuntimeException(e);
            }

            System.out.print("Введите второе число: ");
            double num2 = 0;
            try {
                num2 = readNumber();
            } catch (ArithmeticException e) {
                throw new RuntimeException(e);
            }

            try {
                double result = performOperation(num1, operationSymbol, num2);
                System.out.println("Результат: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Хотите продолжить? (да/нет): ");
            String response = sc.nextLine().trim();
            if (!response.equalsIgnoreCase("да")) {
                break;
            }
        }
    }

    private double readNumber() throws ArithmeticException {
        while (true) {
            try {
                return Double.parseDouble((sc.next()));
            } catch (InputMismatchException e) {
                System.out.println("Некорректный формат числа. Попробуйте снова,");
                sc.next();
            }
        }
    }


    public char readOperationSymbol() throws ArithmeticException {
        while (true) {
            String symbol = sc.next().trim();
            switch (symbol) {
                case "+":

                case "-":

                case "*":

                case "/":
                    return symbol.charAt(0);
                default:
                    System.out.println("Некорректный символ операции. попробуйте снова.");
                    throw new IncorrectOperationSymbol("Некорректный символ операции");
            }
        }
    }

    private Operation getOperation(char symbol) throws ArithmeticException {
        switch (symbol) {
            case '+':
                return new Addition();
            case '-':
                return new Subtraction();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
            default:
                throw new ArithmeticException("Некорректный оператор") {
                    @Override
                    public String getMessage() {
                        return null;
                    }
                };
        }
    }

    private double performOperation(double num1, char operationSymbol, double num2) throws ArithmeticException {
        this.operation = getOperation(operationSymbol);
        return this.operation.perform(num1, operationSymbol, num2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
