package exceptions;

/**
 *
 * @author lucqu
 */
public class CreateAccountException extends Exception{
    public CreateAccountException(){
        super("The system cannot to create the new account.");
    }
    
    public CreateAccountException(String msg){
        super(msg);
    }
}
