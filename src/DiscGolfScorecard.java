import components.map.Map;
import components.map.Map2;

/**
 * @author Luke Zhang
 */
public class DiscGolfScorecard {

    /*
     * Private members --------------------------------------------------------
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
     * Array of DiscGolfHoles to store scorecard.
     */
    private DiscGolfHole[] scorecard;

    /**
     * Creator of inital representation.
     *
     * @param scorecardSize
     *            number of holes in scorecard
     * @param startingHole
     *            the first hole returned in scorecard
     * @requires scorecardSize > 0 and 0 < startingHole <= scorecardSize
     * @ensures |$this.scorecard| = scorecardSize and this.scorecard[is a
     *          scorecard with holes]
     */
    private void createNewRep(int scorecardSize, int startingHole) {
        this.scorecard = new DiscGolfHole[scorecardSize];
        this.currentHole = startingHole;

        //Add a default hole to each element of the array.
        for (int i = 0; i < scorecardSize; i++) {
            this.scorecard[i] = new DiscGolfHole();
        }
    }

    /**
     * Creator of inital representation.
     *
     * @param scorecardSize
     *            number of holes in scorecard
     * @param startingHole
     *            the first hole returned in scorecard
     * @param pars
     *            array of the pars for each hole
     * @requires scorecardSize > 0 and 0 < startingHole <= scorecardSize and
     *           scorecardSize = |pars| and for all x: int where (x is in pars)
     *           x >= 0
     * @ensures |$this.scorecard| = scorecardSize and this.scorecard[is a
     *          scorecard with holes with the specified pars]
     */
    private void createNewRep(int scorecardSize, int startingHole, int[] pars) {
        this.scorecard = new DiscGolfHole[scorecardSize];
        this.currentHole = startingHole;

        //Add a hole to each element of the array.
        for (int i = 0; i < scorecardSize; i++) {
            this.scorecard[i] = new DiscGolfHole(pars[i]);
        }
    }

    /**
     * Creator of inital representation.
     *
     * @param scorecardSize
     *            number of holes in scorecard
     * @param startingHole
     *            the first hole returned in scorecard
     * @param pars
     *            array of the pars for each hole
     * @param distances
     *            array of the distances for each hole
     * @requires scorecardSize > 0 and 0 < startingHole <= scorecardSize and
     *           scorecardSize = |pars| = |distances| and for all x: int where
     *           (x is in pars or distances) x >= 0
     * @ensures |$this.scorecard| = scorecardSize and this.scorecard[is a
     *          scorecard with holes with the specified pars and distances]
     */
    private void createNewRep(int scorecardSize, int startingHole, int[] pars,
            int[] distances) {
        this.scorecard = new DiscGolfHole[scorecardSize];
        this.currentHole = startingHole;

        //Add a hole to each element of the array.
        for (int i = 0; i < scorecardSize; i++) {
            this.scorecard[i] = new DiscGolfHole(pars[i], distances[i]);
        }
    }

