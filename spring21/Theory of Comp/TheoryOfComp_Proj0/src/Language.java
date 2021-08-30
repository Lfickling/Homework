import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * Represents a finite language.
 *
 * @author Dr. Jody Paul
 * @author Letitia Fickling
 * @version 1.3.1
 */
public final class Language implements Iterable<String>, java.io.Serializable {
    /** The empty string. */
    private static final String EMPTY_STRING = "";
    /** The empty set. */
    private static final Set<String> EMPTY_SET = new TreeSet<String>();

    /** The set of strings in this language, initially empty. */
    private Set<String> strings;

    /**
     * Create a language with no strings.
     */
    public Language() {
        this.strings = new TreeSet<String>();
    }

    /**
     * Indicates if this language has no strings.
     * @return true if the language is equivalent to the empty set;
     *         false otherwise
     */
    public boolean isEmpty() {
        /*if (this.strings.equals(EMPTY_SET)) {
            //return true;
        }
        return false; */
        return this.strings.isEmpty(); //TreeSet has this functionality
    }

    /**
     * Accesses the number of strings (cardinality) in this language.
     * @return the cardinality of the language
     */
    public int cardinality() {
        /*int count = 0;
        for (String string : this.strings) { //for each through strings
            count++;
        }
        return count; */
        return this.strings.size(); //TreeSet has this functionality
    }

    /**
     * Determines if a specified string is in this language.
     * @param candidate the string to check
     * @return true if the string is in the language,
     *         false if not in the language or the parameter is null
     */
    public boolean includes(final String candidate) {
        return this.strings.contains(candidate); //TreeSet has this functionality
    }

    /**
     * Ensures that this language includes the given string
     * (adds it if necessary).
     * @param memberString the string to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addString(final String memberString) {
        return (this.strings.add(memberString)); //TreeSet has this functionality
    }

    /**
     * Ensures that this language includes all of the strings
     * in the given parameter (adds any as necessary).
     * @param memberStrings the strings to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addAllStrings(final Collection<String> memberStrings) { //TreeSet has this functionality
        return this.strings.addAll(memberStrings);
    }

    /**
     * Provides an iterator over the strings in this language.
     * @return an iterator over the strings in this language in ascending order
     */
    public Iterator<String> iterator() { //TreeSet has this functionality
        return this.strings.iterator();
    }

    /**
     * Creates a language that is the concatenation of this language
     * with another language.
     * @param language the language to be concatenated to this language
     * @return the concatenation of this language with the parameter language
     */
    public Language concatenate(final Language language) {
        Language newLanguage = new Language();
        for (String string1 : this) { //for each through strings
            for (String string2 : language) { //for each through language
                newLanguage.addString(string1 + string2); //adds the concatenated string to the new language
            }
        }
        return newLanguage;
    }

    /**
     * determines whether two languages are the same, both by checking whether they refer to the same object, and by checking that they are of the same length and contain the exact same set of strings
     * @param obj the language to be compared to this language
     * @return true if the languages are the same
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Language) {
            if (this == obj)
                return true;
            if (cardinality() != ((Language) obj).cardinality())
                return false;
            for (String string1 : this) {
                if (!((Language) obj).includes(string1))
                    return false;
                }
            return true;
        }
        return false;
    }

    /**
     * generates a hashcode associated with this language
     * @return an integer
     */
    @Override
    public int hashCode() { //TreeSet has this functionality
        return this.strings.hashCode();
    }
}
