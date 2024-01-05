package CAS.parser;

import CAS.algebraicObjects.Matrix;

import java.util.ArrayList;

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
        String str = "((1, 2, 3), (4, 5, 6), (7, 8, 9))";
        String replacedString = str.replaceAll("\\(", "");
        String[] rows = replacedString.split("\\)");
        ArrayList<Object[]> elements = new ArrayList<>();
        for (String row : rows) {
            String[] temp = row.split(",");
            ArrayList<String> array = new ArrayList<>();
            for (String s : temp) {
                if (!s.isBlank()) {
                    array.add(s.strip());
                }
            }
            elements.add(array.toArray());
        }

        this.matrix = new double[elements.size()][elements.get(0).length];
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                this.matrix[i][j] = Double.parseDouble((String) elements.get(i)[j]);
            }
        }
    }

    @Override
    public double[][] getRepresentation() {
        return this.matrix;
    }
}
