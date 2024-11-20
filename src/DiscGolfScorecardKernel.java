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
public interface DiscGolfScorecardKernel
                extends Standard<DiscGolfScorecard>, Iterable<Hole> {
        /**
         * Returns the current hole of {@code this}.
         *
         * @return the current hole of {@code this}
         * @ensures this advances to the next hole and
         *          {@code <nextHole> is the next hole of this},
         */
        Hole currentHole();

        /**
         * Replaces the current hole of {@code this}.
         *
         * @param replacement
         *                the hole that will replace the current hole of
         *                {@code this}
         * @updates this
         * @ensures the current hole of {@code this} is {@code replacement} and
         *          the rest of {@code this} remains the same
         */
        void replaceCurrentHole(Hole replacement);

        /**
         * Advances {@code this} to the next hole.
         *
         * @updates this
         * @ensures if current hole number of {@code this} is length of
         *          {@code this}: sets current hole of {@code this} to 1, else:
         *          increments current hole of {@code this}
         */
        void advanceHole();

        /**
         * Returns the current hole number of {@code this}.
         *
         * @return the current hole number of {@code this}
         * @ensures {@code <currentHoleNumber> is the current hole number of this}
         */
        int currentHoleNumber();

        /**
         * Returns the starting hole number of {@code this}.
         *
         * @return the starting hole number of {@code this}
         * @ensures {@code <startingHoleNumber> is the starting hole number of this}
         */
        int startingHoleNumber();

        /**
         * Reports length of {@code this}.
         *
         * @return the number of holes in {@code this}
         * @ensures length = |this|
         */
        int length();
}
