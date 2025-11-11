package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBusiness implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        return usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com username: " + username));
    }
}
