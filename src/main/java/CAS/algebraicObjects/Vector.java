package CAS.algebraicObjects;

/**
 * A class representing the vector. It supports methods for accessing vectors, however the actual logic of the
 * computation of vectors, including the associated arithmetic and inner product, outer product, and cross product are
 * stored in the <code>VectorOperations</code> class. All entries in the vector object are doubles.
 *
 * See <a href="https://en.wikipedia.org/wiki/Vector_(mathematics_and_physics)">Vector</a>
 *
 * @see CAS.operations.VectorOperations
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class Vector{

    private final int dim;
    private final double[] vector;

    /**
     * Initialises a vector object with a vector with non-zero components.
     *
     * @param dim The dimension of the vector.
     * @param vector The vector with values.
     */
    protected Vector(int dim, double[] vector){
        if(dim <= 0){
            throw new IllegalArgumentException("Vector dimensions cannot be zero.");
        }
        this.dim = dim;
        this.vector = vector;
    }

    /**
     * Initialises a vector object with a zero vector.
     *
     * @param dim The dimension of the vector.
     */
    protected Vector(int dim){
        if(dim <= 0){
            throw new IllegalArgumentException("Vector dimensions cannot be specified.");
        }
        this.dim = dim;
        this.vector = new double[dim];
    }

    /**
     * Returns the component of the vector at the specified index. Indexing starts from 1.
     *
     * @param index The index of the component.
     * @return The component at the specified index.
     */
    public double getComponent(int index){
        if(index <= 0 || index > dim){
            throw new IllegalArgumentException("Component specified does not exist.");
        }

        return vector[index - 1];
    }

    /**
     * Sets the component at the specified index of the vector to the value specified.
     *
     * @param index The index of the component to be set.
     * @param component The value of the component to be set.
     */
    public void setComponent(int index, double component){
        if(index <= 0 || dim < index){
            throw new IllegalArgumentException("Component specified does not exist.");
        }

        vector[index - 1] = component;
    }
}
