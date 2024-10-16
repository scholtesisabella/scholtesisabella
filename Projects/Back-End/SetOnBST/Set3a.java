import java.util.Iterator;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTree1;
import components.set.Set;
import components.set.SetSecondary;

/**
 * {@code Set} represented as a {@code BinaryTree} (maintained as a binary
 * search tree) of elements with implementations of primary methods.
 *
 * @param <T>
 *            type of {@code Set} elements
 * @mathdefinitions <pre>
 * IS_BST(
 *   tree: binary tree of T
 *  ): boolean satisfies
 *  [tree satisfies the binary search tree properties as described in the
 *   slides with the ordering reported by compareTo for T, including that
 *   it has no duplicate labels]
 * </pre>
 * @convention IS_BST($this.tree)
 * @correspondence this = labels($this.tree)
 *
 * @author Bella Scholtes
 *
 */
public class Set3a<T extends Comparable<T>> extends SetSecondary<T> {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Elements included in {@code this}.
     */
    private BinaryTree<T> tree;

    /**
     * Returns whether {@code x} is in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} labels
     * @param t
     *            the {@code BinaryTree} to be searched
     * @param x
     *            the label to be searched for
     * @return true if t contains x, false otherwise
     * @requires IS_BST(t)
     * @ensures isInTree = (x is in labels(t))
     */
    private static <T extends Comparable<T>> boolean isInTree(BinaryTree<T> t,
            T x) {
        assert t != null : "Violation of: t is not null";
        assert x != null : "Violation of: x is not null";

        //creates left and right tress and initializes isInTree boolean variable
        boolean inTree = false;
        BinaryTree<T> tLeft = t.newInstance();
        BinaryTree<T> tRight = t.newInstance();

        //checks if the tree is not empty
        if (t.size() > 0) {
            //stores values of the left and right trees into the variables
            T root = t.disassemble(tLeft, tRight);
            //if the value is the root, say that the value is in the tree
            if (x.compareTo(root) == 0) {
                inTree = true;

                //if x is bigger than the root, check the right subtree using recursion
            } else if (x.compareTo(root) > 0) {
                inTree = isInTree(tRight, x);
                //if x is less than the root, check the left subtree using recursion
            } else if (x.compareTo(root) < 0) {
                inTree = isInTree(tLeft, x);
            }
            t.assemble(root, tLeft, tRight);
        }

        //return whether or not the value is in the tree
        return inTree;
    }

    /**
     * Inserts {@code x} in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} labels
     * @param t
     *            the {@code BinaryTree} to be searched
     * @param x
     *            the label to be inserted
     * @aliases reference {@code x}
     * @updates t
     * @requires IS_BST(t) and x is not in labels(t)
     * @ensures IS_BST(t) and labels(t) = labels(#t) union {x}
     */
    private static <T extends Comparable<T>> void insertInTree(BinaryTree<T> t,
            T x) {
        assert t != null : "Violation of: t is not null";
        assert x != null : "Violation of: x is not null";

        //creating left and right trees of t
        BinaryTree<T> l = t.newInstance();
        BinaryTree<T> r = t.newInstance();
        //if t is empty, makes x the root of binary tree
        T root = x;
        if (t.size() > 0) {
            //Disassembling tree into left and right tree and node and root
            root = t.disassemble(l, r);

            //if x<r , adds x to left tree
            if (x.compareTo(root) < 0) {
                insertInTree(l, x);
            } else {
                //if x > r, adds x to right tree
                insertInTree(r, x);
            }

        }
        t.assemble(root, l, r);

    }

