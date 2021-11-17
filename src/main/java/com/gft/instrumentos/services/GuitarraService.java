package com.gft.instrumentos.services;

import com.gft.instrumentos.entities.Guitarra;
import com.gft.instrumentos.repositories.GuitarraRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GuitarraService {
    GuitarraRepository guitarraRepository;

    public Guitarra salvarGuitarra(Guitarra guitarra) {
        return guitarraRepository.save(guitarra);
    }

    public List<Guitarra> listarGuitarras() {
        return guitarraRepository.findAll();
    }

    public void excluirGuitarra(Long id) {
        guitarraRepository.deleteById(id);;
    }

    public Guitarra obterGuitarra(Long id) throws Exception {
        Optional<Guitarra> desenvolvedor = guitarraRepository.findById(id);

        if (desenvolvedor.isEmpty()) {
            throw new Exception("Guitarra não encontrada");
        }

        return desenvolvedor.get();
    }
}
