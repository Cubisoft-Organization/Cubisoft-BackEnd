package pe.edu.upc.cubisoft.restservicecubisoft.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Premio")
public class Premio implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long premio_id;

    private String descripcion;

    @Column(name = "usuario_id")
    private Long usuarioId;

    private Premio(){

    }

    public Long getPremio_id() {
        return premio_id;
    }

    public void setPremio_id(Long premio_id) {
        this.premio_id = premio_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    private static final long serialVersionUID = 1L;
}
