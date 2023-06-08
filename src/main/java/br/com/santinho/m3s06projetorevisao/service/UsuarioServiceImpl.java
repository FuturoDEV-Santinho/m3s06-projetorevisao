package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Usuario;
import br.com.santinho.m3s06projetorevisao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) throws Exception {

        if (usuario.getId() != null) {
            buscar(usuario.getId());
        }

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }

        if (usuario.getNascimento() == null) {
            throw new Exception("Data de Nascimento é obrigatório");
        }

        if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
            throw new Exception("Cpf é obrigatório");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("E-mail é obrigatório");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> buscar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscar(Long id) throws Exception {
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("Usuario não encontrado!");
        }
        return opt.get();
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        Usuario usuario = buscar(id);
        try {
            usuarioRepository.delete(usuario);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
