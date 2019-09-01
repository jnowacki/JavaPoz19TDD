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

    @Test
    public void shouldHaveEmptyScreenAfterClear() {

        // given
        calculator.pressNumber(5);
        assertEquals("5", calculator.display());

        // when
        calculator.clear();

        // then
        assertTrue(calculator.display().isEmpty());
    }

    @Test
    public void shouldAddDifferentNumbers() {
        shouldAddCorrectly(2, 5, "7");
        shouldAddCorrectly(1, 3, "4");
    }

    private void shouldAddCorrectly(int a, int b, String expectedResult) {

        // when
        calculator.add(a, b);

        //then
        assertEquals(expectedResult, calculator.display());
    }

    @Test
    public void shouldDisplayCorrectValuesWhenAddingTwice() {
        // given
        int numberA = 2;
        int numberB = 1;
        String expected = "3";
        calculator.add(numberA, numberB);
        assertEquals(expected, calculator.display());

        numberA = 3;
        numberB = 5;
        expected = "8";

        // when
        calculator.add(numberA, numberB);

        // then
        assertEquals(expected, calculator.display());
    }

    @Test
    public void shouldSubtractNumbersCorrectly() {
        // given
        int numberA = 4;
        int numberB = 2;

        String expected = "2";

        // when
        calculator.sub(numberA, numberB);

        //then
        assertEquals(expected, calculator.display());
    }

    @Test
    public void shouldSubtractNumbersCorrectlyTwice() {
        // given
        int numberA = 4;
        int numberB = 2;
        String expected = "2";

        calculator.sub(numberA, numberB);

        numberA = 3;
        numberB = 5;
        expected = "-2";

        calculator.sub(numberA, numberB);

        //then
        assertEquals(expected, calculator.display());
    }
}