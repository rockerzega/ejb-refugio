/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerzega
 */
@Entity
@Table(name = "BENEFICIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficios.findAll", query = "SELECT b FROM Beneficios b")
    , @NamedQuery(name = "Beneficios.findById", query = "SELECT b FROM Beneficios b WHERE b.id = :id")
    , @NamedQuery(name = "Beneficios.findByFechaAcreditar", query = "SELECT b FROM Beneficios b WHERE b.fechaAcreditar = :fechaAcreditar")})
public class Beneficios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ID", nullable = false, length = 100)
    private String id;
    @Column(name = "FECHA_ACREDITAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcreditar;
    @JoinColumn(name = "BENEFICIOS", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private AdmBeneficio beneficios;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Donador usuario;
    @JoinColumn(name = "REFUGIO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Refugio refugio;

    public Beneficios() {
    }

    public Beneficios(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaAcreditar() {
        return fechaAcreditar;
    }

    public void setFechaAcreditar(Date fechaAcreditar) {
        this.fechaAcreditar = fechaAcreditar;
    }

    public AdmBeneficio getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(AdmBeneficio beneficios) {
        this.beneficios = beneficios;
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
        if (!(object instanceof Beneficios)) {
            return false;
        }
        Beneficios other = (Beneficios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Beneficios[ id=" + id + " ]";
    }
    
}
