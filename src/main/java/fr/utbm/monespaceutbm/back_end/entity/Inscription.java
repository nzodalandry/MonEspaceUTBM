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
import javax.validation.constraints.Size;

/**
 *
 * @author danyk
 */
@Entity
@Table(name = "inscription")
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i")})
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscriptionPK inscriptionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEINS")
    @Temporal(TemporalType.DATE)
    private Date dateins;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NIV")
    private int niv;
    @Size(max = 25)
    @Column(name = "DIPLOME")
    private String diplome;
    @JoinColumn(name = "IDFIL", referencedColumnName = "IDFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Filiere filiere;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Inscription() {
    }

    public Inscription(InscriptionPK inscriptionPK) {
        this.inscriptionPK = inscriptionPK;
    }

    public Inscription(InscriptionPK inscriptionPK, Date dateins, int niv) {
        this.inscriptionPK = inscriptionPK;
        this.dateins = dateins;
        this.niv = niv;
    }

    public Inscription(long idfil, long iduser) {
        this.inscriptionPK = new InscriptionPK(idfil, iduser);
    }

    public InscriptionPK getInscriptionPK() {
        return inscriptionPK;
    }

    public void setInscriptionPK(InscriptionPK inscriptionPK) {
        this.inscriptionPK = inscriptionPK;
    }

    public Date getDateins() {
        return dateins;
    }

    public void setDateins(Date dateins) {
        this.dateins = dateins;
    }

    public int getNiv() {
        return niv;
    }

    public void setNiv(int niv) {
        this.niv = niv;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscriptionPK != null ? inscriptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.inscriptionPK == null && other.inscriptionPK != null) || (this.inscriptionPK != null && !this.inscriptionPK.equals(other.inscriptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Inscription[ inscriptionPK=" + inscriptionPK + " ]";
    }
    
}
