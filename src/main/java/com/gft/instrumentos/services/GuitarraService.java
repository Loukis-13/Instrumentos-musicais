package com.gft.instrumentos.services;

import com.gft.instrumentos.entities.Guitarra;
import com.gft.instrumentos.repositories.GuitarraRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GuitarraService {
    GuitarraRepository guitarraRepository;

    public Guitarra salvarGuitarra(Guitarra guitarra) {
        if (guitarra.getId() != null) {
            Guitarra g = guitarraRepository.getById(guitarra.getId());
            File f = new File("src/main/resources/static"+g.getImagem());
            f.delete();
        }

        // a imagem chega no campo imagem como uma stringBase64;
        // metodo salvarImagem transforma a string em binario,
        // salva a imagem e retorna o diretório no qual ela está
        guitarra.setImagem(salvarImagem(guitarra.getImagem()));

        return guitarraRepository.save(guitarra);
    }

    public Guitarra obterGuitarra(Long id) throws Exception {
        Optional<Guitarra> desenvolvedor = guitarraRepository.findById(id);

        if (desenvolvedor.isEmpty()) {
            throw new Exception("Guitarra não encontrada");
        }

        return desenvolvedor.get();
    }

    public List<Guitarra> listarGuitarras() {
        return guitarraRepository.findAll();
    }

    public void excluirGuitarra(Long id) {
        Guitarra g = guitarraRepository.getById(id);
        File f = new File("src/main/resources/static"+g.getImagem());
        f.delete();

        guitarraRepository.deleteById(id);
    }

    public String salvarImagem(String base64) {
        // gera nome aleatorio para a imagem
        String nomeArquivo = new Random().ints(48, 123)
                                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                                    .limit(8)
                                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                    .toString() + ".png";

        byte[] decodedBytes = Base64.getDecoder().decode(base64.split(",")[1]);

        try {
            FileOutputStream out = new FileOutputStream("src/main/resources/static/images/guitarras/" + nomeArquivo);
            out.write(decodedBytes);
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "/images/guitarras/" + nomeArquivo;
    }
}
