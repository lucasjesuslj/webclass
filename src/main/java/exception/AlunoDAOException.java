package exception;

public class AlunoDAOException extends RuntimeException{

	private static final long serialVersionUID = -3271412843417346965L;

	public AlunoDAOException() {
		super();
	}
	
	public AlunoDAOException(String msg) {
		super(msg);
	}

	public AlunoDAOException(Throwable trw) {
		super(trw);
	}

	public AlunoDAOException(String msg, Throwable trw) {
		super(msg, trw);
	}
	
}
