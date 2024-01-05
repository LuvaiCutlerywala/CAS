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

    private final ArrayList<Object[]> elements = new ArrayList<>();

    @Override
    public void parse(String input) {

        if(elements.size() != 0){
            elements.subList(0, elements.size()).clear();
        }

        String replacedString = input.replaceAll("\\(", ""); //Removes all the leading opening brackets making it easier to parse
        String[] rows = replacedString.split("\\)"); //Splits the string into the row strings.
        for (String row : rows) {
            String[] temp = row.split(","); //Splits the rows into individual elements.
            ArrayList<String> array = new ArrayList<>();
            for (String s : temp) {
                if (!s.isBlank()) {
                    array.add(s.strip()); //Only adds the newly split elements  if they are not blank, prevents addition of extra empty space elements.
                }
            }
            elements.add(array.toArray()); //Adds row to matrix representation.
        }
    }

    @Override
    public double[][] getRepresentation() {
        //Converts to internal matrix representation to more useful form for user.
        double[][] matrix = new double[elements.size()][elements.get(0).length];
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                matrix[i][j] = Double.parseDouble((String) elements.get(i)[j]);
            }
        }

        return matrix;
    }
}
