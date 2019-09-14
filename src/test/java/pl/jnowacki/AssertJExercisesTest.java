package pl.jnowacki;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AssertJExercisesTest {

    @Test
    public void fiveShouldBeGreaterThanThree() {
        assertThat(5).isGreaterThan(3);
    }

    @Test
    public void emptyStringShouldBeEmpty() {
        assertThat("").isNullOrEmpty();
    }

    @Test
    public void doesStringContainKonfabulacja() {
        assertThat("afdsfdsfdsfaqwtjfvvjfyu".toLowerCase())
                .doesNotContain("konfabulacja");
    }

    @Test
    public void doesArrayContainRightValues() {

        int[] values = {5, 7, 2};

        assertThat(values)
                .containsExactly(5, 7, 2);
    }

    @Test
    public void doesArrayContainRightValuesInAnyOrder() {

        int[] values = {5, 7, 2};

        assertThat(values)
                .containsExactlyInAnyOrder(2, 5, 7);
    }

    @Test
    public void doesListContainAndHasRightLength() {

        List<String> values = Arrays.asList("raz", "dwa", "trzy");

        assertThat(values)
                .hasSize(3)
                .contains("dwa");
    }
}
