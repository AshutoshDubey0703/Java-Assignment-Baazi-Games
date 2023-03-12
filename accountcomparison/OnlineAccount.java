package accountcomparison;

/**
 * Since interface fields are public static final by default,
 * which means they are constants,
 * hence using the java naming convention for constants.
 * Also, assuming the cost to de double here,
 * so that it can be downcast to int and
 * we can also use the double value if required.
 */
public interface OnlineAccount {
    double BASE_PRICE = 50;
    double REGULAR_MOVIE_PRICE = 10;
    double EXCLUSIVE_MOVIE_PRICE = 20;
}
