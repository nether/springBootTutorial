package jorge.empleados.exceptions;

public class EmpleadosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmpleadosException() {
		super();
	}

	public EmpleadosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpleadosException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadosException(String message) {
		super(message);
	}

	public EmpleadosException(Throwable cause) {
		super(cause);
	}

}
