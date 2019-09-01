package pl.jnowacki;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorParametrizedByFieldTest {

    private Calculator calculator;

    @Parameterized.Parameter(value = 0)
    public int a;

    @Parameterized.Parameter(value = 1)
    public int b;

    @Parameterized.Parameter(value = 2)
    public String expectedResult;

    @Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 5, "6"},
                {3, 6, "9"},
                {1, 1, "2"}
        });
    }

    @Before
    public void setUpBeforeEveryTest() {
        System.out.println("Set up before test");
        calculator = new CalculatorImpl();
    }

    @Test
    public void shouldAddDifferentNumbers() {
        // when
        calculator.add(a, b);

        //then
        assertEquals(expectedResult, calculator.display());
    }
}