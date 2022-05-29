package onlineShop.app.onlineShop.helper.security;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sha1Security {

    public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));

        return new BigInteger(1, crypt.digest()).toString(16);
    }


}