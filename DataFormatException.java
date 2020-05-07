/**
 * This exception is thrown when malformed data is detected while a file being parsed.
 */
public class DataFormatException extends Exception  {
    
    //–Ú¡–ªØ
    private static final long serialVersionUID = 1L;

	/**
	 * Constructs a <code>DataFormatException</code> with no detail
	 * message.
	 */
	public DataFormatException() {

	}

	/**
	 * Constructs a <code>DataFormatException</code> with the
	 * specified detail message.
	 *
	 * @param message  the malformed data
	 */
	public DataFormatException(String message) {

		super(message);
	}
}
