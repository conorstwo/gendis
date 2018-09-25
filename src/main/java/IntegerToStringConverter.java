import java.util.function.Predicate;

public class IntegerToStringConverter {

    private String returnValueForCondition1;
    private String returnValueForCondition2;
    private Predicate<Integer> predicateForCondition1;
    private Predicate<Integer> predicateForCondition2;

    public IntegerToStringConverter(String returnValueForCondition1, String returnValueForCondition2, Predicate<Integer> predicateForCondition1,
                                    Predicate<Integer> predicateForCondition2) {
        this.returnValueForCondition1 = returnValueForCondition1;
        this.returnValueForCondition2 = returnValueForCondition2;
        this.predicateForCondition1 = predicateForCondition1;
        this.predicateForCondition2 = predicateForCondition2;
    }

    /**
     * Method to convert an input integer to its string equivalent
     * If null is provided an IllegalArgumentException is thrown
     */
    public String convert(Integer inputInteger) {
        //Check input is not null
        if (inputInteger == null) {
            throw new IllegalArgumentException("InputInteger has null value");
        }
        final boolean doesPredicate1Match = predicateForCondition1.test(inputInteger);
        final boolean doesPredicate2Match = predicateForCondition2.test(inputInteger);

        if (doesPredicate1Match && doesPredicate2Match) {
            return returnValueForCondition1 + returnValueForCondition2;
        } else if (doesPredicate1Match) {
            return returnValueForCondition1;
        } else if (doesPredicate2Match) {
            return returnValueForCondition2;
        } else {
            return Integer.toString(inputInteger);
        }
    }
}
