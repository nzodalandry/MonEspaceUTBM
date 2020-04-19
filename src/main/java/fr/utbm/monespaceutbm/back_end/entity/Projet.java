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
@Table(name = "projet")
@NamedQueries({
    @NamedQuery(name = "Projet.findAll", query = "SELECT p FROM Projet p")})
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROJ")
    private Long idproj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMPROJ")
    private String nomproj;
    @Size(max = 128)
    @Column(name = "DESCPROJ")
    private String descproj;
    @Size(max = 128)
    @Column(name = "LIENPROJ")
    private String lienproj;
    @JoinColumn(name = "IDTYPEPROJ", referencedColumnName = "IDTYPEPROJ")
    @ManyToOne(optional = false)
    private TypeDeProjet idtypeproj;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Utilisateur iduser;

    public Projet() {
    }

    public Projet(Long idproj) {
        this.idproj = idproj;
    }

    public Projet(Long idproj, String nomproj) {
        this.idproj = idproj;
        this.nomproj = nomproj;
    }

    public Long getIdproj() {
        return idproj;
    }

    public void setIdproj(Long idproj) {
        this.idproj = idproj;
    }

    public String getNomproj() {
        return nomproj;
    }

    public void setNomproj(String nomproj) {
        this.nomproj = nomproj;
    }

    public String getDescproj() {
        return descproj;
    }

    public void setDescproj(String descproj) {
        this.descproj = descproj;
    }

    public String getLienproj() {
        return lienproj;
    }

    public void setLienproj(String lienproj) {
        this.lienproj = lienproj;
    }

    public TypeDeProjet getIdtypeproj() {
        return idtypeproj;
    }

    public void setIdtypeproj(TypeDeProjet idtypeproj) {
        this.idtypeproj = idtypeproj;
    }

    public Utilisateur getIduser() {
        return iduser;
    }

    public void setIduser(Utilisateur iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproj != null ? idproj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.idproj == null && other.idproj != null) || (this.idproj != null && !this.idproj.equals(other.idproj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Projet[ idproj=" + idproj + " ]";
    }
    
}
