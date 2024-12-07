package components.discgolfscorecard;

/**
 * {@code DiscGolfScorecardKernel} enhanced with secondary methods.
 */
public interface DiscGolfScorecard extends DiscGolfScorecardKernel {

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
     * Advances {@code this} to hole {@code num}.
     *
     * @param num
     *            the number of the hole to set as current hole
     * @updates this
     * @requires {@code 1 <= num and num <= |this]}
     * @ensures the current hole of this is {@code num}
     */
    void advanceHole(int num);

    /**
     * Retreats {@code this} to the previous hole.
     *
     * @updates this
     * @ensures if current hole number of {@code this} is 1: sets current hole
     *          to |this| in {@code this}, else: decrements current hole of
     *          {@code this}
     */
    void retreatHole();

    /**
     * Reports the total par in {@code this}.
     *
     * @return the total par in {@code this}
     * @ensures {@code <totalPar> is total par of this}
     */
    int totalPar();

    /**
     * Reports the total par in {@code this} after hole {@code num}.
     *
     * @param num
     *            the hole number that will be the last to be calculated in
     *            totalPar
     * @return the total par in {@code this} from the starting hole to hole
     *         {@code num}
     * @requires {@code 1 <= num <= |this|}
     * @ensures {@code <totalPar> is total par of this
     * from the starting hole to hole @code num (inclusive)}
     */
    int totalPar(int num);

    /**
     * Reports the total distance in {@code this}.
     *
     * @return the total distance in {@code this}
     * @ensures {@code <totalDistance> is total distance of this}
     */
    int totalDistance();

    /**
     * Reports the total distance in {@code this} after hole {@code num}.
     *
     * @param num
     *            the hole number that will be the last to be calculated in
     *            totalDistance
     * @return the total distance in {@code this} from the starting hole to hole
     *         {@code num}
     * @requires {@code 1 <= num <= |this|}
     * @ensures {@code <totalDistance> is total distance of this
     * from the starting hole to hole @code num (inclusive)}
     */
    int totalDistance(int num);

    /**
     * Reports the total strokes in {@code this}.
     *
     * @return the total strokes in {@code this}
     * @ensures {@code <totalStrokes> is total strokes of this}
     */
    int totalStrokes();

    /**
     * Reports the total strokes in {@code this} after hole {@code num}.
     *
     * @param num
     *            the hole number that will be the last to be calculated in
     *            totalStrokes
     * @return the total strokes in {@code this} from the starting hole to hole
     *         {@code num}
     * @requires {@code 1 <= num <= |this|}
     * @ensures {@code <totalStrokes> is total strokes of this
     * from the starting hole to hole @code num (inclusive)}
     */
    int totalStrokes(int num);

    /**
     * Reports the total score (total strokes - total par) in {@code this}.
     *
     * @return the total score in {@code this}
     * @ensures {@code <totalScore> is total score of this}
     */
    int totalScore();

    /**
     * Reports the total score (total strokes - total par) in {@code this} after
     * hole {@code num}.
     *
     * @param num
     *            the hole number that will be the last to be calculated in
     *            totalScore
     * @return the total score in {@code this} from the starting hole to hole
     *         {@code num}
     * @requires {@code 1 <= num <= |this|}
     * @ensures {@code <totalScore> is total score of this
     * from the starting hole to hole @code num (inclusive)}
     */
    int totalScore(int num);

    /**
     * Reports the total holes with strokes > 0 in {@code this}.
     *
     * @return the total holes with strokes > 0 in {@code this}
     * @ensures {@code <holesPlayed> is total holes with strokes > 0 in this}
     */
    int holesPlayed();

    /**
     * Reports the hole furthest from the starting hole that has strokes > 0 in
     * {@code this} or 0 if no holes have strokes > 0.
     *
     * @return the hole furthest from the starting hole that has strokes > 0 in
     *         {@code this} or 0 if no holes have strokes > 0.
     * @ensures {@code if no holes have strokes > 0: <furthestHolePlayed> = 0,
     * else: <furthestHolePlayed> = the hole with highest holeDistance and strokes > 0}
     *          holeDistance = if holeNumber >= startingHole: holeNumber -
     *          startingHole else: (|this| - startingHole) + holeNumber
     */
    int furthestHolePlayed();

}
