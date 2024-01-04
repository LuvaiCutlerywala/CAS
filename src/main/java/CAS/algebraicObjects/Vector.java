package CAS.algebraicObjects;

import CAS.utils.Tuple;

public class Vector extends Matrix{
    protected Vector(Tuple<Integer, Integer> dim, double[][] matrix) {
        super(dim, matrix);
    }

    protected Vector(Tuple<Integer, Integer> dim) {
        super(dim);
    }
}
