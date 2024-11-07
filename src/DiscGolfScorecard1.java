/**
 * {@code DiscGolfScorecard} represented as an array with implementations of
 * primary methods.
 *
 * @convention
 * @correspondence
 *
 * @author Luke Zhang
 */
public class DiscGolfScorecard1 extends DiscGolfScorecardSecondary {

    /**
     * Hole class for scorecard holes.
     */
    static class Hole implements DiscGolfScorecard.Hole {

        /**
         * Par of hole.
         */
        private int par;

        /**
         * Distance of hole.
         */
        private int distance;

        /**
         * Strokes of hole.
         */
        private int strokes;

        @Override
        public final int par() {
            return this.par;
        }

        @Override
        public final int distance() {
            return this.distance;
        }

        @Override
        public final int strokes() {
            return this.strokes;
        }

        @Override
        public final void changePar(int par) {
            this.par = par;
        }

        @Override
        public final void changeDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public final void changeStrokes(int strokes) {
            this.strokes = strokes;
        }
    }

    /*
     * Private members ---------------------------------------------------------
     */

    /**
     * Default size of scorecard.
     */
    private static final int DEFAULT_SCORECARD_SIZE = 18;

    /**
     * Default starting hole.
     */
    private static final int DEFAULT_STARTING_HOLE = 1;

    /**
     * Current hole.
     */
    private int currentHole;

    /**
     * Representation of {@code this}.
     */
    private Hole[] rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep(int scorecardSize, int startingHole, int[] pars,
            int[] distances, int[] strokes);

    /*
     * Constructors ------------------------------------------------------------
     */

    /*
     * Standard methods --------------------------------------------------------
     */

    @Override
    public final DiscGolfScorecard newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {

        //TODO: Fill in body

    }

    @Override
    public final void transferFrom(DiscGolfScorecard source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof DiscGolfScorecard1 : ""
                + "Violation of: source is of dynamic type DiscGolfScorecard1";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        DiscGolfScorecard1 localSource = (DiscGolfScorecard1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
        //TODO: make sure createNewRep makes sense
    }

    /*
     * Kernel methods ----------------------------------------------------------
     */

    @Override
    public final DiscGolfScorecard.Hole nextHole() {
        if (this.currentHole >= this.rep.length) {
            this.currentHole = 1;
        } else {
            this.currentHole++;
        }
        return this.rep[this.currentHole - 1];
    }

    @Override
    public final int currentHole() {
        return this.currentHole;
    }

    @Override
    public final int length() {
        return this.rep.length;
    }

}
