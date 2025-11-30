package home.espe.test.test.repositories;

import home.espe.test.test.models.entities.Libro;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface LibroRepository extends CrudRepository<Libro, Long> {


}
