package CAS.algebraicObjects;

import CAS.parser.MatrixParser;
import CAS.utils.Tuple;

import java.util.Objects;

/**
 * A class to represent the matrix. It supports methods for accessing matrices, however the actual logic of the
 * computation of matrices, including associated arithmetic and trace, determinant, transpose, and inverse are stored in
 * the <code>MatrixOperations</code> class. All entries in the matrix object are doubles.
 *
 * See <a href="https://en.wikipedia.org/wiki/Matrix_(mathematics)">Matrix</a>
 *
 * @author Luvai Cutlerywala
 * @version 1.2
 */
public class Matrix implements Operations<Matrix>{

    private final Tuple<Integer, Integer> dim;
    private final double[][] matrix;

    /**
     * Initialises a Matrix object with a matrix with given values.
     *
     * @param dim The dimensions of the matrix
     * @param matrix The matrix with values.
     */
    private Matrix(Tuple<Integer, Integer> dim, double[][] matrix){
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
    private Matrix(Tuple<Integer, Integer> dim){
        if(dim.getB() <= 0 || dim.getA() <= 0){
            throw new IllegalArgumentException("Matrix dimensions cannot be zero.");
        }
        this.dim = dim;
        this.matrix = new double[dim.getA()][dim.getB()];
    }

    /**
     * Returns the dimensionality of the matrix.
     *
     * @return The dimensions of a matrix.
     */
    public Tuple<Integer, Integer> getDim(){
        return this.dim;
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

    /**
     * The grammar, as defined for the string representation of a matrix is:
     *      ((1, 2, 3), (4, 5, 6), (7, 8, 9))
     * Where the initial set of brackets represents actual matrix. The inner brackets, which wrap around each list of
     * numbers, represent the row of the matrix. The numbers themselves are the individual columns of the associated
     * row. Therefore, the string representation, as given above, would yield a matrix in the form:
     *               1   2   3
     *               4   5   6
     *               7   8   9
     *
     * @see CAS.parser.MatrixParser
     * @param input The string representation of the matrix.
     * @return The matrix object representing the matrix in question.
     */
    public static Matrix generateObject(String input) {
        MatrixParser parser = new MatrixParser();
        parser.parse(input);
        double[][] matrixRepresentation = parser.getRepresentation();

        return new Matrix(new Tuple<>(matrixRepresentation.length, matrixRepresentation[0].length), matrixRepresentation);
    }

    @Override
    public Matrix add(Matrix addend) {
        double[][] addendRepresentation = extractMatrixRepresentation(addend);
        Matrix matrix = new Matrix(addend.getDim());
        for(int i = 0; i < addendRepresentation.length; ++i){
            for(int j = 0; j < addendRepresentation[0].length; ++j){
                matrix.setMatrixElement(new Tuple<>(i + 1, j + 1), (addendRepresentation[i][j] + this.matrix[i][j]));
            }
        }

        return matrix;
    }

    @Override
    public Matrix subtract(Matrix subtrahend) {
        double[][] subtrahendRepresentation = extractMatrixRepresentation(subtrahend);
        Matrix matrix = new Matrix(subtrahend.getDim());
        for(int i = 0; i < subtrahendRepresentation.length; ++i){
            for(int j = 0; j < subtrahendRepresentation[0].length; ++j){
                matrix.setMatrixElement(new Tuple<>(i + 1, j + 1), (this.matrix[i][j] - subtrahendRepresentation[i][j]));
            }
        }

        return matrix;
    }

    @Override
    public Matrix scalarMultiplication(double scalar) {
        Matrix matrix = new Matrix(new Tuple<>(this.matrix.length, this.matrix[0].length));
        for(int i = 0; i < this.matrix.length; ++i){
            for(int j = 0; j < this.matrix[0].length; ++j){
                matrix.setMatrixElement(new Tuple<>(i + 1, j + 1), scalar * this.matrix[i][j]);
            }
        }

        return matrix;
    }

    private double[][] extractMatrixRepresentation(Matrix matrix){
        Tuple<Integer, Integer> dimensions = matrix.getDim();
        if(!Objects.equals(dimensions.getA(), dim.getA()) || !Objects.equals(dimensions.getB(), dim.getB())){
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }
        double[][] matrixRepresentation = new double[this.dim.getA()][this.dim.getB()];
        for(int i = 0; i < matrixRepresentation.length; ++i){
            for(int j = 0; j < matrixRepresentation[0].length; ++j){
                matrixRepresentation[i][j] = matrix.getMatrixElement(new Tuple<>(i + 1, j + 1));
            }
        }

        return matrixRepresentation;
    }
}