    /**
     * Creator of inital representation.
     *
     * @param scorecardSize
     *            number of holes in scorecard
     * @param startingHole
     *            the first hole returned in scorecard
     * @param distances
     *            array of the distances for each hole
     * @param pars
     *            array of the pars for each hole
     * @param strokes
     *            array of the strokes for each hole
     * @requires scorecardSize > 0 and 0 < startingHole <= scorecardSize and
     *           scorecardSize = |pars| = |distances| = |strokes| and for all x:
     *           int where (x is in pars or distances or strokes) x >= 0
     * @ensures |$this.scorecard| = scorecardSize and this.scorecard[is a
     *          scorecard with holes with the specified pars, distances, and
     *          strokes]
     */
    private void createNewRep(int scorecardSize, int startingHole, int[] pars,
            int[] distances, int[] strokes) {
        this.scorecard = new DiscGolfHole[scorecardSize];
        this.currentHole = startingHole;

        //Add a hole to each element of the array.
        for (int i = 0; i < scorecardSize; i++) {
            this.scorecard[i] = new DiscGolfHole(pars[i], distances[i],
                    strokes[i]);
        }
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public DiscGolfScorecard() {
        this.createNewRep(DEFAULT_SCORECARD_SIZE, DEFAULT_STARTING_HOLE);
    }

    /**
     * Constructor resulting in a scorecard of size {@code scorecardSize}.
     *
     * @param scorecardSize
     *            number of holes in scorecard
     * @requires scorecardSize > 0
     * @ensures this = [empty scorecard with size scorecardSize]
     */
    public DiscGolfScorecard(int scorecardSize) {
        this.createNewRep(scorecardSize, DEFAULT_STARTING_HOLE);
    }

    // More constructors will be written after proof of concept.

    /**
     * {@code DiscGolfHole} represented as a {@code Map}.
     */
    public class DiscGolfHole {

        /**
         * Default par value.
         */
        private static final int DEFAULT_PAR_VALUE = 3;

        /**
         * Default distance value.
         */
        private static final int DEFUALT_DISTANCE_VALUE = 0;

        /**
         * Default strokes value.
         */
        private static final int DEFUALT_STROKES_VALUE = 0;

        /**
         * Map to store hole information.
         */
        private Map2<String, Integer> hole;

        /**
         * Creator of inital representation.
         *
         * @param par
         *            par of hole
         * @param distance
         *            distance of hole
         * @param strokes
         *            score on hole
         * @requires par >= 0 and distance >= 0 and score >= 0
         *
         * @ensures this.hole [is a hole with the specified distance, par and
         *          score].
         */
        private void createNewRep(int par, int distance, int strokes) {
            this.hole = new Map2<String, Integer>();
            this.hole.add("par", par);
            this.hole.add("distance", distance);
            this.hole.add("strokes", strokes);
        }

        /**
         * No-argument constructor.
         */
        public DiscGolfHole() {
            this.createNewRep(DEFAULT_PAR_VALUE, DEFUALT_DISTANCE_VALUE,
                    DEFUALT_STROKES_VALUE);
        }

        /**
         * Constructor resulting in hole with par {@code par}.
         *
         * @param par
         *            par of hole
         * @requies par >= 0
         * @ensures this = [hole with specified par]
         */
        public DiscGolfHole(int par) {
            this.createNewRep(par, DEFUALT_DISTANCE_VALUE,
                    DEFUALT_STROKES_VALUE);
        }

        /**
         * Constructor resulting in hole with par {@code par} and distance
         * {@code distance}.
         *
         * @param par
         *            par of hole
         * @param distance
         *            distance of hole
         * @requies par >= 0 and distance >= 0
         * @ensures this = [hole with specified par and distance]
         */
        public DiscGolfHole(int par, int distance) {
            this.createNewRep(par, distance, DEFUALT_STROKES_VALUE);
        }

        /**
         * Constructor resulting in hole with par {@code par}, distance
         * {@code distance}, and strokes {@code strokes}.
         *
         * @param par
         *            par of hole
         * @param distance
         *            distance of hole
         * @param strokes
         *            score of hole
         * @requies par >= 0 and distance >= 0 and strokes >= 0
         * @ensures this = [hole with specified par, distance and strokes]
         */
        public DiscGolfHole(int par, int distance, int strokes) {
            this.createNewRep(par, distance, strokes);
        }

        /**
         * Reports original score and replaces it with {@code score}.
         *
         * @param strokes
         *            the new strokes
         * @return the original strokes
         * @updates this
         * @requires strokes >= 0
         * @ensures changeStrokes = [the original strokes] and this = [hole with
         *          the new specified strokes value]
         */
        public int changeStrokes(int strokes) {
            Map.Pair<String, Integer> original = this.hole.remove("strokes");
            this.hole.add("strokes", strokes);
            return original.value();
        }
    }

    /**
     * Returns the current {@code DiscGolfHole} in scorecard.
     *
     * @return Current {@code DiscGolfHole}
     * @aliases reference returned by {@code currentHole}
     * @ensures currentHole = [the corresponding current hole in scorecard]
     */
    public DiscGolfHole currentHole() {
        return this.scorecard[this.currentHole - 1];
    }

    /**
     * Returns the next {@code DiscGolfHole} in scorecard.
     *
     * @return Next {@code DiscGolfHole}
     * @aliases reference returned by {@code nextHole}
     * @updates {@code this}
     * @ensures currentHole = [the corresponding next hole in scorecard] and the
     *          current hole of {@code this} is updated to the next hole.
     */
    public DiscGolfHole nextHole() {

        //If at the end of scorecard go back to hole 1, otherwise increment hole
        if (this.currentHole == this.scorecard.length) {
            this.currentHole = 1;
        } else {
            this.currentHole++;
        }
        return this.scorecard[this.currentHole - 1];
    }

    /**
     * Returns the total amount of strokes in scorecard.
     *
     * @return total of strokes from all holes in scorecard.
     * @ensures totalStrokes = [total of strokes in all holes]
     */
    public int totalStrokes() {
        int total = 0;

        //Add up strokes of all holes
        for (int i = 0; i < this.scorecard.length; i++) {
            total += this.scorecard[i].hole.value("strokes");
        }
        return total;
    }

    /**
     * Returns the total amount of par in scorecard.
     *
     * @return total of pars from all holes in scorecard.
     * @ensures totalPar = [total of pars in all holes]
     */
    public int totalPar() {
        int total = 0;

        //Add up pars of all holes
        for (int i = 0; i < this.scorecard.length; i++) {
            total += this.scorecard[i].hole.value("par");
        }
        return total;
    }

    /**
     * Returns the total score in scorecard.
     *
     * @return total of score from all holes in scorecard.
     * @ensures totalScore = [grand total of strokes minus grand total of pars]
     */
    public int totalScore() {
        return this.totalStrokes() - this.totalPar();
    }

    /**
     * Main Method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        DiscGolfScorecard balgriffin = new DiscGolfScorecard(9);
        balgriffin.currentHole().changeStrokes(2);
        balgriffin.nextHole().changeStrokes(2);
        balgriffin.nextHole().changeStrokes(3);
        balgriffin.nextHole().changeStrokes(3);
        balgriffin.nextHole().changeStrokes(3);
        balgriffin.nextHole().changeStrokes(4);
        balgriffin.nextHole().changeStrokes(2);
        balgriffin.nextHole().changeStrokes(2);
        balgriffin.nextHole().changeStrokes(2);
        System.out.print("Total Strokes: ");
        System.out.println(balgriffin.totalStrokes());
        System.out.print("Total Par: ");
        System.out.println(balgriffin.totalPar());
        System.out.print("Total Score: ");
        System.out.println(balgriffin.totalScore());
    }
}
