package pe.edu.upc.cubisoft.restservicecubisoft.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Premio;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;

import java.util.List;

public interface IPremioDao extends CrudRepository<Premio, Long> {

    public List<Premio> findByUsuarioId(Long id);

}
