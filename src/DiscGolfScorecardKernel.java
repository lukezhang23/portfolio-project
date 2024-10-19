import components.standard.Standard;

/**
 * DiscGolfScorecard kernel component with primary methods. (Note: by
 * package-wide convention, all references are non-null.)
 *
 * @initally {@code ():
 *  ensures
 *  this = <>
 * }
 * @iterator ~this.seen * ~this.unseen = this
 */
public interface DiscGolfScorecardKernel extends Standard<DiscGolfScorecard>,
                Iterable<DiscGolfScorecard.Hole> {
        /**
         * Returns the hole at the front of {@code this}.
         *
         * @return the next hole of {@code this}
         * @aliases reference returned by {@code nextHole}
         * @ensures {@code <nextHole> is the next hole of this}
         */
        DiscGolfScorecard.Hole nextHole();

        /**
         * Reports length of {@code this}.
         *
         * @return the number of holes in {@code this}
         * @ensures length = |this|
         */
        int length();
}
