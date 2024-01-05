package CAS;

import CAS.parser.PolynomialParser;

import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args){
        PolynomialParser parser = new PolynomialParser();
        parser.parse("12.5x^4 + 3.141592654x^3 + 15x^2 + 9837459x + 32");
        HashMap<Integer, Double> map = parser.getRepresentation();

        Set<Integer> keys = map.keySet();
        for (Integer key: keys){
            System.out.print("Degree = " + key);
            System.out.println("    Coefficient = " + map.get(key));
        }
    }

}
