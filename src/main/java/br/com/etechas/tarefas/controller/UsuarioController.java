package br.com.etechas.tarefas.controller;

import br.com.etechas.tarefas.dto.UsuarioCadastradoDTO;
import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.entity.Usuario;
import br.com.etechas.tarefas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> registrar(@RequestBody UsuarioCadastradoDTO cadastro){
        UsuarioResponseDTO response = service.registrar(cadastro);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<UsuarioResponseDTO> findAll() {
        return service.findAll();
    }
}
