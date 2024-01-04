package CAS.parser;

public interface Parser<T> {

    void parse(String input);
    T generateObject();

}
