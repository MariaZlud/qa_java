import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    private final String family = "Кошачьи";
    private final int kittens = 1;
    private int kittensCount = 3;

    @Spy
    Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Фактическое семейство не соответствует ожидаемому", family, actual);
    }

    @Test
    public void getKittensTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        assertEquals("Фактическое количество не соответствует ожидаемому", kittens, actual);
    }

    @Test
    public void testGetKittensTest() {
        int actual = feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals("Фактическое количество не соответствует ожидаемому", kittensCount, actual);
    }
}
