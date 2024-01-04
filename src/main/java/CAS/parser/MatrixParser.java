package CAS.parser;

import CAS.algebraicObjects.Matrix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extracts the matrix data from the provided string representation, and then generates a structure
 * preserving object that holds the data before it is passed to associated type of the algebraic object. The grammar for
 * a matrix string representation is as such:
 *          ((1, 2, 3), (4, 5, 6), (7, 8, 9))
 * Where the initial set of brackets represents actual matrix. The inner brackets, which wrap around each list of
 * numbers, represent the row of the matrix. The numbers themselves are the individual columns of the associated
 * row. Therefore, the string representation, as given above, would yield a matrix in the form:
 *               1   2   3
 *               4   5   6
 *               7   8   9
 *
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class MatrixParser implements Parser<Matrix> {

    private double[][] matrix;

    @Override
    public void parse(String input) {
        int rows, columns;

    }

    @Override
    public Object getRepresentation() {
        return null;
    }

    private int numberOfMatches(Matcher matcher){
        int count = 0;
        for(; matcher.find(); ++count);
        return count;
    }
}
