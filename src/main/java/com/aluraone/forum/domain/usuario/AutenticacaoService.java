package com.aluraone.forum.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    //para decirle a spring que a classe e responsavel de autenticacao de usuario

    @Autowired
    private UsuarioRepository repository;


    @Override public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        return repository.findByEmail(login);
        //email é o nome do atributo que representa o login
    }
}
