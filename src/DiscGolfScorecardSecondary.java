/**
 * Layered implementations of secondary methods for {@code DiscGolfScorecard}.
 */
public abstract class DiscGolfScorecardSecondary implements DiscGolfScorecard {
    /*
     * Public members ----------------------------------------------------------
     */

    /*
     * Common methods (from Object) --------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < this.length(); i++) {
            DiscGolfScorecard.Hole hole = this.nextHole();
            result.append("(");
            result.append(Integer.toString(hole.par()));
            result.append(", ");
            result.append(Integer.toString(hole.distance()));
            result.append(", ");
            result.append(Integer.toString(hole.strokes()));
            result.append(")");
        }
        result.append("}");
        return result.toString();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        // FINISH THIS
        boolean result = true;
        if (this != obj) {
            if (obj == null || this.getClass() != obj.getClass()) {
                result = false;
            } else {
                DiscGolfScorecard scorecard = (DiscGolfScorecard) obj;
                //Checking equality of each hole in scorecard
                if (this.length() == scorecard.length()) {
                    int i = 0;
                    while (result && i < this.length()) {
                        result = this.nextHole().par() == scorecard.nextHole()
                                .distance()
                                && this.nextHole().distance() == scorecard
                                        .nextHole().distance()
                                && this.nextHole().strokes() == scorecard
                                        .nextHole().strokes();
                        i++;
                    }
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        int hash = this.length();
        for (int i = 0; i < this.length(); i++) {
            hash = hash + this.nextHole().par() + this.nextHole().distance()
                    + this.nextHole().strokes();
        }
        return hash;
    }

    /*
     * Other non-kernel methods ------------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Hole hole(int num) {
        boolean found = false;
        Hole result = this.nextHole();
        while (!found) {
            Hole hole = this.nextHole();
            if (this.currentHole() == num) {
                result = hole;
                found = true;
            }
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalPar() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            DiscGolfScorecard.Hole hole = this.nextHole();
            result += hole.par();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalDistance() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            DiscGolfScorecard.Hole hole = this.nextHole();
            result += hole.distance();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalStrokes() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            DiscGolfScorecard.Hole hole = this.nextHole();
            result += hole.strokes();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalScore() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            DiscGolfScorecard.Hole hole = this.nextHole();
            result += hole.strokes() - hole.par();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int holesPlayed() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            DiscGolfScorecard.Hole hole = this.nextHole();
            if (hole.strokes() > 0) {
                result++;
            }
        }
        return result;
    }

}
