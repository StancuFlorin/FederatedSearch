package exceptions;

/**
 * Clasa pentru execeptiile care sunt aruncate in caz ca raspunsul
 * primit de la unul din cele 3 servere nu este cel asteptat.
 *
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
