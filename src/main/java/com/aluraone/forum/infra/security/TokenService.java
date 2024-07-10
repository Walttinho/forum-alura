package com.aluraone.forum.infra.security;

import com.aluraone.forum.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String gerarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256("123");
            //o algoritmo recebe uma senha secreta
           return JWT.create()
                    .withIssuer("API ForumHub") //identifica a API responsavel pela geração de token
                    .withSubject(usuario.getEmail())//dizendo quiem é o usuario a que pertence esse token
                    .withClaim("id", usuario.getId()) //assim passo cualquer informação
                   //pode chamar ele varias vesses, arquivo chave:valor
                   .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
