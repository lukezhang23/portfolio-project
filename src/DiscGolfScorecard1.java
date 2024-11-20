import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code DiscGolfScorecard} represented as an array with implementations of
 * primary methods.
 *
 * @convention 0 < $this.currentHoleNumber <= |$this.rep| and 0 <
 *             $this.startingHoleNumber <= |$this.rep| and [all holes in
 *             $this.rep have entries >= 0]
 * @correspondence this = [holes in this.rep with initial starting hole
 *                 $this.startingHoleNumber and current hole
 *                 $this.currentHoleNumber]
 *
 * @author Luke Zhang
 */
public class DiscGolfScorecard1 extends DiscGolfScorecardSecondary {

    /*
     * Private members ---------------------------------------------------------
     */

    /**
     * Default length of scorecard.
     */
    private static final int DEFAULT_SCORECARD_LENGTH = 18;

    /**
     * Default starting hole.
     */
    private static final int DEFAULT_STARTING_HOLE = 1;

    /**
     * Default par.
     */
    private static final int DEFAULT_PAR = 3;

    /**
     * Default distance.
     */
    private static final int DEFAULT_DISTANCE = 0;

    /**
     * Default strokes.
     */
    private static final int DEFAULT_STROKES = 0;

    /**
     * Current hole number.
     */
    private int currentHoleNumber;

    /**
     * Starting hole number.
     */
    private int startingHoleNumber;

    /**
     * Representation of {@code this}.
     */
    private Hole[] rep;

    /**
     * Creator of inital representation.
     *
     * @param startingHole
     *            the first hole returned in scorecard
     * @param distances
     *            array of the distances for each hole
     * @param pars
     *            array of the pars for each hole
     * @param strokes
     *            array of the strokes for each hole
     * @requires |pars| = |distances| = |strokes| and |pars| > 0 and 0 &lt;
     *           startingHole <= |pars| and no entries in pars or distances or
     *           strokes can be < 0
     * @ensures |this.rep| = |pars| and this.scorecard[is a scorecard with holes
     *          with the specified pars, distances, and strokes]
     */
    private void createNewRep(int startingHole, int[] pars, int[] distances,
            int[] strokes) {
        assert pars.length == distances.length
                && distances.length == strokes.length : "Violation of "
                        + "[|pars| = |distances| = |strokes|]";
        assert pars.length > 0 : "Violation of [|pars| > 0]";
        assert 0 < startingHole && startingHole <= pars.length : "Violation of "
                + "[0 < startingHole <= |pars|]";
        //Precondition of no entries < 0 in pars, distances or strokes not checked
        this.rep = new Hole[pars.length];
        this.startingHoleNumber = startingHole;
        this.currentHoleNumber = startingHole;
        for (int i = 0; i < pars.length; i++) {
            this.rep[i] = new Hole(pars[i], distances[i], strokes[i]);
        }
    }

    /*
     * Constructors ------------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public DiscGolfScorecard1() {
        int[] pars = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(pars, DEFAULT_PAR);
        int[] distances = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(distances, DEFAULT_DISTANCE);
        int[] strokes = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(strokes, DEFAULT_STROKES);
        this.createNewRep(DEFAULT_STARTING_HOLE, pars, distances, strokes);
    }

    /**
     * Constructor resulting in a scorecard of length {@code scorecardLength}.
     *
     * @param scorecardLength
     *            number of holes in scorecard
     * @requires scorecardLength > 0
     * @ensures this = [default scorecard with length scorecardLength]
     */
    public DiscGolfScorecard1(int scorecardLength) {
        assert scorecardLength > 0 : "Violation of [scorecardLength > 0]";
        int[] pars = new int[scorecardLength];
        Arrays.fill(pars, DEFAULT_PAR);
        int[] distances = new int[scorecardLength];
        Arrays.fill(distances, DEFAULT_DISTANCE);
        int[] strokes = new int[scorecardLength];
        Arrays.fill(strokes, DEFAULT_STROKES);
        this.createNewRep(DEFAULT_STARTING_HOLE, pars, distances, strokes);
    }

    /**
     * Constructor resulting in a scorecard of length {@code scorecardLength}
     * and starting hole {@code startingHole}.
     *
     * @param scorecardLength
     *            number of holes in scorecard
     * @param startingHole
     *            starting hole in scorecard
     * @requires scorecardLength > 0 and 0 < startingHole <= scorecardLength
     * @ensures this = [default scorecard with length scorecardLength]
     */
    public DiscGolfScorecard1(int scorecardLength, int startingHole) {
        assert 0 < startingHole
                && startingHole <= scorecardLength : "Violation of "
                        + "[0 < startingHole <= scorecardLength]";
        int[] pars = new int[scorecardLength];
        Arrays.fill(pars, DEFAULT_PAR);
        int[] distances = new int[scorecardLength];
        Arrays.fill(distances, DEFAULT_DISTANCE);
        int[] strokes = new int[scorecardLength];
        Arrays.fill(strokes, DEFAULT_STROKES);
        this.createNewRep(startingHole, pars, distances, strokes);
    }

