package pe.edu.upc.cubisoft.restservicecubisoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.cubisoft.restservicecubisoft.dao.IUsuarioDao;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findUsuario(Usuario usuario) {
        return (Usuario) usuarioDao.findByEmail(usuario.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario checkUsuarioLogin(Usuario usuario) {
        return (Usuario) usuarioDao.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
    }

    @Override
    @Transactional
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.deleteById(usuario.getId());
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        return (Usuario) usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findUsuarioById(Long usuario_id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public void deleteUsuario(Long id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario findByIdSQL(Long id) {
        return usuarioDao.findByIdSQL(id);
    }

    @Override
    @Transactional
    public void deleteAllUsuario() {
        usuarioDao.deleteAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }
}
