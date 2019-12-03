package by.htp.jd2.maksimkosmachev.test.dao.exception;

public class TestNotExistException extends Exception {
    public TestNotExistException() {
    }

    public TestNotExistException(String message) {
        super(message);
    }

    public TestNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
