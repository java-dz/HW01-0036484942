package hr.fer.zemris.java.tecaj.hw1;

/**
 * This program calculates the i-th number of the Hofstadter's Q sequence. The
 * maximum number this program can come up with is {@linkplain Long#MAX_VALUE}.
 * The program accepts i as command line argument. This argument must be
 * positive – if not, an error is reported.
 *
 * @author Mario Bobic
 */
public class HofstadterQ {

    /**
     * This is the program's main method. Only one argument is expected and
     * processed.
     *
     * @param args one argument - the index of the wanted Q-sequence number
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Expected one and only one argument.");
            return;
        }

        int i = Integer.parseInt(args[0]);
        if (i < 0) {
            System.err.println("i must be a positive integer.");
            return;
        }

        long result = getQ(i);

        System.out.printf(
                "You requested calculation of %d. number of Hofstadter's Q-sequence."
                + "The requested number is %d.%n",
                i, result
        );
    }

    /**
     * Calculates and returns the i-th number of the Hofstadter Q sequence.
     * This method calculates the result using an array by formula:<br>
     * <code>Q(1) = Q(2) = 1,<br>
     * Q(N) = Q(n - Q(n-1)) + Q(n - Q(n-2))
     * </code>
     *
     * @param index index number to be calculated
     * @return the i-th number of the Hofstadter Q sequence
     */
    private static long getQ(int index) {
        long[] Q = new long[index];
        Q[0] = 1;
        Q[1] = 1;

        for (int i = 2; i < index; i++) {
            Q[i] = Q[(int) (i - Q[i - 1])] + Q[(int) (i - Q[i - 2])];
        }

        return Q[(int) index - 1];
    }

    /**
     * Calculates and returns the i-th number of the Hofstadter Q sequence.
     * This method calculates the result recursively by formula:<br>
     * <code>Q(1) = Q(2) = 1,<br>
     * Q(N) = Q(n - Q(n-1)) + Q(n - Q(n-2))
     * </code>
     *
     * @param index index number to be calculated
     * @return the i-th number of the Hofstadter Q sequence
     * @deprecated Causes {@linkplain StackOverflowError} for small numbers.
     */
    @SuppressWarnings("unused")
    @Deprecated
    private static long getQ(long index) {
        if (index == 1 || index == 2)
            return 1;

        return getQ(index - getQ(index-1)) + getQ(index - getQ(index-2));
    }

}
