package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    private LionAlex lionAlex;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        lionAlex = new LionAlex(feline);
    }

    @Test
    public void getFriendsTest() {
        List<String> expected = List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
        List<String> actual = lionAlex.getFriends();
        assertEquals("Фактический список не соответствует ожидаемому", expected, actual);
    }

    @Test
    public void getPlaceOfLivingTest() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = lionAlex.getPlaceOfLiving();
        assertEquals("Фактическое место проживания не соответствует ожидаемому", expected, actual);
    }

    @Test
    public void getKittensTest() {
        int expected = 0;
        int actual = lionAlex.getKittens();
        assertEquals("Фактическое количество львят не соответствует ожидаемому", expected, actual);
    }
}
