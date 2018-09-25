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
        return Integer.toString(inputInteger);
    }
}
