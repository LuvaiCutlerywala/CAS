package CAS.algebraicObjects;

import CAS.utils.Tuple;

/**
 * A class to represent the matrix. It supports methods for accessing matrices, however the actual logic of the
 * computation of matrices, including associated arithmetic and trace, determinant, transpose, and inverse are stored in
 * the <code>MatrixOperations</code> class. All entries in the matrix object are doubles.
 *
 * See <a href="https://en.wikipedia.org/wiki/Matrix_(mathematics)">Matrix</a>
 *
 * @see CAS.operations.MatrixOperations
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class Matrix {

    private final Tuple<Integer, Integer> dim;
    private final double[][] matrix;

    /**
     * Initialises a Matrix object with a matrix with given values.
     *
     * @param dim The dimensions of the matrix
     * @param matrix The matrix with values.
     */
    protected Matrix(Tuple<Integer, Integer> dim, double[][] matrix){
        if(dim.getA() <= 0 || dim.getB() <= 0){
            throw new IllegalArgumentException("Matrix dimensions cannot be 0.");
        }
        this.dim = dim;
        this.matrix = matrix;
    }

    /**
     * Initialises a Matrix object with an empty matrix.
     *
     * @param dim The dimensions of the matrix.
     */
    protected Matrix(Tuple<Integer, Integer> dim){
        if(dim.getB() <= 0 || dim.getA() <= 0){
            throw new IllegalArgumentException("Matrix dimensions cannot be zero.");
        }
        this.dim = dim;
        this.matrix = new double[dim.getA()][dim.getB()];
    }

    /**
     * Returns the value of the matrix element at the index specified. Indexing starts from 1.
     *
     * @param index The index of the element.
     * @return The value of the element at the specified index.
     */
    public double getMatrixElement(Tuple<Integer, Integer> index){
        if(index.getA() > dim.getA() || index.getB() > dim.getB() || index.getA() <= 0 || index.getB() <= 0) {
            throw new IllegalArgumentException("Element specified does not exist.");
        }
        return matrix[index.getA() - 1][index.getB() - 1];
    }

    /**
     * Sets the value of the matrix element at the index specified to the value provided. Indexing starts from 1.
     *
     * @param index The index of the element.
     * @param element The value to set the element to.
     */
    public void setMatrixElement(Tuple<Integer, Integer> index, double element){
        if(index.getA() > dim.getA() || index.getB() > dim.getB() || index.getA() <= 0 || index.getB() <= 0){
            throw new IllegalArgumentException("Element specified does not exist.");
        }
        matrix[index.getA() - 1][index.getB() - 1] = element;
    }

}
