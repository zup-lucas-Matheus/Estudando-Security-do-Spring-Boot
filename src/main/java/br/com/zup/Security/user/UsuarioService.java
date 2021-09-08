package br.com.zup.Security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRespository.save(usuario);
    }

    public Usuario findUsuario(int id){
        Optional<Usuario> usuarioOptional = usuarioRespository.findById(id);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuario não encontrado");
        }
        return usuarioOptional.get();
    }

}
