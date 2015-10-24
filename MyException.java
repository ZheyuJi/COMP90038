/**
 * this is a exception class extends RuntimeException
 *  
 * @author name: 
 * @author login name:
 * @author Student ID:
 * 
 */


public final class MyException extends RuntimeException {
	/** use serialVersionUID from JDK 1.1 for interoperability */
	private static final long serialVersionUID = 4889014741112099515L;
	
	 /** Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
	public MyException() {
		super();
	}
	
	
	 /** Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   msg   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
	MyException(String msg){
		super(msg);
	}
}