    /**
     * Constructor resulting in a scorecard with specified {@code pars},
     * {@code distances}, and {@code strokes}.
     *
     * @param pars
     *            array of pars in scorecard
     * @param distances
     *            array of distances in scorecard
     * @param strokes
     *            array of strokes in scorecard
     * @requires |pars| = |distances| = |strokes| and |pars| > 0
     * @ensures this = [default scorecard with specified pars, distances, and
     *          strokes]
     */
    public DiscGolfScorecard1(int[] pars, int[] distances, int[] strokes) {
        assert pars.length == distances.length
                && distances.length == strokes.length : "Violation of "
                        + "[|pars| = |distances| = |strokes|]";
        assert pars.length > 0 : "Violation of [|pars| > 0]";
        this.createNewRep(DEFAULT_STARTING_HOLE, pars, distances, strokes);
    }

    /**
     * Constructor resulting in a scorecard with specified {@code pars},
     * {@code distances}, {@code strokes}, and with startingHole
     * {@code startingHole}.
     *
     * @param pars
     *            array of pars in scorecard
     * @param distances
     *            array of distances in scorecard
     * @param strokes
     *            array of strokes in scorecard
     * @param startingHole
     *            starting hole in scorecard
     * @requires @requires |pars| = |distances| = |strokes| and |pars| > 0 and 0
     *           &lt; startingHole &le; |pars|
     * @ensures this = [default scorecard with specified pars, distances, and
     *          strokes]
     */
    public DiscGolfScorecard1(int[] pars, int[] distances, int[] strokes,
            int startingHole) {
        assert pars.length == distances.length
                && distances.length == strokes.length : "Violation of "
                        + "[|pars| = |distances| = |strokes|]";
        assert pars.length > 0 : "Violation of [|pars| > 0]";
        assert 0 < startingHole && startingHole <= pars.length : "Violation of "
                + "[0 < startingHole <= |pars|]";
    }

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
        int[] pars = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(pars, DEFAULT_PAR);
        int[] distances = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(distances, DEFAULT_DISTANCE);
        int[] strokes = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(strokes, DEFAULT_STROKES);
        this.createNewRep(DEFAULT_STARTING_HOLE, pars, distances, strokes);
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
        this.currentHoleNumber = localSource.currentHoleNumber;
        this.startingHoleNumber = localSource.startingHoleNumber;

        //localSource cleared to default
        int[] pars = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(pars, DEFAULT_PAR);
        int[] distances = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(distances, DEFAULT_DISTANCE);
        int[] strokes = new int[DEFAULT_SCORECARD_LENGTH];
        Arrays.fill(strokes, DEFAULT_STROKES);
        localSource.createNewRep(DEFAULT_STARTING_HOLE, pars, distances,
                strokes);
    }

    /*
     * Kernel methods ----------------------------------------------------------
     */

    @Override
    public final Hole currentHole() {
        return this.rep[this.currentHoleNumber - 1];
    }

    @Override
    public final void replaceCurrentHole(Hole replacement) {
        this.rep[this.currentHoleNumber - 1] = replacement;
    }

    @Override
    public final void advanceHole() {
        this.currentHoleNumber = (this.currentHoleNumber + 1) % this.rep.length;
    }

    @Override
    public final int currentHoleNumber() {
        return this.currentHoleNumber;
    }

    @Override
    public final int startingHoleNumber() {
        return this.startingHoleNumber;
    }

    @Override
    public final int length() {
        return this.rep.length;
    }

    @Override
    public final Iterator<Hole> iterator() {
        return new DiscGolfScorecard1Iterator();
    }

    /**
     * Implementation of {@code Iterator} interface for
     * {@code DiscGolfScorecard1}.
     */
    private final class DiscGolfScorecard1Iterator implements Iterator<Hole> {
        /**
         * Current hole in the scorecard.
         */
        private Hole current;

        /**
         * Tracks the currentHoleNumber.
         */
        private int currentHoleNumber;

        /**
         * No-argument constructor.
         */
        private DiscGolfScorecard1Iterator() {
            this.current = DiscGolfScorecard1.this.rep[0];
            this.currentHoleNumber = 1;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public Hole next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be thrown in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            Hole result = this.current;
            this.currentHoleNumber++;
            if (this.currentHoleNumber < DiscGolfScorecard1.this.rep.length) {
                this.current = DiscGolfScorecard1.this.rep[this.currentHoleNumber
                        - 1];
            } else {
                this.current = null;
            }
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }
    }

    /*
     * Other methods (overridden for performance reasons) ----------------------
     */

    @Override
    public final void retreatHole() {
        this.currentHoleNumber = (this.currentHoleNumber - 1 + this.rep.length)
                % this.rep.length;
    }

}
