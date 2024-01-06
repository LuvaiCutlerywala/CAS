package CAS.algebraicObjFactory;

import CAS.algebraicObjects.Vector;
import CAS.parser.VectorParser;

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
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class VectorFactory{

    static Vector generateObject(String input) {
        VectorParser parser = new VectorParser();
        parser.parse(input);
        double[] vector = parser.getRepresentation();

        return new Vector(vector.length, vector);
    }
}
