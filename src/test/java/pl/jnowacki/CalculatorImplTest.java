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
        System.out.println("test1");
        // given
        int a = 2;
        int b = 2;

        int expected = 4;

        //when
        int result = calculator.add(a, b);

        //then
        assertEquals("Add failed", expected, result);
    }

    @Test
    public void testAdd2() {
        System.out.println("test2");
        // given
        int a = 3;
        int b = 5;

        int expected = 8;

        //when
        int result = calculator.add(a, b);

        //then
        assertEquals("Add failed", expected, result);
    }
}