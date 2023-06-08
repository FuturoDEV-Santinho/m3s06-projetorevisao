package br.com.santinho.m3s06projetorevisao.controller;

import br.com.santinho.m3s06projetorevisao.entity.Autor;
import br.com.santinho.m3s06projetorevisao.entity.Emprestimo;
import br.com.santinho.m3s06projetorevisao.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping("{id}")
    public ResponseEntity getId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(emprestimoService.buscar(id));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("usuario/{usuarioId}")
    public ResponseEntity getUsuario(@PathVariable Long usuarioId) {
        try {
            return ResponseEntity.ok(emprestimoService.buscarPorUsuario(usuarioId));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Emprestimo emprestimo) {
        try {
            return ResponseEntity.ok(emprestimoService.criar(emprestimo));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
