package CAS.utils;

/**
 * Representation of a tuple. Tuples are heterogeneous immutable objects, which hold a pair of values.
 * See <a href="https://en.wikipedia.org/wiki/Tuple">Tuple</a>
 *
 * @param <A> The type of the first value.
 * @param <B> The type of the second value.
 * @author Luvai Cutlerywala
 */
public class Tuple<A, B> {

    private final A a;
    private final B b;

    public Tuple(A a, B b){
        this.a = a;
        this.b = b;
    }

    /**
     * Returns the value of the object with type A.
     *
     * @return The value of object with type A.
     * @author Luvai Cutlerywala
     */
    public A getA(){
        return this.a;
    }

    /**
     * Returns the value of the object with type B.
     *
     * @return The value of the object with type B.
     * @author Luvai Cutlerywala
     */
    public B getB(){
        return b;
    }
}
