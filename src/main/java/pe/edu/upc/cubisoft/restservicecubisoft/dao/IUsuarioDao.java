package pe.edu.upc.cubisoft.restservicecubisoft.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;

import java.util.Optional;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    public Usuario findByEmail(String email);

    public Usuario findByEmailAndPassword(String email, String password);

    public Optional<Usuario> findById(Long id);

    @Query("select p from Usuario p where p.id=?1")
    public Usuario findByIdSQL(Long id);
}
