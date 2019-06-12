package exception;

public class AulaDAOException extends RuntimeException{

	private static final long serialVersionUID = -9077146009971761808L;

	public AulaDAOException() {
		super();
	}
	
	public AulaDAOException(String msg) {
		super(msg);
	}
	
}
