/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nzoda
 */
@Entity
@Table(name = "departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDEP")
    private Long iddep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMDEP")
    private short numdep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "LIBDEP")
    private String libdep;
    @Column(name = "DATEDEP")
    @Temporal(TemporalType.DATE)
    private Date datedep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddep")
    private Collection<Filiere> filiereCollection;

    public Departement() {
    }

    public Departement(Long iddep) {
        this.iddep = iddep;
    }

    public Departement(Long iddep, short numdep, String libdep) {
        this.iddep = iddep;
        this.numdep = numdep;
        this.libdep = libdep;
    }

    public Long getIddep() {
        return iddep;
    }

    public void setIddep(Long iddep) {
        this.iddep = iddep;
    }

    public short getNumdep() {
        return numdep;
    }

    public void setNumdep(short numdep) {
        this.numdep = numdep;
    }

    public String getLibdep() {
        return libdep;
    }

    public void setLibdep(String libdep) {
        this.libdep = libdep;
    }

    public Date getDatedep() {
        return datedep;
    }

    public void setDatedep(Date datedep) {
        this.datedep = datedep;
    }

    @XmlTransient
    public Collection<Filiere> getFiliereCollection() {
        return filiereCollection;
    }

    public void setFiliereCollection(Collection<Filiere> filiereCollection) {
        this.filiereCollection = filiereCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddep != null ? iddep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.iddep == null && other.iddep != null) || (this.iddep != null && !this.iddep.equals(other.iddep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departement{" + "iddep=" + iddep + ", numdep=" + numdep + ", libdep=" + libdep + ", datedep=" + datedep + '}';
    }

    
}
