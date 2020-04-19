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
@Table(name = "centre_interet")
@NamedQueries({
    @NamedQuery(name = "CentreInteret.findAll", query = "SELECT c FROM CentreInteret c")})
public class CentreInteret implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCENT")
    private Long idcent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "LIBCENT")
    private String libcent;
    @JoinColumn(name = "IDCV", referencedColumnName = "IDCV")
    @ManyToOne(optional = false)
    private Cv idcv;

    public CentreInteret() {
    }

    public CentreInteret(Long idcent) {
        this.idcent = idcent;
    }

    public CentreInteret(Long idcent, String libcent) {
        this.idcent = idcent;
        this.libcent = libcent;
    }

    public Long getIdcent() {
        return idcent;
    }

    public void setIdcent(Long idcent) {
        this.idcent = idcent;
    }

    public String getLibcent() {
        return libcent;
    }

    public void setLibcent(String libcent) {
        this.libcent = libcent;
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
        hash += (idcent != null ? idcent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentreInteret)) {
            return false;
        }
        CentreInteret other = (CentreInteret) object;
        if ((this.idcent == null && other.idcent != null) || (this.idcent != null && !this.idcent.equals(other.idcent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.CentreInteret[ idcent=" + idcent + " ]";
    }
    
}
