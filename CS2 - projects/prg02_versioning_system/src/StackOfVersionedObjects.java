/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names: Letitia Fickling and Jose Garcia-Martinez
 * Description: Prg 02 - StackOfVersionedObjects Class
 */

import java.util.EmptyStackException;

/**
 * A StackOfVersionedObjects uses a stack to keep a collection of VersionedObjects that share the same key. The version numbers of the objects increase as they move up the stack. When the stack becomes empty, no more objects are allowed to enter the stack.
 */
public class StackOfVersionedObjects {

    private Node<VersionedObject> latest;
    private String                key;

    public StackOfVersionedObjects(String key, final Object object) {
        this.key = key;
        VersionedObject vrObject = new VersionedObject(object);
        latest = new Node<>(vrObject);
    }

    public boolean isEmpty() {
        return latest == null;
    }

    // TODO: create a new version of the given object by pushing it to the top of the stack; the new versioned object should have the version of the latest object plus one; ; if the stack is empty, this method should throw an EmptyStackException
    public void put(final Object object) throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        else{
            int newVersion = latest.getData().getVersion() + 1;
            VersionedObject cvObject = new VersionedObject(object,newVersion);
            Node<VersionedObject> newNode = new Node<>(cvObject);
            newNode.setNext(latest);
            latest = newNode;
        }

    }

    // TODO: return the latest version of the object; if the stack is empty, this method should throw an EmptyStackException
    public Object get() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return latest.getData().getObject();
        }
    }

    // TODO: delete the latest version of the object; if the stack is empty, this method should throw an EmptyStackException
    public void delete() { //if returning latest version would be public Object delete() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            //VersionedObject latestObject = latest.getData();
            // instructions say: return the latest version of the object* but that isn't consistent with the to do above
            Node<VersionedObject> tempNode = latest;
            latest = latest.getNext();
            tempNode.setNext(null);
            /*if returning latest version would be:
            return tempNode.getData();
             */
        }
    }

    public String getKey() {
        return key;
    }

    // TODO: override toString showing all versions of the object; you must follow the format described in the instructions
    @Override
    public String toString() {
        String list = "key: " + key;
        if (latest == null) {
            list += "; this stack is empty!";
        }
        else {
            Node<VersionedObject> current = latest;
            while (current != null) {
                list += "\n\t";
                list += current.getData();
                current = current.getNext();
            }
        }
        return list; // placeholder
    }
}