package exception;

public class CursoDAOException extends RuntimeException{

	private static final long serialVersionUID = 6413012489217985535L;

	public CursoDAOException() {
		super();
	}
	
	public CursoDAOException(String msg) {
		super(msg);
	}
	
}
