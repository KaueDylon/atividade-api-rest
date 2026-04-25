package br.univille.poo2.api.controller;

import br.univille.poo2.api.entity.Emprestimo;
import br.univille.poo2.api.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping
    public List<Emprestimo> listar() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo emprestar(@RequestBody Map<String, Long> dados) {
        Long usuarioId = dados.get("usuarioId");
        Long livroId = dados.get("livroId");

        if (usuarioId == null || livroId == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "É necessário informar usuarioId e livroId.");
        }

        return service.realizarEmprestimo(usuarioId, livroId);
    }

    @PatchMapping("/{id}/devolver")
    public Emprestimo devolver(@PathVariable Long id) {
        return service.devolver(id);
    }
}