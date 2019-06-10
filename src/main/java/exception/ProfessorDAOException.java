package exception;

public class ProfessorDAOException extends RuntimeException{

	private static final long serialVersionUID = -3271412843417346965L;

	public ProfessorDAOException() {
		super();
	}
	
	public ProfessorDAOException(String msg) {
		super(msg);
	}
}

