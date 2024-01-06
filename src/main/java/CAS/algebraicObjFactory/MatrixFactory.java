package CAS.algebraicObjFactory;

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
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class MatrixFactory {


}