    /**
     * Removes and returns the smallest (left-most) label in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} labels
     * @param t
     *            the {@code BinaryTree} from which to remove the label
     * @return the smallest label in the given {@code BinaryTree}
     * @updates t
     * @requires IS_BST(t) and |t| > 0
     * @ensures <pre>
     * IS_BST(t)  and  removeSmallest = [the smallest label in #t]  and
     *  labels(t) = labels(#t) \ {removeSmallest}
     * </pre>
     */
    private static <T> T removeSmallest(BinaryTree<T> t) {
        assert t != null : "Violation of: t is not null";
        assert t.size() > 0 : "Violation of: |t| > 0";
        T smallest = null;

        //creating left and right trees of t
        BinaryTree<T> l = t.newInstance();
        BinaryTree<T> r = t.newInstance();
        //Disassembling tree into left and right tree and node
        T root = t.disassemble(l, r);

        //if the tree is just the root, sets smallest to root
        if (l.size() == 0) {
            smallest = root;
            t.transferFrom(r);
        } else {
            //recursive call to smallest
            smallest = removeSmallest(l);
            t.assemble(root, l, r);
        }

        // returns smallest label
        return smallest;
    }

    /**
     * Finds label {@code x} in {@code t}, removes it from {@code t}, and
     * returns it.
     *
     * @param <T>
     *            type of {@code BinaryTree} labels
     * @param t
     *            the {@code BinaryTree} from which to remove label {@code x}
     * @param x
     *            the label to be removed
     * @return the removed label
     * @updates t
     * @requires IS_BST(t) and x is in labels(t)
     * @ensures <pre>
     * IS_BST(t)  and  removeFromTree = x  and
     *  labels(t) = labels(#t) \ {x}
     * </pre>
     */
    private static <T extends Comparable<T>> T removeFromTree(BinaryTree<T> t,
            T x) {
        assert t != null : "Violation of: t is not null";
        assert x != null : "Violation of: x is not null";
        assert t.size() > 0 : "Violation of: x is in labels(t)";
        T result = null;
        //getting value of root
        T root = t.root();
        //creating left and right trees of t
        BinaryTree<T> l = t.newInstance();
        BinaryTree<T> r = t.newInstance();
        //Disassembling tree into left and right tree and node
        t.disassemble(l, r);

        //if t is empty, makes x the root of binary tree
        if (root.equals(x)) {
            result = root;
            //checks if right subtree is empty
            if (r.size() > 0) {
                //if not empty,  makes smallest node of r the new root of t
                t.assemble(removeSmallest(r), l, r);
            } else {
                //if is empty, makes subtree new value of t
                t.transferFrom(l);
            }
        } else {

            //if x<r , adds x to left tree
            if (x.compareTo(root) < 0) {
                result = removeFromTree(l, x);
            } else {
                //if x > r, adds x to right tree
                result = removeFromTree(r, x);
            }
            //reassembles new tree
            t.assemble(root, l, r);
        }

        // returns removed label
        return result;
    }

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.tree = new BinaryTree1<>();

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Set3a() {

        this.createNewRep();

    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @SuppressWarnings("unchecked")
    @Override
    public final Set<T> newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Set<T> source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Set3a<?> : ""
                + "Violation of: source is of dynamic type Set3<?>";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case: source must be of dynamic type Set3a<?>, and
         * the ? must be T or the call would not have compiled.
         */
        Set3a<T> localSource = (Set3a<T>) source;
        this.tree = localSource.tree;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void add(T x) {
        assert x != null : "Violation of: x is not null";
        assert !this.contains(x) : "Violation of: x is not in this";

        //inserts x in tree
        insertInTree(this.tree, x);

    }

    @Override
    public final T remove(T x) {
        assert x != null : "Violation of: x is not null";
        assert this.contains(x) : "Violation of: x is in this";

        //removes and returns
        return removeFromTree(this.tree, x);
    }

    @Override
    public final T removeAny() {
        assert this.size() > 0 : "Violation of: this /= empty_set";

        // This line added just to make the component compilable.
        return removeSmallest(this.tree);
    }

    @Override
    public final boolean contains(T x) {
        assert x != null : "Violation of: x is not null";

        //returns if tree contains x
        return isInTree(this.tree, x);
    }

    @Override
    public final int size() {

        //returns size of tree
        return this.tree.size();
    }

    @Override
    public final Iterator<T> iterator() {
        return this.tree.iterator();
    }

}
