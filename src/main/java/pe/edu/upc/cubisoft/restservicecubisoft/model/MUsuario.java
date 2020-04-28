package pe.edu.upc.cubisoft.restservicecubisoft.model;

import pe.edu.upc.cubisoft.restservicecubisoft.entity.Usuario;

public class MUsuario {
    private Long id;
    private String nombres;
    private String email;
    private String foto;

    public MUsuario() {
    }

    public MUsuario(Long id, String nombres, String email, String foto) {
        super();
        this.id = id;
        this.nombres = nombres;
        this.email = email;
        this.foto = foto;
    }

    public MUsuario(Usuario usuario){
        this.id = usuario.getId();
        this.nombres = usuario.getNombres();
        this.email = usuario.getEmail();
        this.foto = usuario.getFoto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
