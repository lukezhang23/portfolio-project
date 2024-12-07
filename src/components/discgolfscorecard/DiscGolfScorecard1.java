package components.discgolfscorecard;

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
     * @param scorecardLength
     *            the length of the scorecard
     * @requires scorecardLength > 0
     * @ensures [|$this.rep| = scorecardLength] and [$this.startingHoleNumber =
     *          $this.currentHoleNumber = DEFAULT_STARTING_HOLE] and [each entry
     *          in $this.rep is a default hole]
     */
    private void createNewRep(int scorecardLength) {
        assert scorecardLength > 0 : "Violation of [scorecardLength > 0]";
        this.rep = new Hole[scorecardLength];
        this.startingHoleNumber = DEFAULT_STARTING_HOLE;
        this.currentHoleNumber = DEFAULT_STARTING_HOLE;
        for (int i = 0; i < scorecardLength; i++) {
            this.rep[i] = new Hole(DEFAULT_PAR, DEFAULT_DISTANCE,
                    DEFAULT_STROKES);
        }
    }

    /*
     * Constructors ------------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public DiscGolfScorecard1() {
        this.createNewRep(DEFAULT_SCORECARD_LENGTH);
    }

    /**
     * Constructor that takes scorecardLength input.
     *
     * @param scorecardLength
     *            number of holes in scorecard
     */
    public DiscGolfScorecard1(int scorecardLength) {
        assert scorecardLength > 0 : "Violation of [scorecardLength > 0]";
        this.createNewRep(scorecardLength);
    }

    /**
     * Constructor that takes startingHole input.
     *
     * @param scorecardLength
     *            number of holes in scorecard
     * @param startingHole
     *            starting hole in scorecard
     */
    public DiscGolfScorecard1(int scorecardLength, int startingHole) {
        assert 1 <= startingHole
                && startingHole <= scorecardLength : "Violation of "
                        + "[1 <= startingHole <= scorecardLength]";
        this.createNewRep(scorecardLength);
        this.startingHoleNumber = startingHole;
        this.currentHoleNumber = startingHole;
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
        this.createNewRep(DEFAULT_SCORECARD_LENGTH);
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
        localSource.createNewRep(DEFAULT_SCORECARD_LENGTH);
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
        if (this.rep.length == 1) {
            this.currentHoleNumber = 1;
        } else {
            this.currentHoleNumber = (this.currentHoleNumber % this.rep.length)
                    + 1;
        }
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
            System.out.println("next Used");
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
        this.currentHoleNumber = ((this.currentHoleNumber - 2 + this.rep.length)
                % this.rep.length) + 1;
    }

}
