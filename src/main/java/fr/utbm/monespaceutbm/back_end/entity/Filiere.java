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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "filiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f")})
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFIL")
    private Long idfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODEFIL")
    private String codefil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "LIBFIL")
    private String libfil;
    @JoinColumn(name = "IDDEP", referencedColumnName = "IDDEP")
    @ManyToOne(optional = false)
    private Departement iddep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filiere")
    private Collection<Inscription> inscriptionCollection;

    public Filiere() {
    }

    public Filiere(Long idfil) {
        this.idfil = idfil;
    }

    public Filiere(Long idfil, String codefil, String libfil, Departement iddep) {
        this.idfil = idfil;
        this.codefil = codefil;
        this.libfil = libfil;
        this.iddep = iddep;
    }

    public Long getIdfil() {
        return idfil;
    }

    public void setIdfil(Long idfil) {
        this.idfil = idfil;
    }

    public String getCodefil() {
        return codefil;
    }

    public void setCodefil(String codefil) {
        this.codefil = codefil;
    }

    public String getLibfil() {
        return libfil;
    }

    public void setLibfil(String libfil) {
        this.libfil = libfil;
    }

    public Departement getIddep() {
        return iddep;
    }

    public void setIddep(Departement iddep) {
        this.iddep = iddep;
    }

    @XmlTransient
    public Collection<Inscription> getInscriptionCollection() {
        return inscriptionCollection;
    }

    public void setInscriptionCollection(Collection<Inscription> inscriptionCollection) {
        this.inscriptionCollection = inscriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfil != null ? idfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.idfil == null && other.idfil != null) || (this.idfil != null && !this.idfil.equals(other.idfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filiere{" + "idfil=" + idfil + ", codefil=" + codefil + ", libfil=" + libfil + ", iddep=" + iddep.toString() +'}';
    }

   
}
