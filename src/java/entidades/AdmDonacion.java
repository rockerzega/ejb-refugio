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
@Table(name = "ADM_DONACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmDonacion.findAll", query = "SELECT a FROM AdmDonacion a")
    , @NamedQuery(name = "AdmDonacion.findById", query = "SELECT a FROM AdmDonacion a WHERE a.id = :id")
    , @NamedQuery(name = "AdmDonacion.findByDescripcion", query = "SELECT a FROM AdmDonacion a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AdmDonacion.findByPuntos", query = "SELECT a FROM AdmDonacion a WHERE a.puntos = :puntos")})
public class AdmDonacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ID", nullable = false, length = 100)
    private String id;
    @Size(max = 100)
    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;
    @Column(name = "PUNTOS")
    private Integer puntos;

    public AdmDonacion() {
    }

    public AdmDonacion(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
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
        if (!(object instanceof AdmDonacion)) {
            return false;
        }
        AdmDonacion other = (AdmDonacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AdmDonacion[ id=" + id + " ]";
    }
    
}
