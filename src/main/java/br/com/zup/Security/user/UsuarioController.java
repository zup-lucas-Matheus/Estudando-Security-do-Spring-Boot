package br.com.zup.Security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("{/idUsuario}")
    public Usuario findUsuario(@PathVariable(name = "idUsuario") int id){
        try {
          return usuarioService.findUsuario(id);
       }
        catch (RuntimeException e){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
       }
    }
    
}
