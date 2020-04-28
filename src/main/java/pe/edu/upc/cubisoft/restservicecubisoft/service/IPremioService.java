package pe.edu.upc.cubisoft.restservicecubisoft.service;

import pe.edu.upc.cubisoft.restservicecubisoft.entity.Premio;

import java.util.List;

public interface IPremioService {
    public List<Premio> findAll();
    public void savePremio(Premio premio);
    public List<Premio> getPremiosUsuario(Long id);
}
