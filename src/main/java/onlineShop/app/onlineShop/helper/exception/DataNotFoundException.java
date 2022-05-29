package onlineShop.app.onlineShop.helper.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super(message);
    }
}
