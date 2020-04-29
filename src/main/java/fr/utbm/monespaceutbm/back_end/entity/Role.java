/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author nzoda
 */
@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDROLE")
    private Long idrole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "LIBROLE")
    private String librole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<Privileges> privilegesCollection;

    public Role() {
    }

    public Role(Long idrole) {
        this.idrole = idrole;
    }

    public Role(Long idrole, String librole) {
        this.idrole = idrole;
        this.librole = librole;
    }

    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }

    public String getLibrole() {
        return librole;
    }

    public void setLibrole(String librole) {
        this.librole = librole;
    }

    @XmlTransient
    public Collection<Privileges> getPrivilegesCollection() {
        return privilegesCollection;
    }

    public void setPrivilegesCollection(Collection<Privileges> privilegesCollection) {
        this.privilegesCollection = privilegesCollection;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Role[ idrole=" + idrole + " ]";
    }
    
}
