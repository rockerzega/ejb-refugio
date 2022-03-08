/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rockerzega
 */
@Entity
@Table(name = "ADM_BENEFICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmBeneficio.findAll", query = "SELECT a FROM AdmBeneficio a")
    , @NamedQuery(name = "AdmBeneficio.findById", query = "SELECT a FROM AdmBeneficio a WHERE a.id = :id")
    , @NamedQuery(name = "AdmBeneficio.findByDescripcion", query = "SELECT a FROM AdmBeneficio a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AdmBeneficio.findByPuntos", query = "SELECT a FROM AdmBeneficio a WHERE a.puntos = :puntos")})
public class AdmBeneficio implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficios")
    private Collection<Beneficios> beneficiosCollection;

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
    private Long puntos;

    public AdmBeneficio() {
    }

    public AdmBeneficio(String id) {
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

    public Long getPuntos() {
        return puntos;
    }

    public void setPuntos(Long puntos) {
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
        if (!(object instanceof AdmBeneficio)) {
            return false;
        }
        AdmBeneficio other = (AdmBeneficio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AdmBeneficio[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Beneficios> getBeneficiosCollection() {
        return beneficiosCollection;
    }

    public void setBeneficiosCollection(Collection<Beneficios> beneficiosCollection) {
        this.beneficiosCollection = beneficiosCollection;
    }
    
}
