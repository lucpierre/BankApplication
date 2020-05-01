package exceptions;

/**
 *
 * @author lucqu
 */
public class LoginAlreadyUsedException extends Exception{
    public LoginAlreadyUsedException(){
        super("The login is already used in the database and will break unique constraint.");
    }
}
