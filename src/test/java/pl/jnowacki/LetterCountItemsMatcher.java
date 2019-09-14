package pl.jnowacki;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class LetterCountItemsMatcher extends TypeSafeMatcher<List<String>> {

    private int count;

    public LetterCountItemsMatcher(int count) {
        this.count = count;
    }

    public static LetterCountItemsMatcher hasGivenLetterCountItems(int count) {
        return new LetterCountItemsMatcher(count);
    }

    @Override
    protected boolean matchesSafely(List<String> strings) {
        return strings.stream().allMatch(item -> item.length() == count);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has only items with " + count + " letters");
    }
}

