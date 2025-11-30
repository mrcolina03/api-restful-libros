package home.espe.test.test.services;

import home.espe.test.test.models.entities.Libro;
import home.espe.test.test.repositories.LibroRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> buscarTodos() {
        return (List<Libro>) repository.findAll();
    }

    @Override
    public Optional<Libro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Libro guardar(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public void eliminarPorId(Long id){
        repository.deleteById(id);
    }



}