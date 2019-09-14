package pl.jnowacki;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static pl.jnowacki.SchoolAgePersonMatcher.isEligibleForSchool;
import static pl.jnowacki.LetterCountItemsMatcher.hasGivenLetterCountItems;

public class HamcrestExercisesTest {

    @Test
    public void fiveShouldBeGreaterThanThree() {
        assertThat(5, greaterThan(3));
    }

    @Test
    public void emptyStringShouldBeEmpty() {
        assertThat("", isEmptyOrNullString());
    }

    @Test
    public void doesStringContainKonfabulacja() {
        assertThat("afdsfdsfdsfaqwtjjfvvjfyu",
                not(containsString("konfabulacja")));
    }

    @Test
    public void doesArrayContainRightValues() {

        Integer[] values = {5, 7, 2};

        assertThat(values, arrayContaining(5, 7, 2));
    }

    @Test
    public void doesListContainAndHasRightLength() {

        List<String> values = Arrays.asList("raz", "dwa", "trzy");

        assertThat(values, hasItem("dwa"));
        assertThat(values, hasSize(3));
    }

    @Test
    public void shouldBeginWithA() {
        String testedValue = "aString";

        assertThat(testedValue, beginsWith(is('a')));

    }

    @Test
    public void shouldHaveLength3() {
        String testedValue = "asd";

        assertThat(testedValue, hasLength(is(3)));
    }

    @Test
    public void shouldHaveLength6() {
        String testedValue = "asdasd";

        assertThat(testedValue, hasLength(is(6)));
    }

    @Test
    public void shouldHaveLength12() {
        String testedValue = "asdasdasdasd";

        assertThat(testedValue, hasLength(is(12)));
    }

    public static Matcher<String> beginsWith(Matcher<? super Character> matcher) {
        return new FeatureMatcher<String, Character>(matcher, "a String that begins with", "first letter") {
            @Override
            protected Character featureValueOf(String actual) {
                return actual.charAt(0);
            }
        };
    }

    public static Matcher<String> hasLength(Matcher<? super Integer> matcher) {
        return new FeatureMatcher<String, Integer>(matcher, "a String that has length", "string length") {
            @Override
            protected Integer featureValueOf(String actual) {
                return actual.length();
            }
        };
    }

    public static Matcher<NumberWrapper> doesReturn15(Matcher<? super Integer> matcher) {
        return new FeatureMatcher<NumberWrapper, Integer>(matcher, "Number wrapper that returns 15", "NumberWrapper return value") {
            @Override
            protected Integer featureValueOf(NumberWrapper actual) {
                return actual.getNumber();
            }
        };
    }

    @Test
    public void shouldReturn15() {
        assertThat(new NumberWrapper(), doesReturn15(is(15)));
    }

    @Test
    public void testIfHasOnly4LetterItems() {
        List<String> listUnderTest = Arrays.asList("onea", "twoa");

        assertThat(listUnderTest, hasGivenLetterCountItems(4));
    }

    @Test
    public void testPersonAgeForSchool () {

        Person person = new Person(1);

        assertThat(person, not(isEligibleForSchool()));
    }

    @Test
    public void testPerson1AgeForSchool () {

        Person person = new Person(6);

        assertThat(person, isEligibleForSchool());
    }

    @Test
    public void testPerson2AgeForSchool () {

        Person person = new Person(12);

        assertThat(person, isEligibleForSchool());
    }


}
