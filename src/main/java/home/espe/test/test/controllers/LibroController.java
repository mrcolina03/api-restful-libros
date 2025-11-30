package home.espe.test.test.controllers;

import home.espe.test.test.models.entities.Libro;
import home.espe.test.test.services.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // -------- GET: obtener todos --------
    @GetMapping
    public ResponseEntity<List<Libro>> listar() {
        return ResponseEntity.ok(libroService.buscarTodos());
    }

    // -------- GET: buscar por ID --------
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return libroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // -------- POST: crear --------
    @PostMapping
    public ResponseEntity<Libro> crear(@Valid @RequestBody Libro libro) {
        Libro nuevoLibro = libroService.guardar(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    // -------- PUT: actualizar --------
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id,
                                            @Valid @RequestBody Libro libroDetalles) {

        return libroService.buscarPorId(id)
                .map(libroDB -> {
                    libroDB.setTitulo(libroDetalles.getTitulo());
                    libroDB.setAutor(libroDetalles.getAutor());
                    libroDB.setGenero(libroDetalles.getGenero());

                    Libro actualizado = libroService.guardar(libroDB);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // -------- DELETE: eliminar --------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return libroService.buscarPorId(id)
                .map(libro -> {
                    libroService.eliminarPorId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
