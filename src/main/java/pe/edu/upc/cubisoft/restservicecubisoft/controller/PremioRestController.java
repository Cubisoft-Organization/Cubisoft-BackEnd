package pe.edu.upc.cubisoft.restservicecubisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Premio;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;
import pe.edu.upc.cubisoft.restservicecubisoft.service.IPremioService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PremioRestController {
    @Autowired
    private IPremioService premioService;

    @GetMapping("/premios")
    public ResponseEntity<?> listaPremios(){
        List<Premio> listaPremios = premioService.findAll();
        if(listaPremios!=null){
            if(listaPremios.size()!=0){
                return new ResponseEntity<>(listaPremios, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_premio")
    public ResponseEntity<?> agregarPremio(@RequestBody Premio premio){
        premioService.savePremio(premio);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/premios_usuarios")
    public ResponseEntity<?> verPremiosUsuarios(@RequestBody Usuario usuario){
        List<Premio> listaPremios = premioService.getPremiosUsuario(usuario.getId());
        if(listaPremios!=null){
            if(listaPremios.size()!=0){
                return new ResponseEntity<>(listaPremios, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
