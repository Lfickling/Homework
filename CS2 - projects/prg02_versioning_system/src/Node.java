/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:Letitia Fickling and Jose Garcia-Martinez
 * Description: Prg 02 - Node Class
 */

/**
 * A generic Node class implementation
 */
public class Node<T> {

    private T    data;
    private Node next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(T data) {
        this.data = data;
        next      = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}