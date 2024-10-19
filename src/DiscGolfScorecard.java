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
         * Replaces the par of {@code this} with {@code par} and returns the old
         * par.
         *
         * @param par
         *            the par replacing the old one
         * @return the old par
         * @updates this
         * @requires {@code par >= 0}
         * @ensures {@code <changePar> = previous value of par
         *  and this has specified par as new par}
         */
        int changePar(int par);

        /**
         * Replaces the distance of {@code this} with {@code distance} and
         * returns the old distance.
         *
         * @param distance
         *            the distance replacing the old one
         * @return the old distane
         * @updates this
         * @requires {@code distance >= 0}
         * @ensures {@code <changeDistance> = previous value of eistance
         *  and this has specified distance as new distance}
         */
        int changeDistance(int distance);

        /**
         * Replaces the strokes of {@code this} with {@code strokes} and returns
         * the old strokes.
         *
         * @param strokes
         *            the strokes replacing the old one
         * @return the old strokes
         * @updates this
         * @requires {@code strokes >= 0}
         * @ensures {@code <changeStrokes> = previous value of strokes
         *  and this has specified strokes as new strokes}
         */
        int changeStrokes(int strokes);

    }

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
