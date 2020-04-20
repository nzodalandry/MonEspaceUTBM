/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author nzoda
 */
@Entity
@Table(name = "experience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e")})
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEXP")
    private Long idexp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEBUTEXP")
    @Temporal(TemporalType.DATE)
    private Date debutexp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "FINEXP")
    private String finexp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "POSTEEXP")
    private String posteexp;
    @Size(max = 128)
    @Column(name = "DESCEXP")
    private String descexp;
    @JoinColumn(name = "IDCV", referencedColumnName = "IDCV")
    @ManyToOne(optional = false)
    private Cv idcv;

    public Experience() {
    }

    public Experience(Long idexp) {
        this.idexp = idexp;
    }

    public Experience(Long idexp, Date debutexp, String finexp, String posteexp) {
        this.idexp = idexp;
        this.debutexp = debutexp;
        this.finexp = finexp;
        this.posteexp = posteexp;
    }

    public Long getIdexp() {
        return idexp;
    }

    public void setIdexp(Long idexp) {
        this.idexp = idexp;
    }

    public Date getDebutexp() {
        return debutexp;
    }

    public void setDebutexp(Date debutexp) {
        this.debutexp = debutexp;
    }

    public String getFinexp() {
        return finexp;
    }

    public void setFinexp(String finexp) {
        this.finexp = finexp;
    }

    public String getPosteexp() {
        return posteexp;
    }

    public void setPosteexp(String posteexp) {
        this.posteexp = posteexp;
    }

    public String getDescexp() {
        return descexp;
    }

    public void setDescexp(String descexp) {
        this.descexp = descexp;
    }

    public Cv getIdcv() {
        return idcv;
    }

    public void setIdcv(Cv idcv) {
        this.idcv = idcv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexp != null ? idexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experience)) {
            return false;
        }
        Experience other = (Experience) object;
        if ((this.idexp == null && other.idexp != null) || (this.idexp != null && !this.idexp.equals(other.idexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Experience[ idexp=" + idexp + " ]";
    }
    
}
