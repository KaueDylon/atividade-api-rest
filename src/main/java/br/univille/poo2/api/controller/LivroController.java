package br.univille.poo2.api.controller;

import br.univille.poo2.api.entity.Livro;
import br.univille.poo2.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro criar(@RequestBody Livro livro) {
        return service.insert(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        return ResponseEntity.ok(service.update(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var livroOpt = service.findById(id);
        if (livroOpt.isPresent()) {
            service.delete(livroOpt.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}