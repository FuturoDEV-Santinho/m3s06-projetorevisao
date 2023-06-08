package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Emprestimo;
import br.com.santinho.m3s06projetorevisao.entity.EmprestimoLivro;
import br.com.santinho.m3s06projetorevisao.entity.Usuario;
import br.com.santinho.m3s06projetorevisao.repository.EmprestimoRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoServiceImpl implements EmprestimoService{

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;

    @Override
    public Emprestimo buscar(Long id) throws Exception {
        Optional<Emprestimo> opt = emprestimoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("Emprestimo não encontrado!");
        }
        return opt.get();
    }

    @Override
    public List<Emprestimo> buscarPorUsuario(Long usuarioId) {
        return emprestimoRepository.findByUsuarioIdOrderByDataEmprestimoDesc(usuarioId);
    }

    @Override
    public Emprestimo criar(Emprestimo emprestimo) throws Exception {

        emprestimo.setId(null);
        emprestimo.setDataEmprestimo(new Date());
        emprestimo.setDataDevolucao(DateUtils.addMonths(new Date(), 1));
        emprestimo.setValorMulta(BigDecimal.TEN);

        if (emprestimo.getUsuario() == null || emprestimo.getUsuario().getId() == null) {
            throw new Exception("Usuário é obrigatório");
        }
        emprestimo.setUsuario(usuarioService.buscar(emprestimo.getUsuario().getId()));

        if (emprestimo.getItens() == null || emprestimo.getItens().isEmpty()) {
            throw new Exception("Itens são obrigatórios");
        }

        for (EmprestimoLivro item : emprestimo.getItens()) {
            item.setEmprestimo(emprestimo);

            if (item.getLivro() == null || item.getLivro().getId() == null) {
                throw new Exception("Livro é obrigatório");
            }
            item.setLivro(livroService.buscar(item.getLivro().getId()));

        }

        emprestimo.setQuantidadeLivros(emprestimo.getItens().size());

        return emprestimoRepository.save(emprestimo);
    }

}
