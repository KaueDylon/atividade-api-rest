package br.univille.poo2.api.controller;

import br.univille.poo2.api.entity.Usuario;
import br.univille.poo2.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService pessoaService) {
        this.usuarioService = pessoaService;
    }


    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }


    @GetMapping
    @RequestMapping("/{id}")
    public Usuario findAll(@PathVariable("id") Long id){
        return usuarioService.findById(id).get();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.insert(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

    @DeleteMapping
    public void delete(@RequestBody Usuario usuario){
        usuarioService.delete(usuario);
    }
}