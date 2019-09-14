package pl.jnowacki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private PeopleRepository peopleRepository;

    @Test
    public void testMock() {
        when(peopleRepository.findOne()).thenReturn(new Person(23));

        assertEquals(peopleRepository.findOne().getAge(), 23);
    }
}
