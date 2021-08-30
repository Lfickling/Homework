/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - BinaryTree class
 * Name: Letitia Fickling
 */

import java.util.Iterator;

public class BinaryTree implements Iterable<Player> {

    private BinNode root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // TODO: add the given player to the binary tree based on the player's game score
    public void add(final Player player) {
        if (isEmpty())
            root = new BinNode(player);
        else {
            BinNode newNode = new BinNode(player);
            BinNode current = root;
            while (true) {
                if (player.compareTo(current.getPlayer()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(newNode);
                        return;
                    } else
                        current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(newNode);
                        return;
                    } else
                        current = current.getRight();
                }
            }
        }
    }

    public Stack<BinNode> inOrder(final BinNode current , Stack<BinNode> stack) { //helper method
        if (current != null) {
            inOrder(current.getLeft(), stack);
            stack.push(current);
            inOrder(current.getRight(), stack);
        }
        return stack;
    }

    // TODO: return a string representation of the binary tree showing all players (one per line) in descending order of scores
    @Override
    public String toString() {
            BinNode current = root;
            Stack<BinNode> stack = new Stack<>();
            stack = inOrder(current, stack);
            String str = "";
            while (!stack.isEmpty()) {
                current = stack.pop();
                str += current.getPlayer().toString() + " \n";
            }
            return str;
    }


    // TODO: return an iterator for the binary tree to be used to save the tree in persistent media.
    @Override
    public Iterator<Player> iterator() {
        return new Iterator<Player>() {

            private Stack<BinNode> stack = new Stack<>(root);

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Player next() {
                if (!stack.isEmpty()) {
                    BinNode current = stack.pop();
                    if (current.getLeft() != null)
                        stack.push(current.getLeft());
                    if (current.getRight() != null)
                        stack.push(current.getRight());
                    return current.getPlayer();
                }
                else
                    return null;
            }
        };
    }
}