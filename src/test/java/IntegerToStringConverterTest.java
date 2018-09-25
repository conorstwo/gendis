import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class IntegerToStringConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testIntegerConvertsToString() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fizz", "Buzz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = 14;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, Integer.toString(inputInteger));
    }

    @Test
    public void testMultipleOf3ReturnsFizz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fizz", "Buzz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = 3;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Fizz");
    }

    @Test
    public void testMultipleOf5ReturnsBuzz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fizz", "Buzz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = 5;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Buzz");
    }

    @Test
    public void testMultipleOf5And5ReturnsFizzBuzz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fizz", "Buzz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = 15;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "FizzBuzz");
    }

    @Test
    public void testFuzzBizz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fuzz", "Bizz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = 15;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "FuzzBizz");
    }

    @Test
    public void testFuzz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fuzz", "Bizz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = 3;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Fuzz");
    }

    @Test
    public void testBizz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fuzz", "Bizz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = 5;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Bizz");
    }

    @Test
    public void testNegativeIntegerConvertsToString() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fizz", "Buzz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        Integer inputInteger = -14;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, Integer.toString(inputInteger));
    }

    @Test
    public void testNullThrowsIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("InputInteger has null value");
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fizz", "Buzz",
                (value) -> value % 3 == 0, (value) -> value % 5 == 0);
        integerToStringConverter.convert(null);
    }

    @Test
    public void testFozz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fozz", "Bozz",
                (value) -> value % 2 == 0, (value) -> value % 2 != 0);
        Integer inputInteger = 4;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Fozz");
    }

    @Test
    public void testBozz() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter("Fozz", "Bozz",
                (value) -> value % 2 == 0, (value) -> value % 2 != 0);
        Integer inputInteger = 5;
        String convertedString = integerToStringConverter.convert(inputInteger);
        assertEquals(convertedString, "Bozz");
    }
}
