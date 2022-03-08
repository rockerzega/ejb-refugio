/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerzega
 */
@Entity
@Table(name = "usuario-refugio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRefugio.findAll", query = "SELECT u FROM UsuarioRefugio u")
    , @NamedQuery(name = "UsuarioRefugio.findById", query = "SELECT u FROM UsuarioRefugio u WHERE u.id = :id")})
public class UsuarioRefugio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ID", nullable = false, length = 100)
    private String id;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Donador usuario;
    @JoinColumn(name = "REFUGIO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Refugio refugio;

    public UsuarioRefugio() {
    }

    public UsuarioRefugio(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Donador getUsuario() {
        return usuario;
    }

    public void setUsuario(Donador usuario) {
        this.usuario = usuario;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRefugio)) {
            return false;
        }
        UsuarioRefugio other = (UsuarioRefugio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UsuarioRefugio[ id=" + id + " ]";
    }
    
}
