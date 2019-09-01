package pl.jnowacki;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CalculatorParametrizedByConstructorTest {

    private Calculator calculator;

    private int a;
    private int b;
    private String expectedResult;

    public CalculatorParametrizedByConstructorTest(int a, int b, String expectedResult) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;
    }

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