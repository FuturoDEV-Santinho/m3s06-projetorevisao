package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Autor;
import br.com.santinho.m3s06projetorevisao.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor salvar(Autor autor) throws Exception {

        if (autor.getId() != null) {
            buscar(autor.getId());
        }

        if (autor.getNome() == null || autor.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }
        if (autor.getNome().length() > 15) {
            throw new Exception("Nome deve ter menos que 15 caracteres");
        }

        if (autor.getSobrenome() == null || autor.getSobrenome().isEmpty()) {
            throw new Exception("Sobrenome é obrigatório");
        }
        if (autor.getSobrenome().length() > 30) {
            throw new Exception("Sobrenome deve ter menos que 30 caracteres");
        }

        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> buscar() {
        return autorRepository.findAll();
    }

    @Override
    public Autor buscar(Long id) throws Exception {
        Optional<Autor> opt = autorRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("Autor não encontrado!");
        }
        return opt.get();
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        Autor autor = buscar(id);
        try {
            autorRepository.delete(autor);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
