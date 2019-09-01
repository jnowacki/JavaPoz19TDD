package pl.jnowacki;

public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}
