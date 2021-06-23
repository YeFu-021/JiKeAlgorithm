package Test;

import Unity1.Calculator;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculator.calculate(s));
    }
}
