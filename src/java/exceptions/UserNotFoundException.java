package exceptions;

/**
 *
 * @author lucqu
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("No user found.");
    }
}
