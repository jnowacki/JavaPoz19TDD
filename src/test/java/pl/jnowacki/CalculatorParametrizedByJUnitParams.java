package pl.jnowacki;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorParametrizedByJUnitParams {

    private Calculator calculator;

    @Before
    public void setUpBeforeEveryTest() {
        System.out.println("Set up before test");
        calculator = new CalculatorImpl();
    }

    @Test
    @Parameters({"1, 1, 2", "2, 5, 7"})
    public void shouldAddDifferentNumbers(int a, int b, String expected) {
        // when
        calculator.add(a, b);

        //then
        assertEquals(expected, calculator.display());
    }
}