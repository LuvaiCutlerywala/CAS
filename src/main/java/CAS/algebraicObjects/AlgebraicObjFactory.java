package CAS.algebraicObjects;

/**
 * Object creation should be encapsulated by a factory, which regulates how the objects are constructed. All algebraic
 * objects, such as polynomials, vectors, or matrices, should all be generated purely by these factories, as the end
 * user should not be exposed to any parsing logic. All the end user should ideally see is an algebra system, with any
 * logic that does not involve the algebra defined over algebraic structures in the CAS.
 *
 * @param <T>
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public interface AlgebraicObjFactory<T>{

    /**
     * Generates an algebraic object of the type specified by the factory. The parsing for the string is not handled by
     * the factory, however, it is encapsulated within it. All input strings must adhere to the proper grammar as
     * defined by the object factories.
     *
     * @param input The string representation of the object.
     * @return The object with type specified by the class of factory used.
     */
    T generateObject(String input);

}
