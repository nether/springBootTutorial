package jorge.empleados.empleadosweb.services;

import jorge.empleados.model.Empleado;

public interface EmpleadoService {
	Empleado getEmpleado(String cif);
	Empleado[] getEmpleados();
	void insertarEmpleado(Empleado empleado);
	void modificarEmpleado(String cif, Empleado empleado);
	void eliminarEmpleado(String cif);
}
