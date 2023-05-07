package com.glotov.array.validator;


import com.glotov.array.validator.impl.StringArrayValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringArrayValidatorImplTest {

    private StringArrayValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new StringArrayValidatorImpl();
    }

    @Test
    public void testStringNumberValidateValidInput() {
        String input = "123";
        boolean result = validator.stringNumberValidate(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testStringNumberValidateInvalidInput() {
        String input = "12a3";
        boolean result = validator.stringNumberValidate(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void testStringArrayValidateValidInput() {
        String input = "1 2 3 4 5";
        boolean result = validator.stringArrayValidate(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testStringArrayValidateInvalidInput() {
        String input = "1 2 3 4 5 a";
        boolean result = validator.stringArrayValidate(input);
        Assertions.assertFalse(result);
    }
}
