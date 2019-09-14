package pl.jnowacki;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class ThreeLetterItemsMatcher extends TypeSafeMatcher<List<String>> {

    public static ThreeLetterItemsMatcher hasOnly3LetterItems() {
        return new ThreeLetterItemsMatcher();
    }

    @Override
    protected boolean matchesSafely(List<String> strings) {
        return strings.stream().allMatch(item -> item.length() == 3);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has only items with 3 letters");
    }
}

