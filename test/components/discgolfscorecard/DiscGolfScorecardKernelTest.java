package components.discgolfscorecard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit text fixture for {@code DiscGolfScorecard}'s kernel and standard
 * methods.
 *
 * @author Luke Zhang
 */
public class DiscGolfScorecardKernelTest {

    //currentHole tests

    /**
     * Test currentHole on scorecard of default length.
     */
    @Test
    public final void testCurrentHoleDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        Hole hole = s.currentHole();
        Hole expectedHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        assertEquals(expectedHole, hole);
        assertEquals(sCopy, s);
    }

    /**
     * Test currentHole on scorecard of length 1.
     */
    @Test
    public final void testCurrentHole1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        Hole hole = s.currentHole();
        Hole expectedHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        assertEquals(expectedHole, hole);
        assertEquals(sCopy, s);
    }

    /**
     * Test currentHole on scorecard of length 27 and starting hole 10.
     */
    @Test
    public final void testCurrentHole2710() {
        DiscGolfScorecard s = new DiscGolfScorecard1(27, 10);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(27, 10);
        Hole hole = s.currentHole();
        Hole expectedHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        assertEquals(expectedHole, hole);
        assertEquals(sCopy, s);
    }

    //replaceCurrentHole (Uses all kernels but advanceHole, so unusable in their tests)

    /**
     * Test replaceCurrentHole on default scorecard.
     */
    @Test
    public final void testReplaceCurrentHoleDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        //Method call
        s.replaceCurrentHole(new Hole(0, 0, 0));
        //Checks
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
     * Test replaceCurrentHole on scorecard of length 1.
     */
    @Test
    public final void testReplaceCurrentHole1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        //Method call
        s.replaceCurrentHole(new Hole(0, 0, 0));
        //Checks
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
     * Test replaceCurrentHole on scorecard of length 27 with starting hole 10.
     */
    @Test
    public final void testReplaceCurrentHole2710() {
        DiscGolfScorecard s = new DiscGolfScorecard1(27, 10);
        //Method call
        s.replaceCurrentHole(new Hole(0, 0, 0));
        //Checks
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(0, 0, 0);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 10;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 10;
        int length = s.length();
        int expectedLength = 27;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
    }

    //advanceHole tests (Note: Uses all kernel methods, so can't be used in their tests)

    /**
     * Test advanceHole on default scorecard.
     */
    @Test
    public final void testAdvanceHoleDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        //This needed to confirm the advanced hole is correct, not just a default value
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        //Method call
        s.advanceHole();
        sCopy.advanceHole();
        //Checks
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 2;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 18;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
        //Check getters don't affect s after advanceHole, as it can't be tested elsewhere
        assertEquals(sCopy, s);
    }

    /**
     * Test advanceHole on scorecard of length 1.
     */
    @Test
    public final void testAdvanceHole1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        //Method call
        s.advanceHole();
        sCopy.advanceHole();
        //Checks
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
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
        //Check getters don't affect s after advanceHole, as it can't be tested elsewhere
        assertEquals(sCopy, s);
    }

    /**
     * Test advanceHole on scorecard of length 2 with current hole 1 and
     * starting hole 1.
     */
    @Test
    public final void testAdvanceHole211() {
        DiscGolfScorecard s = new DiscGolfScorecard1(2);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(2);
        //This needed to confirm the advanced hole is correct, not just a default value
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        //Method call
        s.advanceHole();
        sCopy.advanceHole();
        //Checks
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 2;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 2;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
        //Check getters don't affect s after advanceHole, as it can't be tested elsewhere
        assertEquals(sCopy, s);
    }

    /**
     * Test advanceHole on scorecard of length 2 with current hole 2 and
     * starting hole 1.
     */
    @Test
    public final void testAdvanceHole221() {
        //Essential methods of testAdvanceHole211 that will lead to desired 221 starting s
        DiscGolfScorecard s = new DiscGolfScorecard1(2);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(2);
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        s.advanceHole();
        sCopy.advanceHole();
        //New method call
        s.advanceHole();
        sCopy.advanceHole();
        //New checks
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(0, 0, 0);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        int length = s.length();
        int expectedLength = 2;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
        //Check getters don't affect s after advanceHole, as it can't be tested elsewhere
        assertEquals(sCopy, s);
    }

    /**
     * Test advanceHole on scorecard of length 2 with current hole 2 and
     * starting hole 2.
     */
    @Test
    public final void testAdvanceHole222() {
        DiscGolfScorecard s = new DiscGolfScorecard1(2, 2);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(2, 2);
        //This needed to confirm the advanced hole is correct, not just a default value
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        //Method call
        s.advanceHole();
        sCopy.advanceHole();
        //Checks
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 2;
        int length = s.length();
        int expectedLength = 2;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
        //Check getters don't affect s after advanceHole, as it can't be tested elsewhere
        assertEquals(sCopy, s);
    }

    /**
     * Test advanceHole on scorecard of length 2 with current hole 1 and
     * starting hole 2.
     */
    @Test
    public final void testAdvanceHole212() {
        //Essential methods of testAdvanceHole222 that will lead to desired 212 starting s
        DiscGolfScorecard s = new DiscGolfScorecard1(2, 2);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(2, 2);
        s.replaceCurrentHole(new Hole(0, 0, 0));
        sCopy.replaceCurrentHole(new Hole(0, 0, 0));
        s.advanceHole();
        sCopy.advanceHole();
        //New method call
        s.advanceHole();
        sCopy.advanceHole();
        //New checks
        Hole currentHole = s.currentHole();
        Hole expectedCurrentHole = new Hole(0, 0, 0);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 2;
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 2;
        int length = s.length();
        int expectedLength = 2;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(expectedCurrentHole, currentHole);
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(expectedLength, length);
        //Check getters don't affect s after advanceHole, as it can't be tested elsewhere
        assertEquals(sCopy, s);
    }

    //curentHoleNumber tests

    /**
     * Test currentHoleNumber on default scorecard.
     */
    @Test
    public final void testCurrentHoleNumberDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(sCopy, s);
    }

    /**
     * Test currentHoleNumber on scorecard of length 1.
     */
    @Test
    public final void testCurrentHoleNumber1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 1;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(sCopy, s);
    }

    /**
     * Test currentHoleNumber on scorecard of length 2 with starting hole 2.
     */
    @Test
    public final void testCurrentHoleNumber22() {
        DiscGolfScorecard s = new DiscGolfScorecard1(2, 2);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(2, 2);
        int currentHoleNumber = s.currentHoleNumber();
        int expectedCurrentHoleNumber = 2;
        assertEquals(expectedCurrentHoleNumber, currentHoleNumber);
        assertEquals(sCopy, s);
    }

    //startingHoleNumber tests

    /**
     * Test startingHoleNumber on default scorecard.
     */
    @Test
    public final void testStartingHoleNumberDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(sCopy, s);
    }

    /**
     * Test startingHoleNumber on scorecard of length 1.
     */
    @Test
    public final void testStartingHoleNumber1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 1;
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(sCopy, s);
    }

    /**
     * Test startingHoleNumber on scorecard of length 2 with starting hole 2.
     */
    @Test
    public final void testStartingHoleNumber22() {
        DiscGolfScorecard s = new DiscGolfScorecard1(2, 2);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(2, 2);
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 2;
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(sCopy, s);
    }

    /**
     * Test startingHoleNumber on scorecard of length 27 with starting hole 10.
     */
    @Test
    public final void testStartingHoleNumber2710() {
        DiscGolfScorecard s = new DiscGolfScorecard1(27, 10);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(27, 10);
        int startingHoleNumber = s.startingHoleNumber();
        int expectedStartingHoleNumber = 10;
        assertEquals(expectedStartingHoleNumber, startingHoleNumber);
        assertEquals(sCopy, s);
    }

    //length tests

    /**
     * Test length on scorecard of default length.
     */
    @Test
    public final void testLengthDefault() {
        DiscGolfScorecard s = new DiscGolfScorecard1();
        DiscGolfScorecard sCopy = new DiscGolfScorecard1();
        int length = s.length();
        int expectedLength = 18;
        assertEquals(expectedLength, length);
        assertEquals(sCopy, s);
    }

    /**
     * Test length on scorecard of length 1.
     */
    @Test
    public final void testLength1() {
        DiscGolfScorecard s = new DiscGolfScorecard1(1);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(1);
        int length = s.length();
        int expectedLength = 1;
        assertEquals(expectedLength, length);
        assertEquals(sCopy, s);
    }

    /**
     * Test length on scorecard of length 27 and starting hole 10.
     */
    @Test
    public final void testLength2710() {
        DiscGolfScorecard s = new DiscGolfScorecard1(27, 10);
        DiscGolfScorecard sCopy = new DiscGolfScorecard1(27, 10);
        int length = s.length();
        int expectedLength = 27;
        assertEquals(expectedLength, length);
        assertEquals(sCopy, s);
    }

    //newInstance tests

    /**
     * Test new instance on default scorecard.
     */
    @Test
    public final void testNewInstanceDefault() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1();
        DiscGolfScorecard s2 = s1.newInstance();
        DiscGolfScorecard ref = new DiscGolfScorecard1();
        assertEquals(ref, s2);
    }

    /**
     * Test new instance call on scorecard of length 27 and starting hole 10.
     */
    @Test
    public final void testNewInstance2710() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1(27, 10);
        DiscGolfScorecard s2 = s1.newInstance();
        DiscGolfScorecard ref = new DiscGolfScorecard1();
        assertEquals(ref, s2);

    }

    //clear tests

    /**
     * Test clear on default scorecard.
     */
    @Test
    public final void testClearDefault() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1();
        s1.clear();
        DiscGolfScorecard ref = new DiscGolfScorecard1();
        assertEquals(ref, s1);
    }

    /**
     * Test clear on scorecard of length 27 and starting hole 10.
     */
    @Test
    public final void testClear2710() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1(27, 10);
        s1.clear();
        DiscGolfScorecard ref = new DiscGolfScorecard1();
        assertEquals(ref, s1);
    }

    //transferFrom tests

    /**
     * Test transferFrom from a default scorecard to another default scorecard.
     */
    @Test
    public final void testTransferFromDefault() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1();
        DiscGolfScorecard s2 = new DiscGolfScorecard1();
        s1.transferFrom(s2);
        Hole currentHole1 = s1.currentHole();
        Hole expectedCurrentHole1 = new Hole(
                DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber1 = s1.currentHoleNumber();
        int expectedCurrentHoleNumber1 = 1;
        int startingHoleNumber1 = s1.startingHoleNumber();
        int expectedStartingHoleNumber1 = 1;
        int length1 = s1.length();
        int expectedLength1 = 18;
        assertEquals(expectedCurrentHoleNumber1, currentHoleNumber1);
        assertEquals(expectedCurrentHole1, currentHole1);
        assertEquals(expectedStartingHoleNumber1, startingHoleNumber1);
        assertEquals(expectedLength1, length1);
        Hole currentHole2 = s2.currentHole();
        Hole expectedCurrentHole2 = new Hole(
                DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber2 = s2.currentHoleNumber();
        int expectedCurrentHoleNumber2 = 1;
        int startingHoleNumber2 = s2.startingHoleNumber();
        int expectedStartingHoleNumber2 = 1;
        int length2 = s2.length();
        int expectedLength2 = 18;
        assertEquals(expectedCurrentHoleNumber2, currentHoleNumber2);
        assertEquals(expectedCurrentHole2, currentHole2);
        assertEquals(expectedStartingHoleNumber2, startingHoleNumber2);
        assertEquals(expectedLength2, length2);
    }

    /**
     * Test transferFrom between scorecards of different sizes
     */
    @Test
    public final void testTransferFromUneven() {
        DiscGolfScorecard s1 = new DiscGolfScorecard1(4329, 345);
        DiscGolfScorecard s2 = new DiscGolfScorecard1(2, 2);
        s2.advanceHole();
        s2.replaceCurrentHole(new Hole(0, 0, 0));
        s1.transferFrom(s2);
        Hole currentHole1 = s1.currentHole();
        Hole expectedCurrentHole1 = new Hole(0, 0, 0);
        int currentHoleNumber1 = s1.currentHoleNumber();
        int expectedCurrentHoleNumber1 = 1;
        int startingHoleNumber1 = s1.startingHoleNumber();
        int expectedStartingHoleNumber1 = 2;
        int length1 = s1.length();
        int expectedLength1 = 2;
        assertEquals(expectedCurrentHoleNumber1, currentHoleNumber1);
        assertEquals(expectedCurrentHole1, currentHole1);
        assertEquals(expectedStartingHoleNumber1, startingHoleNumber1);
        assertEquals(expectedLength1, length1);
        Hole currentHole2 = s2.currentHole();
        Hole expectedCurrentHole2 = new Hole(
                DiscGolfScorecardKernel.DEFAULT_PAR,
                DiscGolfScorecardKernel.DEFAULT_DISTANCE,
                DiscGolfScorecardKernel.DEFAULT_STROKES);
        int currentHoleNumber2 = s2.currentHoleNumber();
        int expectedCurrentHoleNumber2 = 1;
        int startingHoleNumber2 = s2.startingHoleNumber();
        int expectedStartingHoleNumber2 = 1;
        int length2 = s2.length();
        int expectedLength2 = 18;
        assertEquals(expectedCurrentHoleNumber2, currentHoleNumber2);
        assertEquals(expectedCurrentHole2, currentHole2);
        assertEquals(expectedStartingHoleNumber2, startingHoleNumber2);
        assertEquals(expectedLength2, length2);
    }

}
