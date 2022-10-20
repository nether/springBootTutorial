package jorge.empleados.exceptions;

public class EmpleadoDuplicadoException extends EmpleadosException {

	private static final long serialVersionUID = 1L;

	public EmpleadoDuplicadoException() {
	}

	public EmpleadoDuplicadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpleadoDuplicadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadoDuplicadoException(String message) {
		super(message);
	}

	public EmpleadoDuplicadoException(Throwable cause) {
		super(cause);
	}

}
