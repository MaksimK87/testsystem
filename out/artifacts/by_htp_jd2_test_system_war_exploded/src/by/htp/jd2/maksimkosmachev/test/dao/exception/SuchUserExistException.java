package by.htp.jd2.maksimkosmachev.test.dao.exception;

public class SuchUserExistException extends Exception {
    public SuchUserExistException() {
        super();
    }

    public SuchUserExistException(String message) {
        super(message);
    }

    public SuchUserExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
