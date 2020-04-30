package exceptions;

/**
 *
 * @author lucqu
 */
public class SenderOrRecieverMessageException extends Exception {
    public SenderOrRecieverMessageException(){
        super("The sender or the reciever of the message has not been set.");
    }
}
