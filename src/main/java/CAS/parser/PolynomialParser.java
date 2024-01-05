package CAS.parser;

import CAS.algebraicObjects.Polynomial;

import java.util.HashMap;

public class PolynomialParser implements Parser<Polynomial> {

    private HashMap<Integer, Double> coefficients;

    @Override
    public void parse(String input) {

    }

    @Override
    public HashMap<Integer, Double> getRepresentation() {
        return coefficients;
    }
}
