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
    public void shouldDisplayConcatenatedNumbersWhenPressed() {

        // given
        int a = 5;
        int b = 4;
        int c = 3;

        String expected = "543";

        // when
        calculator.pressNumber(a);
        calculator.pressNumber(b);
        calculator.pressNumber(c);

        //then
        assertEquals(expected, calculator.display());
    }

    @Test
    public void shouldDisplayEmptyStringAtStartup() {
        String display = calculator.display();

        assertTrue(display.isEmpty());
    }

    @Test
    public void shouldDisplayNumberAfterPress() {

        //given
        int numberToPress = 3;
        String expectedDisplay = "3";

        //when
        calculator.pressNumber(numberToPress);
        String display = calculator.display();

        //then
        assertEquals(expectedDisplay, display);
    }
}