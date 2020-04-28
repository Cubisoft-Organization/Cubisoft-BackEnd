package pe.edu.upc.cubisoft.restservicecubisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;
import pe.edu.upc.cubisoft.restservicecubisoft.mapper.Mapper;
import pe.edu.upc.cubisoft.restservicecubisoft.model.MUsuario;
import pe.edu.upc.cubisoft.restservicecubisoft.service.IUsuarioService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getUsuarios(){
        return usuarioService.findAll();
    }

    @PostMapping("/find_usuario")
    public ResponseEntity<?> findUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioDb = usuarioService.findUsuario(usuario);
        if(usuarioDb!=null){
            return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/sign_up")
    public ResponseEntity<Void> addUsuario(@RequestBody Usuario usuario){
        if(usuarioService.findUsuario(usuario)==null){
            usuarioService.save(usuario);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> loginUsuario(@RequestBody Usuario usuario){
        Usuario usuarioBd = usuarioService.checkUsuarioLogin(usuario);
        if(usuarioBd!=null){
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(usuarioBd);
            List<MUsuario> mUsuarios = new ArrayList<>();
            mUsuarios = Mapper.convertirLista(usuarios);
            return new ResponseEntity<>(mUsuarios, HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable(value = "id")Long id, @RequestBody Usuario usuario){
        Usuario usuarioDb = null;
        usuarioDb = usuarioService.findById(id);
        if(usuarioDb != null){
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setNombres(usuario.getNombres());
            usuarioService.updateUsuario(usuarioDb);
            return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update_sql")
    public ResponseEntity<?> updateUsuarioSql(@RequestBody Usuario usuario){
        Usuario usuarioDb = null;
        usuarioDb = usuarioService.findByIdSQL(usuario.getId());
        if(usuarioDb != null){
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setNombres(usuario.getNombres());
            usuarioService.updateUsuario(usuarioDb);
            return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable(value = "id")Long id){
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllUsuario(){
        usuarioService.deleteAllUsuario();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    /*
    @PostMapping("delete_post")
    public ResponseEntity<Void> deleteUsuarioPost(@RequestBody Usuario usuario){
        if(usuarioService.findUsuario(usuario)==null){
            usuarioService.deleteUsuario(usuario);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }
    */
}
