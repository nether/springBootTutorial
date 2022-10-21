package jorge.empleados.exceptions;

public class EmpleadoNoEncontradoException extends EmpleadosException {

	private static final long serialVersionUID = 1L;

	public EmpleadoNoEncontradoException() {
	}

	public EmpleadoNoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpleadoNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadoNoEncontradoException(String message) {
		super(message);
	}

	public EmpleadoNoEncontradoException(Throwable cause) {
		super(cause);
	}

}
