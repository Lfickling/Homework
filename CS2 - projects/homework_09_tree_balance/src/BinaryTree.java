/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 09 - BinaryTree class
 * Name:
 */

public class BinaryTree<T extends Comparable<T>> {

    private BinNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private BinNode<T> addRecursively(BinNode<T> current, final T data) {
        if (current == null)
            return new BinNode<T>(data);
        else {
            if (data.compareTo(current.getData()) < 0)
                current.setLeft(addRecursively(current.getLeft(), data));
            else if (data.compareTo(current.getData()) > 0)
                current.setRight(addRecursively(current.getRight(), data));
            return current;
        }
    }

    public void add(final T data) {
        if (isEmpty())
            root = new BinNode<T>(data);
        else
            addRecursively(root, data);
    }

    @Override
    public String toString() {
        Queue<BinNode<T>> queue = new Queue<>();
        BinNode<T> current = root;
        queue.push(current);
        String str = "";
        while (!queue.isEmpty()) {
            current = queue.pop();
            str += current.getData() + " ";
            if (current.getLeft() != null)
                queue.push(current.getLeft());
            if (current.getRight() != null)
                queue.push(current.getRight());
        }
        return str;
    }

    private boolean searchRecursively(final BinNode<T> current, final T data) {
        if (current == null)
            return false;
        else if (data.compareTo(current.getData()) == 0)
            return true;
        else if (data.compareTo(current.getData()) < 0)
            return searchRecursively(current.getLeft(), data);
        else
            return searchRecursively(current.getRight(), data);
    }

    public boolean search(final T data) {
        return searchRecursively(root, data);
    }

    // TODO: implement the height helper method
    private int height(final BinNode<T> current) {
        if (current == null) {
            return 0;
        }
        return 0; // placeholder
    }

    public int height() {
        return height(root);
    }

    // TODO: implement the isBalanced helper method
    private boolean isBalanced(final BinNode<T> current) {
        if (height() <= 1) {
            return true;
        }
        return false; // placeholder
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }
}
/*
    private BinNode<T> addRecursively(BinNode<T> current, final T data) {

        // TODO: check if current is null, if that is the case, return a new BinNode with the data
        if (current == null) {
            return new BinNode<>(data);
        }
        // TODO: if current is not null...
        else {

            // TODO: if given data is smaller than current data, call addRecursively to the left, making sure to use the method's return to set current's left node
            if (data.compareTo(current.getData()) < 0)
                current.setLeft(addRecursively(current.getLeft(), data));
            // TODO: if given data is greater than current data, call addRecursively to the right, making sure to use the method's return to set current's right node
            else
                current.setRight(addRecursively(current.getRight(), data));
            // TODO: don't forget to return current
            return current;
        }
    }
 */