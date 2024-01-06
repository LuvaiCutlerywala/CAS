package CAS.algebraicObjFactory;

import CAS.algebraicObjects.AlgebraicObject;

public class AlgebraicObjectFactory {

    public static AlgebraicObject generateObject(String input){
        if(input.contains("^")){
            return PolynomialFactory.generateObject(input);
        } else if(input.contains("((") && input.contains("))")){
            return MatrixFactory.generateObject(input);
        }

        return VectorFactory.generateObject(input);
    }

}
