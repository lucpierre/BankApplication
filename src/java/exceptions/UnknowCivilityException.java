package exceptions;

/**
 *
 * @author lucqu
 */
public class UnknowCivilityException extends Exception {
    public UnknowCivilityException(){
        super("The civility value taken is not supported");
    }
}

