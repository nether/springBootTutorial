package jorge.empleados.departamentosrest.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import jorge.empleados.model.Departamento;

public interface DptosMongoRepository extends MongoRepository<Departamento, String> {

}
