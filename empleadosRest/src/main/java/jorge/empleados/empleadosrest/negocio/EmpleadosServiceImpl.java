package jorge.empleados.empleadosrest.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jorge.empleados.empleadosrest.daos.EmpDAO;
import jorge.empleados.model.Empleado;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

	@Resource(name="daoJdbc")
	private EmpDAO dao;
	
	private List<Empleado> empleados = new ArrayList<Empleado>();
	public EmpleadosServiceImpl() {
		empleados.add(new Empleado("5233232F","Felipe","Fernando", 31));
		empleados.add(new Empleado("1253153J","Marcos","Rubicon", 12));
		empleados.add(new Empleado("9646545H","Carlos","Sabatini", 78));
		empleados.add(new Empleado("6523436Q","Raul","Ordoñez", 93));
	}

	@Override
	public String getEmpleadoString(int i) {
		if(i>empleados.size()) return "";
		return empleados.get(i).getNombre() + " " + empleados.get(i).getApellidos();
	}

	@Override
	public Empleado getEmpleado(String cif) {
		return dao.getEmpleado(cif);		
	}

	@Override
	public List<Empleado> getEmpleados() {
		return dao.getAllEmpleados();
	}
	
	@Override
	public boolean updateEmpleado(Empleado empleado){
		return dao.modificaEmpleado(empleado);		
	}

	@Override
	public boolean updateEmpleado(String oldcif, Empleado empleado){
		return dao.modificaEmpleado(oldcif, empleado);		
	}
	
	@Override
	public boolean deleteEmpleado(String cif){
		return dao.eliminaEmpleado(cif);		
	}
	
	@Override
	public boolean insertaEmpleado(Empleado empleado){
		return dao.insertaEmpleado(empleado);		
	}
}
