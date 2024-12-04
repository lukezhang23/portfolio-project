import java.util.Random;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Demonstration of a use case of DiscGolfScorecard. A mini game.
 *
 * @author Luke Zhang
 */
public final class MiniGame {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MiniGame() {
    }

    /**
     * Mini disc golf game
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {

        String[] goodmessages = { "Good job!", "Nice job!", "Great job!",
                "You're on a roll!", "You're doing great!", "Nice!",
                "You're doing great!", "Practice does make perfect!",
                "Paul Mcbeth is getting nervous, the incoming competition is getting fierce!",
                "Way to be an overachiever!" };

        String[] badmessages = { "It's alright, we've all had our bad holes.",
                "Keep your head up, there's always the next hole!",
                "Tough break.", "Wow that's bad!",
                "Even Paul Mcbeth has his bad holes",
                "At least you met your expectations.",
                "Maybe disc golf isn't the sport for you.",
                "Maybe you need to buy more discs . . .",
                "Theres's a reason there's a trashcan.",
                "You probably just hit 10 trees.",
                "I could throw a rock better than that and I can't even throw a rock." };

        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        out.println("Welcome to Maple Hill Disc Golf Course!");

        DiscGolfScorecard scorecard = new DiscGolfScorecard1(3);

        Random random = new Random();

        //Fill up randomized pars/distances
        for (int i = 0; i < scorecard.length(); i++) {
            scorecard.replaceCurrentHole(new Hole(3 + random.nextInt(3),
                    100 + random.nextInt(500), 0));
            scorecard.advanceHole();
        }

        //Have player go hole by hole
        while (scorecard.furthestHolePlayed() != scorecard.length()) {
            Hole hole = scorecard.currentHole();
            out.println(
                    "Hole " + Integer.toString(scorecard.currentHoleNumber())
                            + " (Par " + Integer.toString(hole.par()) + ", "
                            + Integer.toString(hole.distance()) + " feet)");
            out.print("Enter anything to play the hole");
            in.nextLine();
            int score = 1 + random.nextInt(10);
            out.println("You shot " + Integer.toString(score));
            if (score <= hole.par()) {
                out.println(goodmessages[random.nextInt(goodmessages.length)]);
            } else {
                out.println(badmessages[random.nextInt(badmessages.length)]);
            }
            scorecard.replaceCurrentHole(
                    new Hole(hole.par(), hole.strokes(), score));
            out.println("Total Score: "
                    + scorecard.totalScore(scorecard.currentHoleNumber()));
            scorecard.advanceHole();
        }

        out.println("End of Game!");

        in.close();
        out.close();

    }
}
