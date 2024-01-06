package CAS;

import CAS.algebraicObjFactory.AlgebraicObjectFactory;
import CAS.algebraicObjects.Vector;

public class Main {

    public static void main(String[] args){
        Vector vector = (Vector) AlgebraicObjectFactory.generateObject("(1, 2, 3, 4)");
        for(int i = 1; i < 5; ++i){
            System.out.println(vector.getComponent(i));
        }
    }

}
