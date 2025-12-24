package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTests {
    private Animal animal;
    private static final String HERBIVORE = "Травоядное";
    private static final String PREDATOR = "Хищник";
    private static final List<String> HERBIVORE_FOOD = List.of("Трава", "Различные растения");
    private static final List<String> PREDATOR_FOOD = List.of("Животные", "Птицы", "Рыба");

    private final String animalKind;
    private final List<String> foods;

    public AnimalParameterizedTests(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {HERBIVORE, HERBIVORE_FOOD},
                {PREDATOR, PREDATOR_FOOD}
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals("Фактический список еды не соответствует ожидаемому", foods, actual);
    }
}
