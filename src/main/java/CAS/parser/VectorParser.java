package CAS.parser;

import CAS.algebraicObjects.Vector;

/**
 * Extracts the vector data from the provided string representation, and then generates a structure
 * preserving object that holds the data before it is passed to associated type of the algebraic object. The grammar for
 * a vector string representation is as such:
 *          (1, 2, 3, 4)
 * Where the initial set of brackets represents the vector matrix. The numbers themselves are the individual components
 * of the vector in that dimension. Therefore, the string representation, as given above, would yield a vector in the
 * form:
 *              1
 *              2
 *              3
 *              4
 *
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class VectorParser implements Parser<Vector> {

    private double[] vector;

    @Override
    public void parse(String input) {
        String[] components = input.strip().replaceAll("\\(", "")
                .replaceAll("\\)", "").split(",");
        vector = new double[components.length];
        for(int i = 0; i < vector.length; ++i){
            vector[i] = Double.parseDouble(components[i].strip());
        }
    }

    @Override
    public double[] getRepresentation() {
        return vector;
    }
}
