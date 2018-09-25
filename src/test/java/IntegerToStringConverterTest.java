import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class IntegerToStringConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testIntegerConvertsToString() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        Integer inputInteger = 14;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, Integer.toString(inputInteger));
    }

    @Test
    public void testMultipleOf3ReturnsFizz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        Integer inputInteger = 3;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Fizz");
    }

    @Test
    public void testMultipleOf5ReturnsBuzz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        Integer inputInteger = 5;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Buzz");
    }

    @Test
    public void testMultipleOf5And5ReturnsFizzBuzz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        Integer inputInteger = 15;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "FizzBuzz");
    }

    @Test
    public void testNegativeIntegerConvertsToString() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        Integer inputInteger = -14;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, Integer.toString(inputInteger));
    }

    @Test
    public void testNullThrowsIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("InputInteger has null value");
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        integerToStringConverter.convert(null);
    }
}
