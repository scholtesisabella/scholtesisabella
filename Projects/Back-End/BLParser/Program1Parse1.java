import components.map.Map;
import components.program.Program;
import components.program.Program1;
import components.queue.Queue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;
import components.utilities.Reporter;
import components.utilities.Tokenizer;

/**
 * Layered implementation of secondary method {@code parse} for {@code Program}.
 *
 * @author Bella Scholtes and Akshaya Iyer
 *
 */
public final class Program1Parse1 extends Program1 {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Parses a single BL instruction from {@code tokens} returning the
     * instruction name as the value of the function and the body of the
     * instruction in {@code body}.
     *
     * @param tokens
     *            the input tokens
     * @param body
     *            the instruction body
     * @return the instruction name
     * @replaces body
     * @updates tokens
     * @requires <pre>
     * [<"INSTRUCTION"> is a prefix of tokens]  and
     *  [<Tokenizer.END_OF_INPUT> is a suffix of tokens]
     * </pre>
     * @ensures <pre>
     * if [an instruction string is a proper prefix of #tokens]  and
     *    [the beginning name of this instruction equals its ending name]  and
     *    [the name of this instruction does not equal the name of a primitive
     *     instruction in the BL language] then
     *  parseInstruction = [name of instruction at start of #tokens]  and
     *  body = [Statement corresponding to the block string that is the body of
     *          the instruction string at start of #tokens]  and
     *  #tokens = [instruction string at start of #tokens] * tokens
     * else
     *  [report an appropriate error message to the console and terminate client]
     * </pre>
     */
    private static String parseInstruction(Queue<String> tokens,
            Statement body) {
        assert tokens != null : "Violation of: tokens is not null";
        assert body != null : "Violation of: body is not null";
        assert tokens.length() > 0 && tokens.front().equals("INSTRUCTION") : ""
                + "Violation of: <\"INSTRUCTION\"> is proper prefix of tokens";
        //checking for syntax errors
        String startName = tokens.dequeue();
        Reporter.assertElseFatalError(Tokenizer.isIdentifier(startName),
                "Invalid identifier");
        Reporter.assertElseFatalError(tokens.dequeue().equals("IS"),
                "Invalid token");

        //parsing block
        body.parseBlock(tokens);

        //checking for syntax errors

        //if next token is not the END token , prints error message
        Reporter.assertElseFatalError(tokens.dequeue().equals("END"),
                "Invalid token");
        String name = tokens.dequeue();
        Reporter.assertElseFatalError(startName.equals(name),
                "Instruction name has multiple identifiers.");

        //returns instruction name
        return name;
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Program1Parse1() {
        super();
    }

    /*
     * Public methods ---------------------------------------------------------
     */

    @Override
    public void parse(SimpleReader in) {
        assert in != null : "Violation of: in is not null";
        assert in.isOpen() : "Violation of: in.is_open";
        Queue<String> tokens = Tokenizer.tokens(in);
        this.parse(tokens);
    }

    @Override
    public void parse(Queue<String> tokens) {
        assert tokens != null : "Violation of: tokens is not null";
        assert tokens.length() > 0 : ""
                + "Violation of: Tokenizer.END_OF_INPUT is a suffix of tokens";

        //checking to make sure dequeuing the right identifiers and tokens
        Reporter.assertElseFatalError(tokens.dequeue().equals("PROGRAM"),
                "Invalid token");
        String start = tokens.dequeue();
        Reporter.assertElseFatalError(Tokenizer.isIdentifier(start),
                "Invalid identifier");
        Reporter.assertElseFatalError(tokens.dequeue().equals("IS"),
                "Invalid token");
        //creating a new context to swap
        Map<String, Statement> ctxt = this.newContext();

        //parsing through instructions
        while (tokens.dequeue().equals("INSTRUCTION")) {
            Statement b = this.newBody();
            String instructions = parseInstruction(tokens, b);
            Reporter.assertElseFatalError(!Tokenizer.isKeyword(instructions),
                    "Identifier is primitive instruction.");
            Reporter.assertElseFatalError(!ctxt.hasKey(instructions),
                    "Instruction name is not unique.");
            ctxt.add(instructions, b);
        }
        //parsing through block
        Reporter.assertElseFatalError(tokens.dequeue().equals("BEGIN"),
                "Invalid token");
        Statement b = this.newBody();
        b.parseBlock(tokens);

        //Dequeuing the ending identifiers and tokens
        Reporter.assertElseFatalError(tokens.dequeue().equals("END"),
                "Invalid token");
        String end = tokens.dequeue();
        Reporter.assertElseFatalError(start.equals(end),
                "Program identifier is not unique.");
        String endOfInput = tokens.dequeue();
        Reporter.assertElseFatalError(endOfInput.equals(Tokenizer.END_OF_INPUT),
                "Invalid termination.");

        //swapping new name, body, and context into this
        this.setName(start);
        this.swapContext(ctxt);
        this.swapBody(b);
    }

    /*
     * Main test method -------------------------------------------------------
     */

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Get input file name
         */
        out.print("Enter valid BL program file name: ");
        String fileName = in.nextLine();
        /*
         * Parse input file
         */
        out.println("*** Parsing input file ***");
        Program p = new Program1Parse1();
        SimpleReader file = new SimpleReader1L(fileName);
        Queue<String> tokens = Tokenizer.tokens(file);
        file.close();
        p.parse(tokens);
        /*
         * Pretty print the program
         */
        out.println("*** Pretty print of parsed program ***");
        p.prettyPrint(out);

        in.close();
        out.close();
    }

}
