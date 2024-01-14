package CAS.parser;

/**
 * Defines the interface for a generic Parser. Each algebraic object will have its own parser, as the representation
 * grammar is unique to each and every object. An interface simply unifies the way the user sees the Parser component of
 * the CAS. This also simplifies the Factories for the algebraic object, as they have their individual parsing logic,
 * yet from a user standpoint, they all have the same logic.
 *
 * @param <T> The type of the object to be parsed.
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public interface Parser<T> {

    /**
     * Reads a string, and extracts data to then generate a representation object for the associated factory for said
     * object. The string representation for each object is unique, which means a polynomial is parsed separately to a
     * matrix, and so on and so forth.
     *
     * @param input The string representation to be parsed.
     */
    void parse(String input);

    /**
     * Returns a representation object for each of algebraic object. The representation object simply holds the data in
     * the structure specified by the algebraic object, it contains no metadata about the actual algebraic structure of
     * the object, which is only contained in the associated type for the algebraic object.
     *
     * @return The representation object for the associated algebraic object.
     */
    Object getRepresentation();
}
