package med.voll.api.config;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("Chamando o Filter!");

        var tokenJWT = recuperaToken(request);
        if(tokenJWT != null){
            System.out.println("Token recebido: " +tokenJWT);
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = usuarioRepository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

       //  System.out.println(subject);

       filterChain.doFilter(request, response);
        System.out.println("Logado na Requisicao");

    }

    private String recuperaToken(HttpServletRequest request){

        var authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null){


            return authorizationHeader.replace("Bearer ","");
        }

        return null;
    }



}
