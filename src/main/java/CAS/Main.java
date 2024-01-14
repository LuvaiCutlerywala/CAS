package CAS;

import CAS.algebraicObjects.Vector;

public class Main {

    public static void main(String[] args){
        Vector vector = Vector.generateObject("(1, 2, 3, 4)");
        Vector sum = vector.scalarMultiplication(4);
        for(int i = 0; i < vector.getDim(); ++i){
            System.out.println(sum.getComponent(i + 1));
        }
    }

}
