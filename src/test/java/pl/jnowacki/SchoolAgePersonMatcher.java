package pl.jnowacki;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class SchoolAgePersonMatcher extends TypeSafeMatcher<Person> {

    public static SchoolAgePersonMatcher isEligibleForSchool() {
        return new SchoolAgePersonMatcher();
    }

    @Override
    protected boolean matchesSafely(Person person) {
        return person.getAge() >= 6;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is above 6 years");
    }
}
