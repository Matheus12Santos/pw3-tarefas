package br.com.etechas.tarefas.mapper;

import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.entity.Usuario;

public class UsuarioMapper {
    public static <UsuarioCadastroDTO> Usuario toEntity(UsuarioCadastroDTO cadastro) {
        Usuario usuario = new Usuario();
        usuario.setUsername(cadastro.username());
        usuario.setPassword(cadastro.password()); // Idealmente, você deveria criptografar aqui
        usuario.setRole(cadastro.role());
        return usuario;
    }

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getUsername(), usuario.getRole());
    }
}
