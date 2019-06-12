package exception;

public class CursoAtivoDAOException extends RuntimeException{

	private static final long serialVersionUID = 6413012489217985535L;

	public CursoAtivoDAOException() {
		super();
	}
	
	public CursoAtivoDAOException(String msg) {
		super(msg);
	}
	
}

