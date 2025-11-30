package home.espe.test.test.services;

import home.espe.test.test.models.entities.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<Libro> buscarTodos();
    Optional<Libro> buscarPorId(Long id);
    Libro guardar(Libro libro);
    void eliminarPorId(Long id);



}
