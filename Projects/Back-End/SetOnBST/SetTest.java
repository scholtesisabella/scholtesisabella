import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Bella Scholtes
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    // TODO - add test cases for constructor, add, remove, removeAny, contains, and size

    @Test
    public final void testConstructor() {
        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.constructorTest();
        Set<String> sExpected = this.constructorRef();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testLengthEmpty() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        /*
         * Call method under test
         */
        int length = s.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(length, 0);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testLengthNonEmpty() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("blue", "red", "green");
        Set<String> sExpected = this.createFromArgsRef("blue", "red", "green");

        /*
         * Call method under test
         */
        int length = s.size();
        int lengthExpected = sExpected.size();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(length, lengthExpected);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAddEmpty() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef("red");
        /*
         * Call method under test
         */
        s.add("red");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAddNonEmpty() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("green");
        Set<String> sExpected = this.createFromArgsRef("red", "green");

        /*
         * Call method under test
         */
        s.add("red");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAddNonEmptyManyElements() {
        /*
         * Set up variables
         */

        Set<String> s = this.createFromArgsTest("red", "yellow", "blue");
        Set<String> sExpected = this.createFromArgsRef("red", "green", "blue",
                "yellow");

        /*
         * Call method under test
         */
        s.add("green");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoved() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "blue", "green");
        Set<String> sExpected = this.createFromArgsRef("red", "blue");

        /*
         * Call method under test
         */
        String removed = s.remove("green");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(removed, "green");
    }

    @Test
    public final void testRemovedTwoWithDifferentOrder() {
        /*
         *
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "blue", "green");
        Set<String> sExpected = this.createFromArgsRef("green", "blue");

        /*
         * Call method under test
         */
        String removed = s.remove("red");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(removed, "red");
    }

    @Test
    public final void testRemoveUntilEmpty() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "green", "blue");
        Set<String> sExpected = this.createFromArgsRef();

        /*
         * Call method under test
         */
        String removed = s.remove("red");
        String removed1 = s.remove("blue");
        String removed2 = s.remove("green");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(removed, "red");
        assertEquals(removed1, "blue");
        assertEquals(removed2, "green");
    }

    @Test
    public final void testContainsEmpty() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        /*
         * Call method under test
         */
        boolean test = s.contains("red");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(test, false);
    }

    @Test
    public final void testContainsNonEmptyEdgeTrue() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red");
        Set<String> sExpected = this.createFromArgsRef("red");

        /*
         * Call method under test
         */
        boolean test = s.contains("red");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(test, true);
    }

    @Test
    public final void testContainsNonEmptyEdgeFalse() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red");
        Set<String> sExpected = this.createFromArgsRef("red");

        /*
         * Call method under test
         */
        boolean test = s.contains("blue");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(test, false);
    }

    @Test
    public final void testContainsNonEmptyTrue() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "blue", "green",
                "yellow");
        Set<String> sExpected = this.createFromArgsRef("red", "blue", "yellow",
                "green");

        /*
         * Call method under test
         */
        boolean test = s.contains("green");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(test, true);
    }

    @Test
    public final void testContainsNonEmptyFalse() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "blue", "green",
                "yellow");
        Set<String> sExpected = this.createFromArgsRef("red", "blue", "yellow",
                "green");

        /*
         * Call method under test
         */
        boolean test = s.contains("pink");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(test, false);
    }

    @Test
    public final void testRemoveAnyEdge() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red");
        Set<String> sExpected = this.createFromArgsRef();

        /*
         * Call method under test
         */
        String test = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(test, "red");
    }

    @Test
    public final void testRemoveAnyRoutine() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "blue", "pink",
                "yellow");
        Set<String> sExpected = this.createFromArgsRef("red", "blue", "pink",
                "yellow");

        /*
         * Call method under test
         */
        String test = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, sExpected.contains(test));
        sExpected.remove(test);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testRemoveAnyOrder() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "blue", "pink",
                "yellow");
        Set<String> sExpected = this.createFromArgsRef("pink", "blue", "red",
                "yellow");

        /*
         * Call method under test
         */
        String test = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, sExpected.contains(test));
        sExpected.remove(test);
        assertEquals(s, sExpected);
    }
