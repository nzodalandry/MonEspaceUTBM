/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author danyk
 */
@Entity
@Table(name = "competence")
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c")})
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMP")
    private Long idcomp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LIBCOMP")
    private String libcomp;
    @Size(max = 30)
    @Column(name = "CATCOMP")
    private String catcomp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NIVCOMP")
    private String nivcomp;
    @JoinColumn(name = "IDCV", referencedColumnName = "IDCV")
    @ManyToOne(optional = false)
    private Cv idcv;

    public Competence() {
    }

    public Competence(Long idcomp) {
        this.idcomp = idcomp;
    }

    public Competence(Long idcomp, String libcomp, String nivcomp) {
        this.idcomp = idcomp;
        this.libcomp = libcomp;
        this.nivcomp = nivcomp;
    }

    public Long getIdcomp() {
        return idcomp;
    }

    public void setIdcomp(Long idcomp) {
        this.idcomp = idcomp;
    }

    public String getLibcomp() {
        return libcomp;
    }

    public void setLibcomp(String libcomp) {
        this.libcomp = libcomp;
    }

    public String getCatcomp() {
        return catcomp;
    }

    public void setCatcomp(String catcomp) {
        this.catcomp = catcomp;
    }

    public String getNivcomp() {
        return nivcomp;
    }

    public void setNivcomp(String nivcomp) {
        this.nivcomp = nivcomp;
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
        hash += (idcomp != null ? idcomp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.idcomp == null && other.idcomp != null) || (this.idcomp != null && !this.idcomp.equals(other.idcomp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Competence[ idcomp=" + idcomp + " ]";
    }
    
}
