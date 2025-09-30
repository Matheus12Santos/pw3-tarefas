package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.entity.Usuario;
import br.com.etechas.tarefas.mapper.UsuarioMapper;
import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public <UsuarioCadastroDTO> UsuarioResponseDTO registrar(UsuarioCadastroDTO cadastro) {
        if (usuarioRepository.findByUsername(username()).isEmpty()) {
            Usuario usuario = UsuarioMapper.toEntity(cadastro);
            Usuario salvo = usuarioRepository.save(usuario);

            return UsuarioMapper.toUsuarioResponseDTO(salvo);
        } else {
            throw new RuntimeException("Username já está em uso.");
        }

    }

    private String username() {
        return null;
    }
}
