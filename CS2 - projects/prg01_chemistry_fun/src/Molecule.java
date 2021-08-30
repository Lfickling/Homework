/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names: Jose Garcia-Martinez 900908543; Letitia Fickling 900848908
 * Description: Prg01 - Molecule Class
 */

/**
 * Molecules form when two or more atoms form chemical bonds with each other.
 */
public class Molecule {

    private Node   head;
    private String name;

    // TODO: initialize the molecule with the information provided by the user
    //me
    public Molecule(final String name) {
        this.name = name;
        head = null;
    }

    // TODO: returns the name of the molecule
    //will
    public String getName() {
        return name; // placeholder so the code compliles
    }

    // TODO: returns true/false depending whether the molecule is empty or not
    public boolean isEmpty() {
        if (head==null)
            return true;
        return false;
    }

    public int hillCompare(String a, String b) { //helper method to fake the hill method
        if (a.equals(b)) {
            return 0;
        }
        else if (a.equals("C")) {
            return -1;
        }
        else if (b.equals("C")) {
            return 1;
        }
        else if (a.equals("H")) {
            return -1;
        }
        else if (b.equals("H")) {
            return 1;
        }
        else
            return a.compareTo(b);
    }

    // TODO: The elements in a molecule must be distinct; therefore, the add method should check if an element is already in the molecule before adding it; also, the elements in a molecule should respect the Hill system, which states that carbon atoms are listed first, hydrogen atoms next, and then all other elements are added in alphabetical order
    //me
    public void add(final Element element, int amount) {
        if (head == null) { //if the molecule is empty
            Node newNode = new Node(element,amount);
            head = newNode;
        }
        else { //if the molecule isnt empty
            Node current = head;
            Node previous = null;
            while (current != null) { //while loop to respect hill system by finding 'alphabetic' place
                if (hillCompare(current.getElement().getAtomLetter(), element.getAtomLetter()) < 0) { //case where current is earlier in the 'alphabet' than element
                    previous = current;
                    current = current.getNext();
                }
                else if (hillCompare(current.getElement().getAtomLetter(), element.getAtomLetter()) == 0) { //case where current is the same as element
                    int newAmount = amount + current.getAmount();
                    Node newNode = new Node(element, newAmount);
                    newNode.setNext(current.getNext());
                    if (previous != null) {
                        previous.setNext(newNode);
                    }
                    if (current == head) {
                        head = newNode;
                    }
                    current.setNext(null);
                    break;
                }
                else { //case where there is none of element already in molecule. insert element in between previous and current
                    Node newNode = new Node(element, amount);
                    newNode.setNext(current);
                    if (current == head)  {
                        head = newNode;
                    }
                    else if (previous != null) {
                        previous.setNext(newNode);
                    }
                    break;
                }
            }
            if (current == null) { //case where there the element needs to be appended
                Node newNode = new Node(element, amount);
                previous.setNext(newNode);
            }
        }
    }


    // TODO: adds the given element, assuming that the amount is Node.DEFAULT_AMOUNT which is 1
    //me
    public void add(final Element element) {
        add(element, Node.DEFAULT_AMOUNT);
    }

    // TODO: returns true/false depending whether the target element can be found in the molecule or not
    //will
    public boolean contains(final Element target) {
        Node current = head;
        while (current != null) {
            if (current.getElement() == target)
                return true;
            current = current.getNext();
        }
        return false;
    }

    // TODO: returns the number of elements in the molecule
    //will
    public int size() {
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count; // placeholder so the code compliles
    }

    // TODO: returns the element at the given index location (null if the index is invalid)
    //me
    public Element get(int index) {
        if (index < size()) {
            Node current = head;
            int count = 0;
            while (count < index) {
                count++;
                current = current.getNext();
            }
            return current.getElement();
        }
        else
            return null;
    }

    // TODO: returns a textual representation of the molecule
    //will
    @Override
    public String toString() {
        String out = "\"" + this.name + "\": ";
        Node current = head;
        while(current != null){
            if (current.getAmount() > 1) {
                out = out + current.getElement().getAtomLetter() + "_" + current.getAmount();
            }
            else {
                out = out + current.getElement().getAtomLetter();
            }
            current = current.getNext();
        }
        return  out;
    }
}
