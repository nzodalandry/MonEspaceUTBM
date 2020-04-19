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

/**
 *
 * @author danyk
 */
@Entity
@Table(name = "formation")
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f")})
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFOR")
    private Long idfor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DEBUTFOR")
    private String debutfor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FINFOR")
    @Temporal(TemporalType.DATE)
    private Date finfor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LIBFOR")
    private String libfor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FILIEREFOR")
    private String filierefor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ETABLISSEMENTFOR")
    private String etablissementfor;
    @Size(max = 128)
    @Column(name = "COMFOR")
    private String comfor;
    @JoinColumn(name = "IDCV", referencedColumnName = "IDCV")
    @ManyToOne(optional = false)
    private Cv idcv;

    public Formation() {
    }

    public Formation(Long idfor) {
        this.idfor = idfor;
    }

    public Formation(Long idfor, String debutfor, Date finfor, String libfor, String filierefor, String etablissementfor) {
        this.idfor = idfor;
        this.debutfor = debutfor;
        this.finfor = finfor;
        this.libfor = libfor;
        this.filierefor = filierefor;
        this.etablissementfor = etablissementfor;
    }

    public Long getIdfor() {
        return idfor;
    }

    public void setIdfor(Long idfor) {
        this.idfor = idfor;
    }

    public String getDebutfor() {
        return debutfor;
    }

    public void setDebutfor(String debutfor) {
        this.debutfor = debutfor;
    }

    public Date getFinfor() {
        return finfor;
    }

    public void setFinfor(Date finfor) {
        this.finfor = finfor;
    }

    public String getLibfor() {
        return libfor;
    }

    public void setLibfor(String libfor) {
        this.libfor = libfor;
    }

    public String getFilierefor() {
        return filierefor;
    }

    public void setFilierefor(String filierefor) {
        this.filierefor = filierefor;
    }

    public String getEtablissementfor() {
        return etablissementfor;
    }

    public void setEtablissementfor(String etablissementfor) {
        this.etablissementfor = etablissementfor;
    }

    public String getComfor() {
        return comfor;
    }

    public void setComfor(String comfor) {
        this.comfor = comfor;
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
        hash += (idfor != null ? idfor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.idfor == null && other.idfor != null) || (this.idfor != null && !this.idfor.equals(other.idfor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Formation[ idfor=" + idfor + " ]";
    }
    
}
