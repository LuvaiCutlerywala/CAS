package CAS.algebraicObjFactory;

public class AlgebraicObjectFactory {

    public static <T> T generateAlgebraicObject(T type, String input){
        return new AlgebraicObjFactory<T>().generateObject(input);
    }


}
