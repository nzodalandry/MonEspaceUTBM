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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nzoda
 */
@Entity
@Table(name = "privileges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privileges.findAll", query = "SELECT p FROM Privileges p")})
public class Privileges implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrivilegesPK privilegesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "IDROLE", referencedColumnName = "IDROLE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public Privileges() {
    }

    public Privileges(PrivilegesPK privilegesPK) {
        this.privilegesPK = privilegesPK;
    }

    public Privileges(PrivilegesPK privilegesPK, Date date) {
        this.privilegesPK = privilegesPK;
        this.date = date;
    }

    public Privileges(long iduser, long idrole) {
        this.privilegesPK = new PrivilegesPK(iduser, idrole);
    }

    public PrivilegesPK getPrivilegesPK() {
        return privilegesPK;
    }

    public void setPrivilegesPK(PrivilegesPK privilegesPK) {
        this.privilegesPK = privilegesPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Privileges[ privilegesPK=" + privilegesPK + " ]";
    }
    
}
