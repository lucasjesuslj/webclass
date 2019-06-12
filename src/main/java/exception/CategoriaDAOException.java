package exception;

public class CategoriaDAOException extends RuntimeException{

	private static final long serialVersionUID = -3271412843417346965L;

	public CategoriaDAOException() {
		super();
	}
	
	public CategoriaDAOException(String msg) {
		super(msg);
	}

}

