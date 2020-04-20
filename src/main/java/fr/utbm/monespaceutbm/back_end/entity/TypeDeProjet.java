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
@Table(name = "type_de_projet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeDeProjet.findAll", query = "SELECT t FROM TypeDeProjet t")})
public class TypeDeProjet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTYPEPROJ")
    private Long idtypeproj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LIBTYPEPROJ")
    private String libtypeproj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypeproj")
    private Collection<Projet> projetCollection;

    public TypeDeProjet() {
    }

    public TypeDeProjet(Long idtypeproj) {
        this.idtypeproj = idtypeproj;
    }

    public TypeDeProjet(Long idtypeproj, String libtypeproj) {
        this.idtypeproj = idtypeproj;
        this.libtypeproj = libtypeproj;
    }

    public Long getIdtypeproj() {
        return idtypeproj;
    }

    public void setIdtypeproj(Long idtypeproj) {
        this.idtypeproj = idtypeproj;
    }

    public String getLibtypeproj() {
        return libtypeproj;
    }

    public void setLibtypeproj(String libtypeproj) {
        this.libtypeproj = libtypeproj;
    }

    @XmlTransient
    public Collection<Projet> getProjetCollection() {
        return projetCollection;
    }

    public void setProjetCollection(Collection<Projet> projetCollection) {
        this.projetCollection = projetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeproj != null ? idtypeproj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeDeProjet)) {
            return false;
        }
        TypeDeProjet other = (TypeDeProjet) object;
        if ((this.idtypeproj == null && other.idtypeproj != null) || (this.idtypeproj != null && !this.idtypeproj.equals(other.idtypeproj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.TypeDeProjet[ idtypeproj=" + idtypeproj + " ]";
    }
    
}
