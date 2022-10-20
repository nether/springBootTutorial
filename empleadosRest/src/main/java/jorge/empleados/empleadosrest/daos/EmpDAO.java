package jorge.empleados.empleadosrest.daos;

import java.util.List;

import jorge.empleados.model.Empleado;

public interface EmpDAO {

	Empleado getEmpleado(String cif);
	
	List<Empleado> getAllEmpleados();
	
	boolean insertaEmpleado(Empleado emp);

	boolean modificaEmpleado(Empleado emp);
	
	boolean modificaEmpleado(String cif, Empleado emp);

	boolean eliminaEmpleado(String cif);

}
