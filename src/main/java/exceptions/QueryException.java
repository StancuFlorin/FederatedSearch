package exceptions;

/**
 * Created by fstancu on 5/23/2014.
 */
public class QueryException extends Exception {

    public QueryException() {
        super();
    }

    public QueryException(String message) {
        super(message);
    }

    public QueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryException(Throwable cause) {
        super(cause);
    }

}