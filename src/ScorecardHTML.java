import java.util.Random;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Demonstration of an HTML view of a DiscGolfScorecard.
 *
 * @author Luke Zhang
 */
public final class ScorecardHTML {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ScorecardHTML() {
    }

    /**
     * Demonstration of an HTML view of a DiscGolfScorecard.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        DiscGolfScorecard scorecard = new DiscGolfScorecard1();
        Random random = new Random();

        //Randomly generated scorecard
        for (int i = 0; i < scorecard.length(); i++) {
            scorecard.replaceCurrentHole(new Hole(3 + random.nextInt(3),
                    100 + random.nextInt(500), 1 + random.nextInt(10)));
            scorecard.advanceHole();
        }

        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        out.print("Enter an output file path:");
        out.close();
        String filePath = in.nextLine();
        in.close();
        SimpleWriter fileOut = new SimpleWriter1L(filePath);

        //Note: Everything below was basically all ChatGPT

        fileOut.println("<html>");
        fileOut.println("<head><title>Disc Golf Scorecard</title></head>");
        fileOut.println("<body>");
        fileOut.println("<h1>18-Hole Disc Golf Scorecard</h1>");
        fileOut.println("<table border='1'>");
        fileOut.println("<tr><th>Hole</th><th>Par</th><th>Distance</th>"
                + "<th>Strokes</th></tr>");

        //The holes
        for (int holeNumber = 1; holeNumber <= 18; holeNumber++) {
            Hole hole = scorecard.currentHole();
            fileOut.println("<tr>");
            fileOut.println("<td>" + holeNumber + "</td>");
            fileOut.println("<td>" + hole.par() + "</td>");
            fileOut.println("<td>" + hole.distance() + "</td>");
            fileOut.println("<td>" + hole.strokes() + "</td>");
            fileOut.println("</tr>");
            scorecard.advanceHole();
        }

        //Summary statistics
        fileOut.println("<tr>");
        fileOut.println("<td><strong>Total</strong></td>");
        fileOut.println("<td>" + scorecard.totalPar() + "</td>");
        fileOut.println("<td>" + scorecard.totalDistance() + "</td>");
        fileOut.println("<td>" + scorecard.totalStrokes() + "</td>");
        fileOut.println("</tr>");
        fileOut.println("</table>");
        fileOut.println("</body>");
        fileOut.println("</html>");

        fileOut.close();

    }
}
