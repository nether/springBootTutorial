package jorge.empleados.empleadosrest.negocio;

import java.util.List;

import jorge.empleados.model.Empleado;

public interface EmpleadosService {
	public List<Empleado> getEmpleados();
	public String getEmpleadoString(int i);
	public Empleado getEmpleado(String i);
	boolean updateEmpleado(Empleado empleado);
	boolean updateEmpleado(String oldcif, Empleado empleado);
	boolean insertaEmpleado(Empleado empleado);
	boolean deleteEmpleado(String cif);
}
