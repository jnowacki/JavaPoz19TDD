package pl.jnowacki;

public class CalculatorImpl implements Calculator {

    public static final String DIV_0_MSG = "Nie dziel przez zero";

    private String display = "";

    @Override
    public void pressNumber(Object number) {
        StringBuilder builder = new StringBuilder(display);
        display = builder.append(number).toString();
    }

    @Override
    public String display() {
        return display;
    }

    @Override
    public void add(int numberA, int numberB) {
        clear();

        pressNumber(numberA + numberB);
    }

    @Override
    public void sub(int numberA, int numberB) {
        clear();
        pressNumber(numberA - numberB);
    }

    @Override
    public void div(int numberA, int numberB) throws IllegalArgumentException {

        if(numberB == 0) {
            throw new IllegalArgumentException(DIV_0_MSG);
        }

        clear();
        pressNumber(numberA/numberB);
    }

    @Override
    public void clear() {
        display = "";
    }

    @Override
    public void multi(int numberA, int numberB) {

    }
}
