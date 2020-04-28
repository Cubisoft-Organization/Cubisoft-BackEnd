package pe.edu.upc.cubisoft.restservicecubisoft.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;
import pe.edu.upc.cubisoft.restservicecubisoft.model.MUsuario;

import java.util.ArrayList;
import java.util.List;

@Component("mapper")
public class Mapper {

    public static List<MUsuario> convertirLista(List<Usuario> usuarios){
        List<MUsuario> mUsuarios = new ArrayList<>();
        for(Usuario usuario: usuarios){
            mUsuarios.add(new MUsuario(usuario));
        }
        return mUsuarios;
    }
}
