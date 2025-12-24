package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTests {
    private Lion lion;
    private Feline feline;
    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void haveManeTest() throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }
}
