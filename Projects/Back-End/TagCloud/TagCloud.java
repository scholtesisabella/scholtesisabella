import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.sortingmachine.SortingMachine;
import components.sortingmachine.SortingMachine1L;
import components.utilities.Reporter;

/**
 * Creates tag cloud from input file.
 *
 * @author Bella Scholtes
 */
public final class TagCloudGenerator {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private TagCloudGenerator() {
        // no code needed here
    }

    /**
     * Set initial size value.
     */
    private static final int INITIAL_SIZE = 48;

    /**
     * Set first value in finding size.
     */
    private static final int FIRST_SIZE = 11;

    /**
     * Set second value in finding size.
     */
    private static final int SECOND_SIZE = 37;

    /**
     * Outputs HTML header to output file.
     *
     * @param out
     *            output stream
     * @param inFile
     *            input file
     * @param n
     *            number of words
     *
     */
    private static void outputHeader(SimpleWriter out, String inputFile,
            int numWords) {

        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        /* opening tags */
        out.println("<html>");
        out.println("<head>");
        out.println("<h1>");
        /*
         * puts a heading at the top of the page with the number of words and
         * the file name
         */
        out.println("Top " + numWords + " words in " + inputFile);
        out.println("</h1>");
        /* sets title of page to Tag Cloud */
        out.println("<title>");
        out.println("Tag Cloud");
        out.println("</title>");
        /* <link> tags referring to CSS style sheet */
        out.println(
                "<link href=\"http://web.cse.ohio-state.edu/software/2231/web-sw2/assignments/projects/tag-cloud-generator/data/tagcloud.css\" "
                        + "rel=\"stylesheet\" type=\"text/css\">");
        out.println(
                "<link href=\"tagcloud.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
        /* opens body tag */

        out.println("<body data-new-gr-c-s-check-loaded=\\\"14.1056.0\\\"\r\n"
                + "data-gr-ext-installed>");
        out.println("<hr>");
        out.println("<div class=\"cdiv\">");
        out.println("</div>");
        out.println("<p class=\"cbox\">");
    }

    /**
     * Outputs the closing tags in a generated HTML page. Expected elements
     * shown below:
     * </p>
     * </div> </body> </html>
     *
     * @param out
     *            the output stream
     * @updates out.content
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "closing" tags]
     */
    private static void outputFooter(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";
        /* closing tags in html document */
        out.println("</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Generates the set of characters in String str into the Set charSet.
     *
     * @param str
     *            the given String
     * @param charSet
     *            the Set to be replaced
     * @replaces charSet
     * @ensures charSet has every character in str
     */
    private static void generateElements(String str, Set<Character> charSet) {
        assert str != null : "Violation of: str is not null";
        assert charSet != null : "Violation of: charSet is not null";

        /* runs through string and puts each char in the Set */
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            /* prevents repeats */
            if (!charSet.contains(temp)) {
                charSet.add(temp);
            }
        }

    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * separators) or "separator string" (maximal length string of characters in
     * separators) in the given text starting at the given position.
     *
     * @param text
     *            the String from which to get the word or separator string
     * @param position
     *            the starting index
     * @param separators
     *            the Set of separator characters
     * @return the first word or separator string found in text starting at
     *         index position
     * @requires position to be greater than or equal to 0 but less than text
     *           size
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text(position, position + nextWordOrSeparator size)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        /* used to determine if a word or separator is complete */
        boolean found = false;
        String wordOrNot = "";
        Character first = Character.valueOf(text.charAt(position));
        /* used to determine if a word or separator will be returned */
        if (separators.contains(first)) {
            /*
             * runs through the string text and if it has a separator, adds to
             * final string otherwise the end of the separators has been reached
             */
            for (int i = position; i < text.length() && !found; i++) {
                if (separators.contains(Character.valueOf(text.charAt(i)))) {
                    wordOrNot = wordOrNot + text.charAt(i);
                } else {
                    found = true;
                }
            }
        } else {
            /*
             * runs through the string text and if it has a letter, adds to
             * final string otherwise the end of the word has been reached
             */
            for (int i = position; i < text.length() && !found; i++) {
                if (!separators.contains(Character.valueOf(text.charAt(i)))) {
                    wordOrNot = wordOrNot + text.charAt(i);
                } else {
                    found = true;
                }
            }
        }
        return wordOrNot;
    }

    /**
     *
     * Class to put in alphabetical order.
     *
     */
    private static class Alphabetical
            implements Comparator<Map.Pair<String, Integer>> {
        /**
         * Sorts terms from queue in alphabetical order. *
         *
         * @param o1
         *            first term
         * @param o2
         *            second term
         *
         */
        @Override
        //compares two strings and to be sorted alphabetically
        public int compare(Map.Pair<String, Integer> o1,
                Map.Pair<String, Integer> o2) {
            return o1.key().toLowerCase().compareTo(o2.key().toLowerCase());
        }
    }

    /**
     *
     * Class to put in numerical order.
     *
     */
    private static class Numerical
            implements Comparator<Map.Pair<String, Integer>> {
        /**
         * Sorts terms from queue in alphabetical order. *
         *
         * @param o1
         *            first term
         * @param o2
         *            second term
         *
         */
        @Override
        //compares two integers and to be sorted numerically
        public int compare(Map.Pair<String, Integer> o1,
                Map.Pair<String, Integer> o2) {
            return o2.value().compareTo(o1.value());
        }
    }

    /**
     * Sorts the map m using the Comparator decOrder and puts numWords from map
     * m into sorting machine alphSm.
     *
     * @param m
     *            the queue
     * @param alphSm
     *            sorting machine to sort the entries alphabetically
     * @param decOrder
     *            the comparator ordering to sort the words by their counts
     * @param numWords
     *            the number of words to include in the Tag Cloud
     * @updates alphSm
     * @clears m
     * @requires <pre>
     * m is not empty
     * </pre>
     * @ensures <pre>
     * alphSm has words  sorted according decOrder
     * </pre>
     */
    public static void sort(Map<String, Integer> m,
            SortingMachine<Map.Pair<String, Integer>> alphSm,
            Comparator<Map.Pair<String, Integer>> decOrder, int numWords) {
        assert decOrder != null : "Violation of: order is not null";

        SortingMachine<Map.Pair<String, Integer>> dec = new SortingMachine1L<>(
                decOrder);
        /*
         * removes every element from m and adds them to dec to sort them in
         * decreasing order based on their counts (values)
         */
        while (m.size() > 0) {
            Map.Pair<String, Integer> remove = m.removeAny();
            dec.add(remove);
        }
        /* changes dec to extraction mode */
        dec.changeToExtractionMode();

        /*
         * removes every pair from dec and puts numWords pairs from dec into
         * alphSm
         */
        while (dec.size() > 0 && alphSm.size() < numWords) {
            Map.Pair<String, Integer> remove = dec.removeFirst();
            alphSm.add(remove);
        }
    }

    /**
     * Counts the number of times each word appears in the file and stores the
     * word and count in a map.
     *
     * @param inFile
     *            source of all the words for table
     * @param m
     *            empty map that will contain all words and counts
     * @updates m
     * @updates words
     * @requires inFile.is_open
     * @ensures m has all words and counts and queue has all the words
     *          alphabetically sorted
     */
    private static void countWordsFillMap(Map<String, Integer> m,
            SimpleReader inFile) {

        /*
         * decides separators and set that will store separators then fills set
         * using generateElements method
         */
        final String separatorStr = "\n -![]';:/()\r\t, 1234567890.?$@--*_";
        Set<Character> separatorSet = new Set1L<>();
        generateElements(separatorStr, separatorSet);

        /* runs through entire file */
        while (!inFile.atEOS()) {
            /* stores entire line in a string */
            String line = inFile.nextLine();
            /* starts at beginning of line */
            int position = 0;
            /* runs until end of line */
            while (position < line.length()) {
                /* gets a word or String of separators */
                String word = nextWordOrSeparator(line, position, separatorSet);

                /* gets first character in the String word */
                Character charWord = word.charAt(0);
                /*
                 * if the String is not a separator, then it's a word so added
                 * to map/queue
                 */
                if (!separatorSet.contains(charWord)) {
                    /*
                     * if the map doesn't already have the word, the word is
                     * added to the queue and the map with a count of 1
                     */
                    if (!m.hasKey(word.toLowerCase())) {
                        m.add(word.toLowerCase(), 1);
                    } else { /*
                              * otherwise, removes the word from map, increments
                              * the count, and adds the pair back to the map
                              */
                        Map.Pair<String, Integer> pair = m
                                .remove(word.toLowerCase());
                        Integer count = pair.value() + 1;
                        m.add(pair.key().toLowerCase(), count);
                    }
                }
                /* continues through to next word */
                position += word.length();
            }
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        //creates input and output streams
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        //prompts user for input file name and a reader to read file
        output.print("Enter input file: ");
        String inFile = input.nextLine();
        SimpleReader in = new SimpleReader1L(inFile);

        //prompts user for output file and writer to output contents to file
        output.print("Enter output file: ");
        String outFile = input.nextLine();
        SimpleWriter out = new SimpleWriter1L(outFile);

        //prompts user for number of words to be in cloud
        output.println("Enter # of words in cloud: ");
        String nIn = input.nextLine();

        //checks if input is an integer
        try {
            Integer.parseInt(nIn);
        } catch (NumberFormatException e) {
            Reporter.assertElseFatalError(false,
                    "Number of elements in the tag cloud must be a positive integer");
        }

        //if it is an integer, make the input into an integer
        int n = Integer.parseInt(nIn);

        //checks if integer is positive
        Reporter.assertElseFatalError(n > 0,
                "Number of elements in the tag cloud must be a positive integer");

        //outputs header tags to output file
        outputHeader(out, inFile, n);

        //creates map that will store all the words and counts
        Map<String, Integer> counts = new Map1L<String, Integer>();
        //counts how many times words appear in file and initializes map
        countWordsFillMap(counts, in);

        //comparators to sort the pairs by counts and alphabetically
        Comparator<Map.Pair<String, Integer>> alph = new Alphabetical();
        Comparator<Map.Pair<String, Integer>> dec = new Numerical();

        //final sorting machine that will store the words
        //sorted alphabetically after sorted by counts
        SortingMachine<Map.Pair<String, Integer>> alphSm = new SortingMachine1L<>(
                alph);
        //sorts the sorting machine alphabetically
        //after it's sorted in decreasing order by counts
        sort(counts, alphSm, dec, n);

        //prints the words to the output file
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Pair<String, Integer> p : alphSm) {
            if (p.value().compareTo(min) < 0) {
                min = p.value();
            }
            if (p.value().compareTo(max) > 0) {
                max = p.value();
            }
        }
        //changes sorting machine to extraction mode to remove pairs
        alphSm.changeToExtractionMode();
        double diff = max - min;
        while (alphSm.size() > 0) {
            int size = INITIAL_SIZE;
            Map.Pair<String, Integer> p = alphSm.removeFirst();
            if (diff != 0) {
                size = ((int) (FIRST_SIZE
                        + (SECOND_SIZE * (p.value() - min) / diff)));
            }
            out.println("<span style=\"cursor:default\" class=\"f" + size
                    + "\" title=\"count: " + p.value() + "\">" + p.key()
                    + "</span>");
        }

        //output the end tags to the output file
        outputFooter(out);

        //closing input and output streams
        output.close();
        out.close();
        in.close();
        input.close();
    }

}
