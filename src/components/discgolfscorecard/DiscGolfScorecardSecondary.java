package components.discgolfscorecard;

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
        int currentHoleNum = this.currentHoleNumber();
        //Printing string from hole 1, so shift currentHoleNumber to 1
        while (this.currentHoleNumber() != 1) {
            this.advanceHole();
        }
        StringBuilder result = new StringBuilder("{");
        result.append("Current Hole: ");
        result.append(this.currentHoleNumber());
        result.append(", Starting Hole: ");
        result.append(this.startingHoleNumber());
        result.append(", [");
        for (int i = 0; i < this.length(); i++) {
            Hole hole = this.currentHole();
            result.append("(");
            result.append(hole.par());
            result.append(", ");
            result.append(hole.distance());
            result.append(", ");
            result.append(hole.strokes());
            result.append(")");
            this.advanceHole();
        }
        result.append("]}");
        //Restore currentHoleNumber to original value
        while (this.currentHoleNumber() != currentHoleNum) {
            this.advanceHole();
        }
        return result.toString();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DiscGolfScorecard)) {
            return false;
        }
        DiscGolfScorecard scorecard = (DiscGolfScorecard) obj;
        if (this.length() != scorecard.length()
                || this.currentHoleNumber() != scorecard.currentHoleNumber()
                || this.startingHoleNumber() != scorecard
                        .startingHoleNumber()) {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < this.length(); i++) {
            if (result
                    && (!this.currentHole().equals(scorecard.currentHole()))) {
                //Can't return immediately because the scorecard needs to be restored
                result = false;
            }
            this.advanceHole();
            scorecard.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        return 31 * (this.currentHoleNumber() + this.startingHoleNumber()
                + this.length()) + this.currentHole().hashCode();
    }

    /*
     * Other non-kernel methods ------------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Hole hole(int num) {
        assert 1 <= num && num <= this
                .length() : "Violation of [1 <= num and num <= |this|]";
        int currentHoleNumber = this.currentHoleNumber();
        while (this.currentHoleNumber() != num) {
            this.advanceHole();
        }
        Hole result = this.currentHole();
        //Original currentHoleNumber needs to be restored
        while (this.currentHoleNumber() != currentHoleNumber) {
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void advanceHole(int num) {
        assert 1 <= num && num <= this
                .length() : "Violation of [1 <= num and num <= |this|]";
        while (this.currentHoleNumber() != num) {
            this.advanceHole();
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void retreatHole() {
        for (int i = 0; i < this.length() - 1; i++) {
            this.advanceHole();
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalPar() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            result += this.currentHole().par();
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalPar(int num) {
        assert 1 <= num && num <= this
                .length() : "Violation of [1 <= num and num <= |this|]";
        int currentHoleNumber = this.currentHoleNumber();
        //Start counting from startingHoleNumber
        while (this.currentHoleNumber() != this.startingHoleNumber()) {
            this.advanceHole();
        }
        //Summing happens here
        int result = 0;
        if (this.length() == 1) {
            result = this.currentHole().par();
        } else {
            int stopHole = (num + 1) % this.length();
            while (this.currentHoleNumber() != stopHole) {
                result += this.currentHole().par();
                this.advanceHole();
            }
        }
        //Restore the currentHoleNumber to original vlaue
        while (this.currentHoleNumber() != currentHoleNumber) {
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalDistance() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            result += this.currentHole().distance();
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalDistance(int num) {
        assert 1 <= num && num <= this
                .length() : "Violation of [1 <= num and num <= |this|]";
        int currentHoleNumber = this.currentHoleNumber();
        //Start counting from startingHoleNumber
        while (this.currentHoleNumber() != this.startingHoleNumber()) {
            this.advanceHole();
        }
        //Summing happens here
        int result = 0;
        if (this.length() == 1) {
            result = this.currentHole().distance();
        } else {
            int stopHole = (num + 1) % this.length();
            while (this.currentHoleNumber() != stopHole) {
                result += this.currentHole().distance();
                this.advanceHole();
            }
        }
        //Restore the currentHoleNumber to original vlaue
        while (this.currentHoleNumber() != currentHoleNumber) {
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalStrokes() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            result += this.currentHole().strokes();
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalStrokes(int num) {
        assert 1 <= num && num <= this
                .length() : "Violation of [1 <= num and num <= |this|]";
        int currentHoleNumber = this.currentHoleNumber();
        //Start counting from startingHoleNumber
        while (this.currentHoleNumber() != this.startingHoleNumber()) {
            this.advanceHole();
        }
        //Summing happens here
        int result = 0;
        if (this.length() == 1) {
            result = this.currentHole().strokes();
        } else {
            int stopHole = (num + 1) % this.length();
            while (this.currentHoleNumber() != stopHole) {
                result += this.currentHole().strokes();
                this.advanceHole();
            }
        }
        //Restore the currentHoleNumber to original vlaue
        while (this.currentHoleNumber() != currentHoleNumber) {
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalScore() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            result += this.currentHole().strokes() - this.currentHole().par();
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int totalScore(int num) {
        assert 1 <= num && num <= this
                .length() : "Violation of [1 <= num and num <= |this|]";
        int currentHoleNumber = this.currentHoleNumber();
        //Start counting from startingHoleNumber
        while (this.currentHoleNumber() != this.startingHoleNumber()) {
            this.advanceHole();
        }
        //Summing happens here
        int result = 0;
        boolean calculationComplete = false;
        while (!calculationComplete) {
            result += this.currentHole().strokes() - this.currentHole().par();
            if (this.currentHoleNumber() == num) {
                calculationComplete = true;
            }
            this.advanceHole();
        }
        //Restore the currentHoleNumber to original vlaue
        while (this.currentHoleNumber() != currentHoleNumber) {
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int holesPlayed() {
        int result = 0;
        for (int i = 0; i < this.length(); i++) {
            if (this.currentHole().strokes() > 0) {
                result++;
            }
            this.advanceHole();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int furthestHolePlayed() {
        boolean found = false;
        int currentHoleNumber = this.currentHoleNumber();
        int i = 0;
        while (!found && i < this.length()) {
            //Calling abstract method due to simplicity
            this.retreatHole();
            Hole hole = this.currentHole();
            if (hole.strokes() > 0) {
                found = true;
            }
            i++;
        }
        int result = this.currentHoleNumber();
        //Account for nothing being found
        if (this.currentHoleNumber() == currentHoleNumber
                && this.currentHole().strokes() <= 0) {
            result = 0;
        } else {
            //Restore the currentHoleNumber to original value
            while (this.currentHoleNumber() != currentHoleNumber) {
                this.advanceHole();
            }
        }
        return result;
    }

}
