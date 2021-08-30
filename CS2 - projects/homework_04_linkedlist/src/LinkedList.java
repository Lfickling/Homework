/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 04 - LinkedList
 */

public class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (isEmpty())
            head = newNode;
        else {
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode);
        }
    }

    public int get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size()) {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.getNext();
                i++;
            }
            return current.getData();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        String out = "";
        Node current = head;
        while (current != null) {
            out += current.toString() + " ";
            current = current.getNext();
        }
        return out;
    }

    // remove all references between nodes and set head to null
    void clear() {
        Node current = head;
        while (current != null) {
            Node temp = current.getNext();
            current.setNext(null);
            current = temp;
        }
        head = null;
    }

    // TODO: implement the invert method
    void invert() {
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }
}