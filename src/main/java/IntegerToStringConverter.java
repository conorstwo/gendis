public class IntegerToStringConverter {

    /**
     * Method to convert an input integer to its string equivalent
     * If null is provided an IllegalArgumentException is thrown
     */
    public String convert(Integer inputInteger) {
        //Check input is not null
        if (inputInteger == null) {
            throw new IllegalArgumentException("InputInteger has null value");
        }
        final boolean isDivisibleBy3 = inputInteger % 3 == 0;
        final boolean isDivisibleBy5 = inputInteger % 5 == 0;

        if (isDivisibleBy3 && isDivisibleBy5) {
            return "FizzBuzz";
        } else if (isDivisibleBy3) {
            return "Fizz";
        } else if (isDivisibleBy5) {
            return "Buzz";
        } else {
            return Integer.toString(inputInteger);
        }
    }
}
