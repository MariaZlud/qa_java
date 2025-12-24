package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion("Самец", feline);
        int count = 1;
        Mockito.when(feline.getKittens()).thenReturn(count);
        int actual = lion.getKittens();
        assertEquals("Фактическое количество не соответствует ожидаемому", count, actual);
        Mockito.verify(feline, times(1)).getKittens();
    }

    @Test
    public void doesHaveManeExceptionTest() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", feline)
        );
        assertEquals("Фактический текст не соответствует ожидаемому", "Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getFoodTest() throws Exception {
        lion = new Lion("Самец", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        List<String> actual = lion.getFood();
        assertEquals("Фактический список не совпадает с ожидаемым", food, actual);
        Mockito.verify(feline, times(1)).eatMeat();
    }
}
