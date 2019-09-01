package pl.jnowacki;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorImplTest {

    private Calculator calculator;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Setting up before class");
    }

    @Before
    public void setUpBeforeEveryTest() {
        System.out.println("Set up before test");
        calculator = new CalculatorImpl();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("After class");
    }

    @After
    public void tearDownAfterTest() {
        System.out.println("After every test");
    }

    @Test
    public void testAdd() {
        // given
        int a = 2;
        int b = 2;

        int expectedResult = 4;

        assertEquals(expectedResult, calculator.add(2, 2));
    }
}