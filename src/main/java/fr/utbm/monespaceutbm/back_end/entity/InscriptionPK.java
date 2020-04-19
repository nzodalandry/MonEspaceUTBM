/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nzoda
 */
@Embeddable
public class InscriptionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFIL")
    private long idfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSER")
    private long iduser;

    public InscriptionPK() {
    }

    public InscriptionPK(long idfil, long iduser) {
        this.idfil = idfil;
        this.iduser = iduser;
    }

    public long getIdfil() {
        return idfil;
    }

    public void setIdfil(long idfil) {
        this.idfil = idfil;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idfil;
        hash += (int) iduser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscriptionPK)) {
            return false;
        }
        InscriptionPK other = (InscriptionPK) object;
        if (this.idfil != other.idfil) {
            return false;
        }
        if (this.iduser != other.iduser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.InscriptionPK[ idfil=" + idfil + ", iduser=" + iduser + " ]";
    }
    
}
