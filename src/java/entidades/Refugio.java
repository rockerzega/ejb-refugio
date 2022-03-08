/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rockerzega
 */
@Entity
@Table(name = "REFUGIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refugio.findAll", query = "SELECT r FROM Refugio r")
    , @NamedQuery(name = "Refugio.findById", query = "SELECT r FROM Refugio r WHERE r.id = :id")
    , @NamedQuery(name = "Refugio.findByFechaCrea", query = "SELECT r FROM Refugio r WHERE r.fechaCrea = :fechaCrea")
    , @NamedQuery(name = "Refugio.findByHatencion", query = "SELECT r FROM Refugio r WHERE r.hatencion = :hatencion")})
public class Refugio implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refugio")
    private Collection<Donaciones> donacionesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ID", nullable = false, length = 100)
    private String id;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Size(max = 100)
    @Column(name = "HATENCION", length = 100)
    private String hatencion;
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refugio")
    private Collection<UsuarioRefugio> usuarioRefugioCollection;

    public Refugio() {
    }

    public Refugio(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getHatencion() {
        return hatencion;
    }

    public void setHatencion(String hatencion) {
        this.hatencion = hatencion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<UsuarioRefugio> getUsuarioRefugioCollection() {
        return usuarioRefugioCollection;
    }

    public void setUsuarioRefugioCollection(Collection<UsuarioRefugio> usuarioRefugioCollection) {
        this.usuarioRefugioCollection = usuarioRefugioCollection;
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
        if (!(object instanceof Refugio)) {
            return false;
        }
        Refugio other = (Refugio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Refugio[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Donaciones> getDonacionesCollection() {
        return donacionesCollection;
    }

    public void setDonacionesCollection(Collection<Donaciones> donacionesCollection) {
        this.donacionesCollection = donacionesCollection;
    }
    
}
