package jorge.empleados.departamentosrest.services;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import jorge.empleados.exceptions.EmpleadoDuplicadoException;
import jorge.empleados.exceptions.EmpleadoNoEncontradoException;

public class EmpleadosResponseErrorHandled extends DefaultResponseErrorHandler {

	public EmpleadosResponseErrorHandled() {
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		switch(response.getStatusCode()) {
			case NOT_FOUND:
				throw new EmpleadoNoEncontradoException();
			case CONFLICT:
				throw new EmpleadoDuplicadoException();
			default:
				super.handleError(response);
		}		
	}

}
