package pe.edu.upc.cubisoft.restservicecubisoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.cubisoft.restservicecubisoft.dao.IPremioDao;
import pe.edu.upc.cubisoft.restservicecubisoft.entity.Premio;

import java.util.List;

@Service
public class PremioServiceImpl implements IPremioService{

    @Autowired
    private IPremioDao premioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Premio> findAll() {
        return (List<Premio>) premioDao.findAll();
    }

    @Override
    @Transactional
    public void savePremio(Premio premio) {
        premioDao.save(premio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Premio> getPremiosUsuario(Long id) {
        return (List<Premio>) premioDao.findByUsuarioId(id);
    }
}
