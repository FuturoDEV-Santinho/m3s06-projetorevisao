package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Livro;
import br.com.santinho.m3s06projetorevisao.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorService autorService;

    @Override
    public Livro salvar(Livro livro) throws Exception {

        if (livro.getId() != null) {
            buscar(livro.getId());
        }

        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new Exception("Título é obrigatório");
        }

        if (livro.getCategoria() == null || livro.getCategoria().isEmpty()) {
            throw new Exception("Categoria é obrigatório");
        }

        if (livro.getClassificacaoEtaria() == null) {
            throw new Exception("Classificação Etária é obrigatório");
        }

        if (livro.getNumeroPaginas() == null) {
            throw new Exception("Número de Páginas é obrigatório");
        }

        if (livro.getAutor() == null || livro.getAutor().getId() == null) {
            throw new Exception("Autor é obrigatório");
        }
        livro.setAutor(autorService.buscar(livro.getAutor().getId()));

        if (livro.getEditora() == null || livro.getEditora().isEmpty()) {
            throw new Exception("Editora é obrigatório");
        }

        if (livro.getQuantidadeDisponivel() == null) {
            livro.setQuantidadeDisponivel(0);
        }
        if (livro.getQuantidadeDisponivel() < 0) {
            throw new Exception("Quantidade disponível precisa ser maior ou igual a ZERO");
        }

        return livroRepository.save(livro);
    }

    @Override
    public List<Livro> buscar() {
        return livroRepository.findAll();
    }

    @Override
    public Livro buscar(Long id) throws Exception {
        Optional<Livro> opt = livroRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("Livro não encontrado!");
        }
        return opt.get();
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        Livro livro = buscar(id);
        try {
            livroRepository.delete(livro);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
