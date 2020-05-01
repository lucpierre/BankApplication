package service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucqu
 */
@Service
public class PasswordService {
    
    /**
     * Take a string, hash it with SHA-256
     * 
     * @param string
     * @return the hashed string
     * @throws NoSuchAlgorithmException 
     */
    public static String hashString(String string) throws NoSuchAlgorithmException {
        
        MessageDigest message_digest = MessageDigest.getInstance("SHA-256");
        byte[]hashInBytes = message_digest.digest(string.getBytes(StandardCharsets.UTF_8));

       //bytes to hex
        StringBuilder string_builder = new StringBuilder();
        for (byte b : hashInBytes) {
            string_builder.append(String.format("%02x", b));
        }
        
        return string_builder.toString();
    }
    
    /**
     * Take a hashed (SHA-256) string and a plain one, compare them and say if they are the same string
     * 
     * @param hashed_string
     * @param plain_string
     * @return true if the thow strings are the smae else false
     * @throws java.security.NoSuchAlgorithmException
     */
    public static boolean compareString(String hashed_string, String plain_string) throws NoSuchAlgorithmException {
        MessageDigest message_digest = MessageDigest.getInstance("SHA-256");
        byte[]hashInBytes = message_digest.digest(plain_string.getBytes(StandardCharsets.UTF_8));

       //bytes to hex
        StringBuilder string_builder = new StringBuilder();
        for (byte b : hashInBytes) {
            string_builder.append(String.format("%02x", b));
        }
        
        String hashed_plain_string = string_builder.toString();
        
        return hashed_plain_string.equals(hashed_string);
    }
}
