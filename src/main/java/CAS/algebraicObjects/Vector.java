package CAS.algebraicObjects;

import CAS.parser.VectorParser;

/**
 * A class representing the vector. It supports methods for accessing vectors, however the actual logic of the
 * computation of vectors, including the associated arithmetic and inner product, outer product, and cross product are
 * stored in the <code>VectorOperations</code> class. All entries in the vector object are doubles.
 *
 * See <a href="https://en.wikipedia.org/wiki/Vector_(mathematics_and_physics)">Vector</a>
 *
 * @author Luvai Cutlerywala
 * @version 1.3
 */
public class Vector implements Operations<Vector>{

    private final int dim;
    private final double[] vector;

    /**
     * Initialises a vector object with a vector with non-zero components.
     *
     * @param dim The dimension of the vector.
     * @param vector The vector with values.
     */
    private Vector(int dim, double[] vector){
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
    private Vector(int dim){
        if(dim <= 0){
            throw new IllegalArgumentException("Vector dimensions cannot be specified.");
        }
        this.dim = dim;
        this.vector = new double[dim];
    }

    /**
     * Returns the dimensionality of the vector.
     *
     * @return The dimension of the vector.
     */
    public int getDim(){
        return this.dim;
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

    /**
     * The grammar defined for the string representation of a vector is as follows:
     * (1, 2, 3, 4)
     * Where the initial set of brackets represents the vector matrix. The numbers themselves are the individual components
     * of the vector in that dimension. Therefore, the string representation, as given above, would yield a vector in the
     * form:
     *               1
     *               2
     *               3
     *               4
     *
     * @see CAS.parser.VectorParser
     * @param input The string representation of the vector.
     * @return The vector object representing the vector in question.
     */
    public static Vector generateObject(String input) {
        VectorParser parser = new VectorParser();
        parser.parse(input);
        double[] vector = parser.getRepresentation();

        return new Vector(vector.length, vector);
    }

    @Override
    public Vector add(Vector addend) {
        if(this.dim != addend.getDim()){
            throw new IllegalArgumentException("Vector dimensions do not match.");
        }
        double[] addendRepresentation = extractVectorRepresentation(addend);
        Vector vector = new Vector(this.dim);
        for(int i = 0; i < this.vector.length; ++i){
            vector.setComponent(i + 1, this.vector[i] + addendRepresentation[i]);
        }

        return vector;
    }

    @Override
    public Vector subtract(Vector subtrahend) {
        if(this.dim != subtrahend.getDim()){
            throw new IllegalArgumentException("Vector dimensions do not match.");
        }
        double[] subtrahendRepresentation = extractVectorRepresentation(subtrahend);
        Vector difference = new Vector(this.dim);
        for(int i = 0; i < this.vector.length; ++i){
            difference.setComponent(i + 1, this.vector[i] - subtrahendRepresentation[i]);
        }

        return difference;
    }

    @Override
    public Vector scalarMultiplication(double scalar) {
        Vector vector = new Vector(this.dim);
        for(int i = 0; i < this.vector.length; ++i){
            vector.setComponent(i + 1,scalar * this.vector[i]);
        }

        return vector;
    }

    private double[] extractVectorRepresentation(Vector vector){
        double[] representation = new double[vector.getDim()];
        for(int i = 0; i < representation.length; ++i){
            representation[i] = vector.getComponent(i + 1);
        }
        return representation;
    }
}
