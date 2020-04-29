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
public class PrivilegesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSER")
    private long iduser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDROLE")
    private long idrole;

    public PrivilegesPK() {
    }

    public PrivilegesPK(long iduser, long idrole) {
        this.iduser = iduser;
        this.idrole = idrole;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public long getIdrole() {
        return idrole;
    }

    public void setIdrole(long idrole) {
        this.idrole = idrole;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.PrivilegesPK[ iduser=" + iduser + ", idrole=" + idrole + " ]";
    }
    
}
