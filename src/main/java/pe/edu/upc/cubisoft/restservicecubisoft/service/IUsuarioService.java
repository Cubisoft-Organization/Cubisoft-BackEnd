package pe.edu.upc.cubisoft.restservicecubisoft.service;

import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Usuario findUsuario(Usuario usuario);

    public Usuario checkUsuarioLogin(Usuario usuario);

    public void deleteUsuario(Usuario usuario);

    public Usuario updateUsuario(Usuario usuario);

    public Optional<Usuario> findUsuarioById(Long usuario_id);

    public void deleteUsuario(Long id);

    public Usuario findById(Long id);

    public Usuario findByIdSQL(Long id);

    public void deleteAllUsuario();
}
