package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.UsuarioCadastradoDTO;
import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.entity.Usuario;
import br.com.etechas.tarefas.mapper.UsuarioMapper;
import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO registrar(UsuarioCadastradoDTO cadastro) {
        var existe = repository.findByUsername(cadastro.username());
        if (existe.isPresent()) {
            throw new RuntimeException("Nome do usuário já existe.");
        }
        var entidade = mapper.toEntity(cadastro);
        var senhaCifrada = passwordEncoder.encode(cadastro.password());

        var salvo = repository.save(entidade);
        return mapper.toUsuarioResponseDTO(salvo);
    }

    public List<UsuarioResponseDTO> findAll() {
        return mapper.toUsuarioResponseDTOList(repository.findAll());
    }
}
