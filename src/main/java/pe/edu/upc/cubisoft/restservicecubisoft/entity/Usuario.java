package pe.edu.upc.cubisoft.restservicecubisoft.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombres")
    private String nombres;

    @Column(length = 60, unique = true)
    private String email;

    private String password;

    @Column(length = 2000)
    private String foto;

    @Column(name= "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Premio> premio = new ArrayList<>();

    public List<Premio> getPremio() {
        return premio;
    }

    public void setPremio(List<Premio> premio) {
        this.premio = premio;
    }

    @PrePersist
    public void prePersist()
    {
        createAt = new Date();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    private static final long serialVersionUID = 1L;
}
