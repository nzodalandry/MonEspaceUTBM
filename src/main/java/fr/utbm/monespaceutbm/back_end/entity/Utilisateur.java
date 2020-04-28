/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
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

/**
 *
 * @author danyk
 */
@Entity
@Table(name = "utilisateur")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private Long iduser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMUSER")
    private String nomuser;
    @Size(max = 40)
    @Column(name = "PRENOMUSER")
    private String prenomuser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXEUSER")
    private Character sexeuser;
    @Size(max = 18)
    @Column(name = "TELUSER")
    private String teluser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MAILUSER")
    private String mailuser;
    @Column(name = "DATENAISUSER")
    @Temporal(TemporalType.DATE)
    private Date datenaisuser;
    @Size(max = 50)
    @Column(name = "PHOTOUSER")
    private String photouser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ADRVOIE")
    private String adrvoie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ADRCP")
    private String adrcp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ADRVILLE")
    private String adrville;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ADRPAYS")
    private String adrpays;
    @Size(max = 50)
    @Column(name = "ADRCOMP")
    private String adrcomp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Privileges> privilegesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Cv> cvCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Projet> projetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Inscription> inscriptionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Evenement> evenementCollection;

    public Utilisateur() {
    }

    public Utilisateur(Long iduser) {
        this.iduser = iduser;
    }

    public Utilisateur(String nomuser, Character sexeuser, String mailuser, String adrvoie, String adrcp, String adrville, String adrpays, String password, String username) {
        this.nomuser = nomuser;
        this.sexeuser = sexeuser;
        this.mailuser = mailuser;
        this.adrvoie = adrvoie;
        this.adrcp = adrcp;
        this.adrville = adrville;
        this.adrpays = adrpays;
        this.password = password;
        this.username = username;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getPrenomuser() {
        return prenomuser;
    }

    public void setPrenomuser(String prenomuser) {
        this.prenomuser = prenomuser;
    }

    public Character getSexeuser() {
        return sexeuser;
    }

    public void setSexeuser(Character sexeuser) {
        this.sexeuser = sexeuser;
    }

    public String getTeluser() {
        return teluser;
    }

    public void setTeluser(String teluser) {
        this.teluser = teluser;
    }

    public String getMailuser() {
        return mailuser;
    }

    public void setMailuser(String mailuser) {
        this.mailuser = mailuser;
    }

    public Date getDatenaisuser() {
        return datenaisuser;
    }

    public void setDatenaisuser(Date datenaisuser) {
        this.datenaisuser = datenaisuser;
    }

    public String getPhotouser() {
        return photouser;
    }

    public void setPhotouser(String photouser) {
        this.photouser = photouser;
    }

    public String getAdrvoie() {
        return adrvoie;
    }

    public void setAdrvoie(String adrvoie) {
        this.adrvoie = adrvoie;
    }

    public String getAdrcp() {
        return adrcp;
    }

    public void setAdrcp(String adrcp) {
        this.adrcp = adrcp;
    }

    public String getAdrville() {
        return adrville;
    }

    public void setAdrville(String adrville) {
        this.adrville = adrville;
    }

    public String getAdrpays() {
        return adrpays;
    }

    public void setAdrpays(String adrpays) {
        this.adrpays = adrpays;
    }

    public String getAdrcomp() {
        return adrcomp;
    }

    public void setAdrcomp(String adrcomp) {
        this.adrcomp = adrcomp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Privileges> getPrivilegesCollection() {
        return privilegesCollection;
    }

    public void setPrivilegesCollection(Collection<Privileges> privilegesCollection) {
        this.privilegesCollection = privilegesCollection;
    }

    public Collection<Cv> getCvCollection() {
        return cvCollection;
    }

    public void setCvCollection(Collection<Cv> cvCollection) {
        this.cvCollection = cvCollection;
    }

    public Collection<Projet> getProjetCollection() {
        return projetCollection;
    }

    public void setProjetCollection(Collection<Projet> projetCollection) {
        this.projetCollection = projetCollection;
    }

    public Collection<Inscription> getInscriptionCollection() {
        return inscriptionCollection;
    }

    public void setInscriptionCollection(Collection<Inscription> inscriptionCollection) {
        this.inscriptionCollection = inscriptionCollection;
    }

    public Collection<Evenement> getEvenementCollection() {
        return evenementCollection;
    }

    public void setEvenementCollection(Collection<Evenement> evenementCollection) {
        this.evenementCollection = evenementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.prenomuser, other.prenomuser)) {
            return false;
        }
        if (!Objects.equals(this.mailuser, other.mailuser)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.nomuser, other.nomuser)) {
            return false;
        } else if (!Objects.equals(this.prenomuser, other.prenomuser)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "iduser=" + iduser + ", nomuser=" + nomuser + ", prenomuser=" + prenomuser + ", sexeuser=" + sexeuser + ", teluser=" + teluser + ", mailuser=" + mailuser + ", datenaisuser=" + datenaisuser + ", photouser=" + photouser + ", adrvoie=" + adrvoie + ", adrcp=" + adrcp + ", adrville=" + adrville + ", adrpays=" + adrpays + ", adrcomp=" + adrcomp + ", password=" + password + ", username=" + username + '}';
    }

}
