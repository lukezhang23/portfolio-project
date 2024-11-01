/**
 * {@code DiscGolfScorecardKernel} enhanced with secondary methods.
 */
public interface DiscGolfScorecard extends DiscGolfScorecardKernel {

    /**
     * A DiscGolfScorecard entry. Tracks the data of par, distance, and strokes
     * of a hole.
     *
     * @initally {@code ():
     *  ensures
     *  this = <>
     * }
     */
    interface Hole {
        /**
         * Returns the par of {@code this}.
         *
         * @return the par of {@code this}.
         * @ensures {@code <par> is the par of this and <par> >= 0}
         */
        int par();

        /**
         * Returns the distance of {@code this}.
         *
         * @return the distance of {@code this}.
         * @ensures {@code <distance> is the par of this and <distance> >= 0}
         */
        int distance();

        /**
         * Returns the strokes of {@code this}.
         *
         * @return the strokes of {@code this}.
         * @ensures {@code <strokes> is the strokes of this and <strokes> >= 0}
         */
        int strokes();

        /**
         * Replaces the par of {@code this} with {@code par}.
         *
         * @param par
         *            the par replacing the old one
         * @updates this
         * @requires {@code par >= 0}
         * @ensures {@code this has specified par as new par}
         */
        void changePar(int par);

        /**
         * Replaces the distance of {@code this} with {@code distance}.
         *
         * @param distance
         *            the distance replacing the old one
         * @updates this
         * @requires {@code distance >= 0}
         * @ensures {@code this has specified distannce as new distance}
         */
        void changeDistance(int distance);

        /**
         * Replaces the strokes of {@code this} with {@code strokes}.
         *
         * @param strokes
         *            the strokes replacing the old one
         * @updates this
         * @requires {@code strokes >= 0}
         * @ensures {@code this has specified strokes as new strokes}
         */
        void changeStrokes(int strokes);

    }

    /**
     * Returns the hole at number {@code num} of {@code this}.
     *
     * @param num
     *            the number of the hole to return
     * @return the hole with that number
     * @aliases reference returned by {@code hole}
     * @requires {@code 1 <= num and num <= |this|}
     * @ensures {@code <hole> = the hole with number num}
     *
     */
    Hole hole(int num);

    /**
     * Reports the total par in {@code this}.
     *
     * @return the total par in {@code this}
     * @ensures {@code <totalPar> is total par of this}
     */
    int totalPar();

    /**
     * Reports the total distance in {@code this}.
     *
     * @return the total distance in {@code this}
     * @ensures {@code <totalDistances> is total distance of this}
     */
    int totalDistance();

    /**
     * Reports the total strokes in {@code this}.
     *
     * @return the total strokes in {@code this}
     * @ensures {@code <totalStrokes> is total strokes of this}
     */
    int totalStrokes();

    /**
     * Reports the total score in {@code this}.
     *
     * @return the total score in {@code this}
     * @ensures {@code <totalScore> is total score of this}
     */
    int totalScore();

    /**
     * Reports the total holes with strokes > 0 in {@code this}.
     *
     * @return the total holes with strokes > 0 in {@code this}
     * @ensures {@code <holesPlayed> is total holes with strokes > 0 in this}
     */
    int holesPlayed();

}
