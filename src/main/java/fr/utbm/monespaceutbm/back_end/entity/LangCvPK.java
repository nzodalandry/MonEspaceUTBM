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
public class LangCvPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCV")
    private long idcv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANG")
    private long idlang;

    public LangCvPK() {
    }

    public LangCvPK(long idcv, long idlang) {
        this.idcv = idcv;
        this.idlang = idlang;
    }

    public long getIdcv() {
        return idcv;
    }

    public void setIdcv(long idcv) {
        this.idcv = idcv;
    }

    public long getIdlang() {
        return idlang;
    }

    public void setIdlang(long idlang) {
        this.idlang = idlang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcv;
        hash += (int) idlang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LangCvPK)) {
            return false;
        }
        LangCvPK other = (LangCvPK) object;
        if (this.idcv != other.idcv) {
            return false;
        }
        if (this.idlang != other.idlang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.LangCvPK[ idcv=" + idcv + ", idlang=" + idlang + " ]";
    }
    
}
