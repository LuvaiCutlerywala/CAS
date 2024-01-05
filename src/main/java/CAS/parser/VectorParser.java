package CAS.parser;

import CAS.algebraicObjects.Vector;

public class VectorParser implements Parser<Vector> {

    private double[] vector;

    @Override
    public void parse(String input) {

    }

    @Override
    public double[] getRepresentation() {
        return vector;
    }
}
