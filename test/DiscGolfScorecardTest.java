import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit text fixture for {@code DiscGolfScorecard}'s secondary methods.
 *
 * @author Luke Zhang
 */
public class DiscGolfScorecardTest {

    //hole tests

    /**
     * Test hole on scorecard of default length. Call on current hole.
     */
    @Test
    public final void testHoleDefaultCurrent() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        Hole hole = s.hole(1);
        Hole expectedHole = new Hole(0, 0, 0);
        assertEquals(expectedHole, hole);
        assertEquals(sCopy, s);
    }

    /**
     * Test hole on scorecard of default length. Call on non-current hole.
     */
    @Test
    public final void testHoleDefaultNonCurrent() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        s.advanceHole();
        sCopy.advanceHole();
        Hole hole = s.hole(1);
        Hole expectedHole = new Hole(0, 0, 0);
        assertEquals(expectedHole, hole);
        assertEquals(sCopy, s);
    }

    /**
     * Test hole on scorecard of length 1.
     */
    @Test
    public final void testHole1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        Hole hole = s.hole(1);
        Hole expectedHole = new Hole(0, 0, 0);
        assertEquals(expectedHole, hole);
        assertEquals(sCopy, s);
    }

    /**
     * Test hole on scorecard of custom length. Call on non-current hole.
     */
    @Test
    public final void testHoleCustom() {
        DiscGolfScorecard s = new DiscGolfScorecard1(27, 26);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(27, 26);
        s.advanceHole();
        sCopy.advanceHole();
        //Replaces hole 27
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        Hole hole = s.hole(27);
        Hole expectedHole = new Hole(0, 0, 0);
        assertEquals(expectedHole, hole);
        assertEquals(sCopy, s);
    }

    //advanceHole tests

    /**
     * Test advanceHole on default scorecard. Call on current hole.
     */
    @Test
    public final void testAdvanceHoleDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(0, 0, 0));
        s.advanceHole(1);
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(0, 0, 0);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 18;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
    }

    /**
     * Test advanceHole on default scorecard. Call on non-current hole.
     */
    @Test
    public final void testAdvanceHoleDefaultNonCurrent() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(0, 0, 0));
        s.advanceHole();
        s.advanceHole();
        s.advanceHole(1);
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(0, 0, 0);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 18;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
    }

    /**
     * Test advanceHole on scorecard of length 1.
     */
    @Test
    public final void testAdvanceHole1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        s.replaceCurrentHole(new Hole(0, 0, 0));
        s.advanceHole(1);
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(0, 0, 0);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 1;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
    }

    //retreatHole tests

    /**
     * Test retreatHole on default scorecard.
     */
    @Test
    public final void testRetreatHoleDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(0, 0, 0));
        s.retreatHole();
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 18;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 18;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
    }

    /**
     * Test retreatHole on scorecard of length 1.
     */
    @Test
    public final void testRetreatHole1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        s.replaceCurrentHole(new Hole(0, 0, 0));
        s.retreatHole();
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(0, 0, 0);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 1;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
    }

    /**
     * Test retreatHole on scorecard with high starting hole.
     */
    @Test
    public final void testRetreatHoleHighStart() {
        DiscGolfScorecard s = new DiscGolfScorecard1(18, 18);
        s.replaceCurrentHole(new Hole(0, 0, 0));
        s.retreatHole();
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 17;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 18;
        int length = s.length();
        int expectedLength = 18;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
    }

    //totalPar tests

    /**
     * Test totalPar on default scorecard.
     */
    @Test
    public final void testTotalParDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalPar();
        int expectedResult = DiscGolfScorecardKernel.DEFAULT_PAR
                * DiscGolfScorecardKernel.DEFAULT_SCORECARD_LENGTH;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalPar on scorecard of length 1.
     */
    @Test
    public final void testTotalPar1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalPar();
        int expectedResult = DiscGolfScorecardKernel.DEFAULT_PAR;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalPar on scorecard with edited entries.
     */
    @Test
    public final void testTotalParEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(10, 0, 0));
        sCopy.replaceCurrentHole(new Hole(10, 0, 0));
        int result = s.totalPar();
        int expectedResult = 17 * 3 + 10;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //totalParInt tests

    /**
     * Test totalParInt on default scorecard.
     */
    @Test
    public final void testTotalParIntDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalPar(5);
        int expectedResult = DiscGolfScorecardKernel.DEFAULT_PAR * 5;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalParInt on scorecard of length 1.
     */
    @Test
    public final void testTotalParInt1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalPar(1);
        int expectedResult = DiscGolfScorecardKernel.DEFAULT_PAR;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalParInt on scorecard with edited entries.
     */
    @Test
    public final void testTotalParIntEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(5, 4);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(5, 4);
        s.replaceCurrentHole(new Hole(10, 0, 0));
        sCopy.replaceCurrentHole(new Hole(10, 0, 0));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        //Advances to hole 2
        s.replaceCurrentHole(new Hole(10, 10, 10));
        sCopy.replaceCurrentHole(new Hole(10, 10, 10));
        int result = s.totalPar(1);
        int expectedResult = 10 + 3 + 3;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //totalDistance tests

    /**
     * Test totalDistance on default scorecard.
     */
    @Test
    public final void testTotalDistanceDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalDistance();
        int expectedResult = DiscGolfScorecardKernel.DEFAULT_DISTANCE
                * DiscGolfScorecardKernel.DEFAULT_SCORECARD_LENGTH;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalDistance on scorecard of length 1.
     */
    @Test
    public final void testTotalDistance1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalDistance();
        int expectedResult = DiscGolfScorecardKernel.DEFAULT_DISTANCE;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalDistance on scorecard with edited entries.
     */
    @Test
    public final void testTotalDistanceEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(0, 10, 0));
        sCopy.replaceCurrentHole(new Hole(0, 10, 0));
        int result = s.totalDistance();
        int expectedResult = 10;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //totalDistanceInt tests

    /**
     * Test totalDistanceInt on default scorecard.
     */
    @Test
    public final void testTotalDistanceIntDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalDistance(5);
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalDistanceInt on scorecard of length 1.
     */
    @Test
    public final void testTotalDistanceInt1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalDistance(1);
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalDistanceInt on scorecard with edited entries.
     */
    @Test
    public final void testTotalDistanceIntEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(5, 4);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(5, 4);
        s.replaceCurrentHole(new Hole(10, 5, 4));
        sCopy.replaceCurrentHole(new Hole(10, 5, 4));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        //Advances to hole 2
        s.replaceCurrentHole(new Hole(10, 10, 10));
        sCopy.replaceCurrentHole(new Hole(10, 10, 10));
        int result = s.totalDistance(1);
        int expectedResult = 5;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //totalStrokes tests

    /**
     * Test totalStrokes on default scorecard.
     */
    @Test
    public final void testTotalStrokesDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalStrokes();
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalStrokes on scorecard of length 1.
     */
    @Test
    public final void testTotalStrokes1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalStrokes();
        int expectedResult = DiscGolfScorecardKernel.DEFAULT_STROKES;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalStrokes on scorecard with edited entries.
     */
    @Test
    public final void testTotalStrokesEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(10, 4, 1));
        sCopy.replaceCurrentHole(new Hole(10, 4, 1));
        int result = s.totalStrokes();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //totalStrokesInt tests

    /**
     * Test totalStrokesInt on default scorecard.
     */
    @Test
    public final void testTotalStrokesIntDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalStrokes(5);
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalStrokesInt on scorecard of length 1.
     */
    @Test
    public final void testTotalStrokesInt1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalStrokes(1);
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalStrokesInt on scorecard with edited entries.
     */
    @Test
    public final void testTotalStrokesIntEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(5, 4);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(5, 4);
        s.replaceCurrentHole(new Hole(10, 5, 4));
        sCopy.replaceCurrentHole(new Hole(10, 5, 4));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        //Advances to hole 2
        s.replaceCurrentHole(new Hole(10, 10, 10));
        sCopy.replaceCurrentHole(new Hole(10, 10, 10));
        int result = s.totalStrokes(1);
        int expectedResult = 4;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //totalScore tests

    /**
     * Test totalScore on default scorecard.
     */
    @Test
    public final void testTotalScoreDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalScore();
        int expectedResult = -3 * 18;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalScore on scorecard of length 1.
     */
    @Test
    public final void testTotalScore1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalScore();
        int expectedResult = -3;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalScore on scorecard with edited entries.
     */
    @Test
    public final void testTotalScoreEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        s.replaceCurrentHole(new Hole(10, 3, 15));
        sCopy.replaceCurrentHole(new Hole(10, 3, 15));
        int result = s.totalScore();
        int expectedResult = 17 * -3 + 5;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //totalScoreInt tests

    /**
     * Test totalScoreInt on default scorecard.
     */
    @Test
    public final void testTotalScoreIntDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.totalScore(5);
        int expectedResult = -3 * 5;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalScoreInt on scorecard of length 1.
     */
    @Test
    public final void testTotalScoreInt1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.totalScore(1);
        int expectedResult = -3;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test totalScoreInt on scorecard with edited entries.
     */
    @Test
    public final void testTotalScoreIntEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(5, 4);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(5, 4);
        s.replaceCurrentHole(new Hole(10, 5, 4));
        sCopy.replaceCurrentHole(new Hole(10, 5, 4));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        //Advances to hole 2
        s.replaceCurrentHole(new Hole(10, 10, 10));
        sCopy.replaceCurrentHole(new Hole(10, 10, 10));
        int result = s.totalScore(1);
        int expectedResult = -6 - 3 - 3;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //holesPlayed tests

    /**
     * Test holesPlayed on default scorecard.
     */
    @Test
    public final void testHolesPlayedDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.holesPlayed();
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test holesPlayed on scorecard of length 1.
     */
    @Test
    public final void testHolesPlayed1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.holesPlayed();
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test holesPlayed on edited scorecard of length 1.
     */
    @Test
    public final void testHolesPlayed1Edited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        s.replaceCurrentHole(new Hole(34, 234, 34));
        sCopy.replaceCurrentHole(new Hole(34, 234, 34));
        int result = s.holesPlayed();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test holesPlayed on edited scorecard.
     */
    @Test
    public final void testHolesPlayedEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(5, 4);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(5, 4);
        s.replaceCurrentHole(new Hole(34, 23, 304));
        sCopy.replaceCurrentHole(new Hole(34, 23, 304));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        //Advanced to hole 2
        s.replaceCurrentHole(new Hole(0, 0, 34));
        sCopy.replaceCurrentHole(new Hole(0, 0, 34));
        s.advanceHole();
        sCopy.advanceHole();
        //Advanced to hole 3
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        int result = s.holesPlayed();
        int expectedResult = 2;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //furthestHolePlayed test

    /**
     * Test furthestHolePlayed on default scorecard.
     */
    @Test
    public final void testFurthestHolesPlayedDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int result = s.furthestHolePlayed();
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test furthestHolePlayed on scorecard of length 1.
     */
    @Test
    public final void testFurthestHolesPlayed1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int result = s.furthestHolePlayed();
        int expectedResult = 0;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test furthestHolePlayed on edited scorecard of length 1.
     */
    @Test
    public final void testFurthestHolesPlayed1Edited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        s.replaceCurrentHole(new Hole(34, 234, 34));
        sCopy.replaceCurrentHole(new Hole(34, 234, 34));
        int result = s.furthestHolePlayed();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test furthestHolePlayed on edited scorecard.
     */
    @Test
    public final void testFurthestHolesPlayedEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(5, 4);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(5, 4);
        s.replaceCurrentHole(new Hole(34, 23, 304));
        sCopy.replaceCurrentHole(new Hole(34, 23, 304));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        //Advanced to hole 2
        s.replaceCurrentHole(new Hole(0, 0, 34));
        sCopy.replaceCurrentHole(new Hole(0, 0, 34));
        s.advanceHole();
        sCopy.advanceHole();
        //Advanced to hole 3
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        int result = s.furthestHolePlayed();
        int expectedResult = 2;
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //toString tests

    /**
     * Test toString on default scorecard.
     */
    @Test
    public final void testToStringDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        String result = s.toString();
        String expectedResult = "{Current Hole: 1, Starting Hole: 1, [(3, 0, 0)"
                + "(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)"
                + "(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)(3, 0, 0)"
                + "(3, 0, 0)(3, 0, 0)(3, 0, 0)]}";
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test toString on scorecard of length 1.
     */
    @Test
    public final void testToString1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        String result = s.toString();
        String expectedResult = "{Current Hole: 1, Starting Hole: 1, [(3, 0, 0)]}";
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    /**
     * Test toString on edited scorecard.
     */
    @Test
    public final void testtoStringEdited() {
        DiscGolfScorecard s = new DiscGolfScorecard1(5, 4);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(5, 4);
        s.replaceCurrentHole(new Hole(34, 23, 304));
        sCopy.replaceCurrentHole(new Hole(34, 23, 304));
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        s.advanceHole();
        sCopy.advanceHole();
        //Advanced to hole 2
        s.replaceCurrentHole(new Hole(0, 0, 34));
        sCopy.replaceCurrentHole(new Hole(0, 0, 34));
        s.advanceHole();
        sCopy.advanceHole();
        //Advanced to hole 3
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        String result = s.toString();
        String expectedResult = "{Current Hole: 1, Starting Hole: 4, "
                + "[(3, 0, 0)(0, 0, 34)(0, 0, 0)(34, 23, 304)(3, 0, 0)]}";
        assertEquals(expectedResult, result);
        assertEquals(sCopy, s);
    }

    //equals test

    /**
     * Test equals on default scorecards.
     */
    @Test
    public final void testEqualsDefault() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1();
        DiscGolfScorecard s2 = new DiscGolfScorecard1();
        assertTrue(s1.equals(s2));
    }

    /**
     * Test equals on default scorecards, one is edited.
     */
    @Test
    public final void testEqualsDefaultOneEdited() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1();
        DiscGolfScorecard s2 = new DiscGolfScorecard1();
        s1.advanceHole();
        assertTrue(!s1.equals(s2));
    }

    /**
     * Test equals on default scorecards, both are edited the same.
     */
    @Test
    public final void testEqualsDefaultBothEdited() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1();
        DiscGolfScorecard s2 = new DiscGolfScorecard1();
        s1.advanceHole();
        s2.advanceHole();
        assertTrue(s1.equals(s2));
    }

    //hashCode test

    /**
     * Testing for hashCode consistency.
     */
    @Test
    public final void testHashCodeConsistency() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int initialHashCode = s.hashCode();
        int secondHashCode = s.hashCode();
        assertEquals(initialHashCode, secondHashCode);
        assertEquals(sCopy, s);
    }

    /**
     * Testing for hashCode equality.
     */
    @Test
    public final void testHashCodeEquality() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int h1 = s.hashCode();
        int h2 = sCopy.hashCode();
        assertEquals(h1, h2);
        assertEquals(sCopy, s);
    }

}
